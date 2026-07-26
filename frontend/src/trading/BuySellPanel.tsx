import { Card } from '../common/Card';
import { Button } from '../common/Button';

export function BuySellPanel() {
  return (
    <Card title="Trade" subtitle="Fast execution panel" className="col-span-12 lg:col-span-5">
      <div className="space-y-3">
        <label className="block text-sm text-slate-600">
          Symbol
          <input className="mt-2 w-full rounded-2xl border border-slate-200 bg-slate-50 px-3 py-3 outline-none" defaultValue="RELIANCE" />
        </label>
        <label className="block text-sm text-slate-600">
          Quantity
          <input className="mt-2 w-full rounded-2xl border border-slate-200 bg-slate-50 px-3 py-3 outline-none" defaultValue="25" />
        </label>
        <div className="flex gap-3">
          <Button className="flex-1">Buy</Button>
          <Button variant="secondary" className="flex-1">Sell</Button>
        </div>
      </div>
    </Card>
  );
}
