import { Bell, Moon, Search, Sun, UserCircle2 } from 'lucide-react';
import { SearchBar } from '../common/SearchBar';
import { Button } from '../common/Button';
import { useThemeStore } from '../store/themeStore';

export function Header() {
  const { darkMode, toggleDarkMode } = useThemeStore();

  return (
    <header className="flex flex-wrap items-center justify-between gap-4 border-b border-slate-200/80 bg-white/80 px-6 py-4 backdrop-blur">
      <div className="flex flex-1 items-center gap-3">
        <SearchBar placeholder="Search stocks, ETFs, news" />
        <div className="hidden items-center gap-2 rounded-2xl border border-slate-200 bg-slate-50 px-3 py-2 text-sm text-slate-600 md:flex">
          <span className="font-semibold text-slate-900">NIFTY</span>
          <span className="text-emerald-600">+1.18%</span>
        </div>
        <div className="hidden items-center gap-2 rounded-2xl border border-slate-200 bg-slate-50 px-3 py-2 text-sm text-slate-600 md:flex">
          <span className="font-semibold text-slate-900">SENSEX</span>
          <span className="text-emerald-600">+0.94%</span>
        </div>
      </div>

      <div className="flex items-center gap-2">
        <Button variant="ghost" size="sm" onClick={toggleDarkMode} className="rounded-full p-2">
          {darkMode ? <Sun size={16} /> : <Moon size={16} />}
        </Button>
        <Button variant="ghost" size="sm" className="rounded-full p-2">
          <Bell size={16} />
        </Button>
        <Button variant="ghost" size="sm" className="flex items-center gap-2 rounded-full px-3">
          <UserCircle2 size={16} />
          <span className="hidden sm:inline">Asha</span>
        </Button>
      </div>
    </header>
  );
}
