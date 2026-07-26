import { ArrowUpRight, TrendingUp } from 'lucide-react';
import { Card } from '../common/Card';
import { formatCurrency, formatPercent } from '../utils/format';
import { portfolioValue, todaysPnl, totalReturn } from '../services/mockData';

export function PortfolioSummary() {
  return (
    <Card className="col-span-12 lg:col-span-8 overflow-hidden border-slate-200/80 bg-gradient-to-br from-slate-900 via-slate-900 to-brand-700 text-white">
      <div className="flex flex-wrap items-start justify-between gap-4">
        <div>
          <p className="text-sm text-slate-300">Portfolio value</p>
          <h2 className="mt-2 text-3xl font-semibold">{formatCurrency(portfolioValue)}</h2>
        </div>
        <div className="rounded-2xl bg-white/15 px-3 py-2 text-sm font-medium text-emerald-300">
          <span className="flex items-center gap-2"><TrendingUp size={16} />{formatPercent(totalReturn)} this month</span>
        </div>
      </div>
      <div className="mt-6 grid gap-4 md:grid-cols-2">
        <div className="rounded-[20px] border border-white/15 bg-white/10 p-4">
          <p className="text-sm text-slate-300">Today&apos;s P/L</p>
          <p className="mt-2 flex items-center gap-2 text-2xl font-semibold text-emerald-300">
            <ArrowUpRight size={20} />{formatCurrency(todaysPnl)}
          </p>
        </div>
        <div className="rounded-[20px] border border-white/15 bg-white/10 p-4">
          <p className="text-sm text-slate-300">Risk score</p>
          <p className="mt-2 text-2xl font-semibold text-white">Moderate</p>
        </div>
      </div>
    </Card>
  );
}
