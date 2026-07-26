import { marketOverview } from '../data/mockData';

export default function MarketSummary() {
  return (
    <section className="market-grid">
      {marketOverview.map((item) => (
        <article className="market-card" key={item.label}>
          <div className="card-title">
            <h3>{item.label}</h3>
            <span>{item.category}</span>
          </div>
          <p className="value">{item.value}</p>
          <p className={item.change.startsWith('+') ? 'change-positive' : 'change-negative'}>
            {item.change}
          </p>
        </article>
      ))}
    </section>
  );
}
