import { NavLink } from 'react-router-dom';
import { BarChart3, BriefcaseBusiness, Compass, Home, Newspaper, Settings, TrendingUp, Wallet2 } from 'lucide-react';

const links = [
  { to: '/', label: 'Home', icon: Home },
  { to: '/markets', label: 'Markets', icon: Compass },
  { to: '/portfolio', label: 'Portfolio', icon: Wallet2 },
  { to: '/orders', label: 'Orders', icon: BarChart3 },
  { to: '/news', label: 'News', icon: Newspaper },
  { to: '/settings', label: 'Settings', icon: Settings },
];

export function MobileSidebar() {
  return (
    <nav className="fixed inset-x-0 bottom-0 z-40 flex justify-around border-t border-slate-200 bg-white/95 px-2 py-3 backdrop-blur lg:hidden">
      {links.map(({ to, label, icon: Icon }) => (
        <NavLink
          key={to}
          to={to}
          className={({ isActive }) =>
            `flex flex-col items-center gap-1 rounded-2xl px-3 py-2 text-[11px] ${isActive ? 'text-brand-600' : 'text-slate-500'}`
          }
        >
          <Icon size={18} />
          {label}
        </NavLink>
      ))}
    </nav>
  );
}
