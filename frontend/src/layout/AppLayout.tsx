import { Outlet } from 'react-router-dom';
import { Sidebar } from './Sidebar';
import { Header } from './Header';
import { MobileSidebar } from './MobileSidebar';
import { Footer } from './Footer';
import { useThemeStore } from '../store/themeStore';

export function AppLayout() {
  const { darkMode } = useThemeStore();

  return (
    <div className={`min-h-screen ${darkMode ? 'bg-slate-950 text-slate-100' : 'bg-slate-50 text-slate-900'}`}>
      <div className="flex min-h-screen">
        <Sidebar />
        <div className="flex-1">
          <Header />
          <main className="min-h-[calc(100vh-140px)]">
            <Outlet />
          </main>
          <Footer />
        </div>
      </div>
      <MobileSidebar />
    </div>
  );
}
