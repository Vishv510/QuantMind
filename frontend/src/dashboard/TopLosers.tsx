import { Card } from '../common/Card';
import { topLosers } from '../services/mockData';
import { formatCurrency, formatPercent } from '../utils/format';

export function TopLosers() {
  return (
    <Card title="Top losers" subtitle="Risk-off names" className="col-span-12 md:col-span-6 xl:col-span-4">
      <div className="space-y-3">
        {topLosers.map((item) => (
          <div key={item.symbol} className="flex items-center justify-between rounded-2xl bg-slate-50 px-4 py-3">
            <div>
              <p className="font-semibold text-slate-900">{item.symbol}</p>
              <p className="text-sm text-slate-500">{item.company}</p>
            </div>
            <div className="text-right">
              <p className="font-semibold text-slate-900">{formatCurrency(item.price)}</p>
              <p className="text-sm text-rose-600">{formatPercent(item.change)}</p>
            </div>
          </div>
        ))}
      </div>
    </Card>
  );
}
