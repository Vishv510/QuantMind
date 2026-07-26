import { Card } from '../common/Card';
import { sectors } from '../services/mockData';
import { formatPercent } from '../utils/format';

export function SectorPerformance() {
  return (
    <Card title="Sector performance" subtitle="Allocation and movement" className="col-span-12 lg:col-span-6">
      <div className="space-y-3">
        {sectors.map((sector) => (
          <div key={sector.name} className="rounded-2xl border border-slate-200 bg-slate-50 p-4">
            <div className="flex items-center justify-between">
              <p className="font-semibold text-slate-900">{sector.name}</p>
              <p className={`text-sm ${sector.change >= 0 ? 'text-emerald-600' : 'text-rose-600'}`}>{formatPercent(sector.change)}</p>
            </div>
            <div className="mt-3 h-2 rounded-full bg-slate-200">
              <div className="h-2 rounded-full bg-brand-600" style={{ width: `${sector.value}%` }} />
            </div>
          </div>
        ))}
      </div>
    </Card>
  );
}
