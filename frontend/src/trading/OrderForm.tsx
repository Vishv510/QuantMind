import { Card } from '../common/Card';
import { Button } from '../common/Button';

export function OrderForm() {
  return (
    <Card title="Order form" subtitle="Manual entry" className="col-span-12 lg:col-span-6">
      <div className="space-y-3">
        <label className="block text-sm text-slate-600">
          Order type
          <select className="mt-2 w-full rounded-2xl border border-slate-200 bg-slate-50 px-3 py-3 outline-none">
            <option>Limit</option>
            <option>Market</option>
          </select>
        </label>
        <label className="block text-sm text-slate-600">
          Price
          <input className="mt-2 w-full rounded-2xl border border-slate-200 bg-slate-50 px-3 py-3 outline-none" defaultValue="2845" />
        </label>
        <Button className="w-full">Review order</Button>
      </div>
    </Card>
  );
}
