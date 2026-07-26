import { motion } from 'framer-motion';
import { PortfolioSummary } from '../dashboard/PortfolioSummary';
import { MarketOverview } from '../dashboard/MarketOverview';
import { Watchlist } from '../dashboard/Watchlist';
import { TopGainers } from '../dashboard/TopGainers';
import { TopLosers } from '../dashboard/TopLosers';
import { HoldingsTable } from '../dashboard/HoldingsTable';
import { OrdersTable } from '../dashboard/OrdersTable';
import { SectorPerformance } from '../dashboard/SectorPerformance';
import { ActivityFeed } from '../dashboard/ActivityFeed';
import { NewsSection } from '../dashboard/NewsSection';
import { CandlestickChart } from '../charts/CandlestickChart';
import { BuySellPanel } from '../trading/BuySellPanel';
import { OrderBook } from '../trading/OrderBook';

export default function DashboardPage() {
  return (
    <motion.div initial={{ opacity: 0, y: 12 }} animate={{ opacity: 1, y: 0 }} className="space-y-6 p-6 pb-24 lg:p-8">
      <PortfolioSummary />
      <div className="grid gap-6 xl:grid-cols-[1.3fr_0.7fr]">
        <CandlestickChart />
        <BuySellPanel />
      </div>
      <div className="grid gap-6 lg:grid-cols-2">
        <MarketOverview />
        <Watchlist />
      </div>
      <div className="grid gap-6 xl:grid-cols-3">
        <TopGainers />
        <TopLosers />
        <SectorPerformance />
      </div>
      <div className="grid gap-6 xl:grid-cols-[1.2fr_0.8fr]">
        <HoldingsTable />
        <OrdersTable />
      </div>
      <div className="grid gap-6 lg:grid-cols-2">
        <ActivityFeed />
        <OrderBook />
      </div>
      <NewsSection />
    </motion.div>
  );
}
