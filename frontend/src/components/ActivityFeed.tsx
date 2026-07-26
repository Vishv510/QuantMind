import { activities } from '../data/mockData';

export default function ActivityFeed() {
  return (
    <section className="activity-card">
      <div className="card-title">
        <h3>Recent activity</h3>
        <span>Latest portfolio and alert updates</span>
      </div>
      <ul className="activity-list">
        {activities.map((activity) => (
          <li className="activity-item" key={activity.title}>
            <div className="activity-meta">
              <strong>{activity.title}</strong>
              <span>{activity.timestamp}</span>
            </div>
            <div className="activity-value">{activity.change}</div>
          </li>
        ))}
      </ul>
    </section>
  );
}
