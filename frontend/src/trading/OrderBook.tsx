import { Card } from '../common/Card';

export function OrderBook() {
  return (
    <Card title="Order book" subtitle="Buy and sell depth" className="col-span-12 lg:col-span-7">
      <div className="grid gap-3 md:grid-cols-2">
        <div className="rounded-2xl bg-emerald-50 p-4">
          <p className="text-sm text-emerald-700">Best bid</p>
          <p className="mt-2 text-2xl font-semibold text-slate-900">₹2,841</p>
        </div>
        <div className="rounded-2xl bg-rose-50 p-4">
          <p className="text-sm text-rose-700">Best ask</p>
          <p className="mt-2 text-2xl font-semibold text-slate-900">₹2,845</p>
        </div>
      </div>
    </Card>
  );
}
