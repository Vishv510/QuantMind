const navItems = [
  { label: 'Dashboard', active: true },
  { label: 'Portfolio', active: false },
  { label: 'Market', active: false },
  { label: 'Orders', active: false },
  { label: 'Alerts', active: false }
];

export default function Sidebar() {
  return (
    <aside className="sidebar">
      <div className="brand-block">
        <span className="brand-mark">RTA</span>
        <div>
          <h1>Realtime</h1>
          <p>Stock analytics</p>
        </div>
      </div>

      <nav>
        <ul>
          {navItems.map((item) => (
            <li key={item.label} className={item.active ? 'active' : ''}>
              {item.label}
            </li>
          ))}
        </ul>
      </nav>

      <div className="sidebar-footer">
        <p>Pro-level charts, watchlists, alerts and portfolio tracking.</p>
      </div>
    </aside>
  );
}
