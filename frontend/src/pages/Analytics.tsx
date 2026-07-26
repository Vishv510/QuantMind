import { motion } from 'framer-motion';
import { Card } from '../common/Card';
import { PerformanceChart } from '../charts/PerformanceChart';
import { PortfolioChart } from '../charts/PortfolioChart';
import { StatCard } from '../common/StatCard';

export default function AnalyticsPage() {
  return (
    <motion.div initial={{ opacity: 0, y: 10 }} animate={{ opacity: 1, y: 0 }} className="space-y-6 p-6 pb-24 lg:p-8">
      <div className="grid gap-6 md:grid-cols-3">
        <StatCard label="Sharpe ratio" value="1.74" subtitle="Risk-adjusted return" />
        <StatCard label="Max drawdown" value="-4.3%" subtitle="Peak-to-trough" tone="negative" />
        <StatCard label="Win rate" value="68%" subtitle="Profitable weeks" tone="positive" />
      </div>
      <div className="grid gap-6 lg:grid-cols-[1.1fr_0.9fr]">
        <Card title="Monthly returns" subtitle="Rolling performance"><PerformanceChart /></Card>
        <Card title="Portfolio growth" subtitle="Historical growth"><PortfolioChart /></Card>
      </div>
      <Card title="AI insights" subtitle="Smart watchlist signals"><p className="text-sm text-slate-600">Momentum remains strong in technology and financials. Rebalance 8% of cash into quality cyclicals for a stronger downside buffer.</p></Card>
    </motion.div>
  );
}
