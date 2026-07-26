import { BarChart3, Bell, BriefcaseBusiness, Compass, Home, LayoutGrid, Newspaper, Settings, Sparkles, TrendingUp, Wallet2 } from 'lucide-react';
import { NavLink } from 'react-router-dom';

const links = [
  { to: '/', label: 'Dashboard', icon: Home },
  { to: '/markets', label: 'Markets', icon: Compass },
  { to: '/portfolio', label: 'Portfolio', icon: Wallet2 },
  { to: '/holdings', label: 'Holdings', icon: BriefcaseBusiness },
  { to: '/orders', label: 'Orders', icon: BarChart3 },
  { to: '/analytics', label: 'Analytics', icon: TrendingUp },
  { to: '/news', label: 'News', icon: Newspaper },
  { to: '/settings', label: 'Settings', icon: Settings },
];

export function Sidebar() {
  return (
    <aside className="hidden h-screen w-72 shrink-0 border-r border-slate-200/80 bg-slate-950/95 p-6 text-slate-100 lg:flex lg:flex-col">
      <div className="flex items-center gap-3">
        <div className="rounded-2xl bg-gradient-to-br from-brand-600 to-cyan-400 p-3 shadow-lg shadow-brand-600/20">
          <Sparkles size={18} />
        </div>
        <div>
          <p className="text-sm text-slate-400">Fintech</p>
          <h2 className="text-lg font-semibold">Northstar Trade</h2>
        </div>
      </div>

      <nav className="mt-8 space-y-2">
        {links.map(({ to, label, icon: Icon }) => (
          <NavLink
            key={to}
            to={to}
            className={({ isActive }) =>
              `flex items-center gap-3 rounded-2xl px-4 py-3 text-sm font-medium transition-all ${isActive ? 'bg-brand-600 text-white shadow-lg shadow-brand-600/20' : 'text-slate-300 hover:bg-slate-800 hover:text-white'}`
            }
          >
            <Icon size={18} />
            {label}
          </NavLink>
        ))}
      </nav>

      <div className="mt-auto rounded-[24px] border border-slate-800 bg-slate-900/70 p-4 text-sm text-slate-400 shadow-inner">
        <p className="font-semibold text-white">Professional-grade analytics</p>
        <p className="mt-2">Track markets, portfolio performance and risk across one unified workspace.</p>
      </div>
    </aside>
  );
}
