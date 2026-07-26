export default function TopBar() {
  return (
    <header className="topbar">
      <div>
        <p className="subtitle">Good afternoon, trader</p>
        <h2>Live market action</h2>
      </div>

      <div className="topbar-actions">
        <button className="icon-button">🔔</button>
        <button className="icon-button">💬</button>
        <div className="profile-chip">VM</div>
      </div>
    </header>
  );
}
