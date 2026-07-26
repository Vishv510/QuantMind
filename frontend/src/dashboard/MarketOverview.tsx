import { Card } from '../common/Card';
import { watchlist } from '../services/mockData';
import { formatCurrency, formatPercent } from '../utils/format';

export function MarketOverview() {
  return (
    <Card title="Market overview" subtitle="Key movers and momentum" className="col-span-12 lg:col-span-6">
      <div className="space-y-3">
        {watchlist.slice(0, 4).map((item) => (
          <div key={item.symbol} className="flex items-center justify-between rounded-2xl border border-slate-200 bg-slate-50 px-4 py-3">
            <div>
              <p className="font-semibold text-slate-900">{item.symbol}</p>
              <p className="text-sm text-slate-500">{item.company}</p>
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
