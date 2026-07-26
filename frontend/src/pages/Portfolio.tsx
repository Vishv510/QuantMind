import { motion } from 'framer-motion';
import { Card } from '../common/Card';
import { PortfolioChart } from '../charts/PortfolioChart';
import { PieAllocationChart } from '../charts/PieAllocationChart';
import { PerformanceChart } from '../charts/PerformanceChart';
import { formatCurrency } from '../utils/format';

export default function PortfolioPage() {
  return (
    <motion.div initial={{ opacity: 0, y: 10 }} animate={{ opacity: 1, y: 0 }} className="space-y-6 p-6 pb-24 lg:p-8">
      <div className="grid gap-6 lg:grid-cols-3">
        <Card title="Invested value" subtitle="Capital deployed"><p className="mt-2 text-3xl font-semibold text-slate-900">{formatCurrency(1260000)}</p></Card>
        <Card title="Current value" subtitle="Portfolio value"><p className="mt-2 text-3xl font-semibold text-slate-900">{formatCurrency(1420000)}</p></Card>
        <Card title="Total return" subtitle="Net gain"><p className="mt-2 text-3xl font-semibold text-emerald-600">+12.8%</p></Card>
      </div>
      <div className="grid gap-6 lg:grid-cols-[1.2fr_0.8fr]">
        <Card title="Growth trend" subtitle="Portfolio performance"><PortfolioChart /></Card>
        <Card title="Allocation" subtitle="Sector distribution"><PieAllocationChart /></Card>
      </div>
      <Card title="Performance" subtitle="Monthly P&L"><PerformanceChart /></Card>
    </motion.div>
  );
}
