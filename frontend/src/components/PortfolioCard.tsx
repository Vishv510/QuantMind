import { portfolioSummary } from '../data/mockData';

export default function PortfolioCard() {
  return (
    <section className="portfolio-card">
      <div className="card-title">
        <h3>Portfolio snapshot</h3>
        <span>Updated 1 min ago</span>
      </div>
      <p className="portfolio-value">₹24,38,520</p>
      <div className="portfolio-summary">
        {portfolioSummary.map((item) => (
          <div className="summary-item" key={item.label}>
            <strong>{item.value}</strong>
            <span>{item.label}</span>
          </div>
        ))}
      </div>
    </section>
  );
}
