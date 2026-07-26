import { Star } from 'lucide-react';
import { Card } from '../common/Card';
import { watchlist } from '../services/mockData';
import { formatCurrency, formatPercent } from '../utils/format';

export function Watchlist() {
  return (
    <Card title="Watchlist" subtitle="Pinned and active ideas" className="col-span-12 lg:col-span-6">
      <div className="space-y-3">
        {watchlist.map((item) => (
          <div key={item.symbol} className="flex items-center justify-between rounded-2xl border border-slate-200 bg-white px-4 py-3">
            <div className="flex items-center gap-3">
              <div className="rounded-full bg-slate-100 p-2 text-slate-600"><Star size={14} /></div>
              <div>
                <p className="font-semibold text-slate-900">{item.symbol}</p>
                <p className="text-sm text-slate-500">{item.company}</p>
              </div>
            </div>
            <div className="text-right">
              <p className="font-semibold text-slate-900">{formatCurrency(item.price)}</p>
              <p className={`text-sm ${item.change >= 0 ? 'text-emerald-600' : 'text-rose-600'}`}>{formatPercent(item.change)}</p>
            </div>
          </div>
        ))}
      </div>
    </Card>
  );
}
