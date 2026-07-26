import { watchlist } from '../data/mockData';

export default function Watchlist() {
  return (
    <section className="watchlist-card">
      <div className="card-title">
        <h3>Watchlist</h3>
        <span>Track momentum symbols</span>
      </div>
      <table className="watchlist-table">
        <thead>
          <tr>
            <th>Symbol</th>
            <th>Price</th>
            <th>Change</th>
            <th>Volume</th>
          </tr>
        </thead>
        <tbody>
          {watchlist.map((item) => (
            <tr key={item.symbol}>
              <td className="symbol">{item.symbol}</td>
              <td>{item.price}</td>
              <td className={item.change.startsWith('+') ? 'change-positive' : 'change-negative'}>
                {item.change}
              </td>
              <td>{item.volume}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </section>
  );
}
