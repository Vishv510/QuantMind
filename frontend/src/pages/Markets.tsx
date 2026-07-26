import { motion } from 'framer-motion';
import { Card } from '../common/Card';
import { SearchBar } from '../common/SearchBar';
import { watchlist } from '../services/mockData';
import { formatCurrency, formatPercent } from '../utils/format';

export default function MarketsPage() {
  return (
    <motion.div initial={{ opacity: 0, y: 10 }} animate={{ opacity: 1, y: 0 }} className="space-y-6 p-6 pb-24 lg:p-8">
      <Card title="Market scan" subtitle="Browse active opportunities">
        <div className="flex flex-wrap items-center gap-3">
          <div className="min-w-[240px] flex-1"><SearchBar placeholder="Search equities" /></div>
          <button className="rounded-2xl bg-brand-600 px-4 py-3 text-sm font-semibold text-white">Refresh</button>
        </div>
      </Card>
      <div className="grid gap-4 lg:grid-cols-2">
        {watchlist.map((item) => (
          <Card key={item.symbol} className="flex items-center justify-between">
            <div>
              <p className="font-semibold text-slate-900">{item.symbol}</p>
              <p className="text-sm text-slate-500">{item.company}</p>
            </div>
            <div className="text-right">
              <p className="font-semibold text-slate-900">{formatCurrency(item.price)}</p>
              <p className={`text-sm ${item.change >= 0 ? 'text-emerald-600' : 'text-rose-600'}`}>{formatPercent(item.change)}</p>
            </div>
          </Card>
        ))}
      </div>
    </motion.div>
  );
}
