package com.stock.portfolio.service;
import com.stock.portfolio.dto.*; import com.stock.portfolio.entity.*; import com.stock.portfolio.repository.*; import org.springframework.stereotype.Service; import org.springframework.transaction.annotation.Transactional;
import java.math.*; import java.util.*;
@Service public class PortfolioService {
 private final PortfolioRepository portfolios; private final TransactionRepository transactions;
 public PortfolioService(PortfolioRepository p, TransactionRepository t){portfolios=p;transactions=t;}
 @Transactional public PortfolioResponse buy(TradeRequest r){String s=symbol(r.symbol()); BigDecimal q=scale(r.quantity()), price=scale(r.price()); Optional<Portfolio> existing=portfolios.findByUserIdAndSymbol(r.userId(),s); Portfolio p=existing.orElseGet(()->portfolios.save(Portfolio.create(r.userId(),s,q,price))); if(existing.isPresent()) p.buy(q,price); transactions.save(Transaction.create(p,TransactionType.BUY,q,price,BigDecimal.ZERO.setScale(4))); return response(p);}
 @Transactional public PortfolioResponse sell(TradeRequest r){Portfolio p=find(r.userId(),symbol(r.symbol())); BigDecimal pnl=p.sell(scale(r.quantity()),scale(r.price())); transactions.save(Transaction.create(p,TransactionType.SELL,scale(r.quantity()),scale(r.price()),pnl)); return response(p);}
 @Transactional(readOnly=true) public List<PortfolioResponse> holdings(UUID userId){return portfolios.findByUserIdOrderBySymbolAsc(userId).stream().map(this::response).toList();}
 @Transactional(readOnly=true) public PortfolioResponse holding(UUID userId,String symbol){return response(find(userId,symbol(symbol)));}
 @Transactional(readOnly=true) public List<TransactionResponse> history(UUID userId,String symbol){return transactions.findByPortfolioIdOrderByExecutedAtDesc(find(userId,symbol(symbol)).getId()).stream().map(t->new TransactionResponse(t.getId(),t.getType(),t.getQuantity(),t.getPrice(),t.getRealizedPnl(),t.getExecutedAt())).toList();}
 @Transactional public void updatePrices(String symbol,BigDecimal price){portfolios.findBySymbol(symbol(symbol)).forEach(p->p.updateCurrentPrice(scale(price)));}
 private Portfolio find(UUID u,String s){return portfolios.findByUserIdAndSymbol(u,s).orElseThrow(()->new NoSuchElementException("Portfolio holding not found"));}
 private PortfolioResponse response(Portfolio p){BigDecimal mv=p.getQuantity().multiply(p.getCurrentPrice()).setScale(4,RoundingMode.HALF_UP); BigDecimal up=p.getCurrentPrice().subtract(p.getAverageBuyPrice()).multiply(p.getQuantity()).setScale(4,RoundingMode.HALF_UP); return new PortfolioResponse(p.getId(),p.getUserId(),p.getSymbol(),p.getQuantity(),p.getAverageBuyPrice(),p.getCurrentPrice(),mv,up,p.getRealizedPnl(),up.add(p.getRealizedPnl()),p.getUpdatedAt());}
 private String symbol(String v){return v.trim().toUpperCase(Locale.ROOT);} private BigDecimal scale(BigDecimal v){return v.setScale(4,RoundingMode.HALF_UP);}
}
