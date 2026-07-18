CREATE TABLE portfolios (
    id UUID PRIMARY KEY,
    user_id UUID NOT NULL,
    symbol VARCHAR(10) NOT NULL,
    quantity NUMERIC(19, 4) NOT NULL,
    average_buy_price NUMERIC(19, 4) NOT NULL,
    current_price NUMERIC(19, 4) NOT NULL,
    realized_pnl NUMERIC(19, 4) NOT NULL,
    updated_at TIMESTAMP WITH TIME ZONE NOT NULL,
    version BIGINT NOT NULL,
    CONSTRAINT uk_portfolios_user_symbol UNIQUE (user_id, symbol),
    CONSTRAINT chk_portfolio_quantity_nonnegative CHECK (quantity >= 0)
);

CREATE TABLE transactions (
    id UUID PRIMARY KEY,
    portfolio_id UUID NOT NULL REFERENCES portfolios(id),
    transaction_type VARCHAR(4) NOT NULL,
    quantity NUMERIC(19, 4) NOT NULL,
    price NUMERIC(19, 4) NOT NULL,
    realized_pnl NUMERIC(19, 4) NOT NULL,
    executed_at TIMESTAMP WITH TIME ZONE NOT NULL,
    CONSTRAINT chk_transaction_type CHECK (transaction_type IN ('BUY', 'SELL')),
    CONSTRAINT chk_transaction_quantity_positive CHECK (quantity > 0),
    CONSTRAINT chk_transaction_price_positive CHECK (price > 0)
);

CREATE INDEX idx_portfolios_symbol ON portfolios(symbol);
CREATE INDEX idx_transactions_portfolio_executed_at ON transactions(portfolio_id, executed_at DESC);
