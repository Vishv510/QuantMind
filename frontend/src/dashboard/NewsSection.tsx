import { Card } from '../common/Card';
import { newsItems } from '../services/mockData';
import { Badge } from '../common/Badge';

export function NewsSection() {
  return (
    <Card title="Market news" subtitle="Trends shaping the day" className="col-span-12">
      <div className="grid gap-4 lg:grid-cols-3">
        {newsItems.map((item) => (
          <div key={item.id} className="rounded-[22px] border border-slate-200 bg-slate-50 p-4">
            <div className="flex items-center justify-between gap-3">
              <Badge tone={item.impact === 'High' ? 'danger' : item.impact === 'Medium' ? 'neutral' : 'success'}>{item.impact}</Badge>
              <span className="text-sm text-slate-500">{item.time}</span>
            </div>
            <h4 className="mt-3 font-semibold text-slate-900">{item.title}</h4>
            <p className="mt-2 text-sm text-slate-600">{item.summary}</p>
            <p className="mt-3 text-sm font-medium text-brand-600">Read more →</p>
          </div>
        ))}
      </div>
    </Card>
  );
}
