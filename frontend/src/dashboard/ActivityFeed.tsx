import { Card } from '../common/Card';
import { activityFeed } from '../services/mockData';

export function ActivityFeed() {
  return (
    <Card title="Activity feed" subtitle="Latest portfolio actions" className="col-span-12 lg:col-span-6">
      <div className="space-y-3">
        {activityFeed.map((activity) => (
          <div key={activity.title} className="flex items-center justify-between rounded-2xl border border-slate-200 bg-white px-4 py-3">
            <div>
              <p className="font-semibold text-slate-900">{activity.title}</p>
              <p className="text-sm text-slate-500">{activity.detail}</p>
            </div>
            <div className="text-right">
              <p className="text-sm font-semibold text-slate-900">{activity.value}</p>
              <p className="text-sm text-slate-500">{activity.time}</p>
            </div>
          </div>
        ))}
      </div>
    </Card>
  );
}
