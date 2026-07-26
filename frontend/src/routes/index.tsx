import { createBrowserRouter } from 'react-router-dom';
import DashboardPage from '../pages/Dashboard';
import MarketsPage from '../pages/Markets';
import PortfolioPage from '../pages/Portfolio';
import HoldingsPage from '../pages/Holdings';
import OrdersPage from '../pages/Orders';
import AnalyticsPage from '../pages/Analytics';
import NewsPage from '../pages/News';
import IpoPage from '../pages/IPO';
import SettingsPage from '../pages/Settings';
import { AppLayout } from '../layout/AppLayout';

export const router = createBrowserRouter([
  {
    element: <AppLayout />,
    children: [
      { path: '/', element: <DashboardPage /> },
      { path: '/markets', element: <MarketsPage /> },
      { path: '/portfolio', element: <PortfolioPage /> },
      { path: '/holdings', element: <HoldingsPage /> },
      { path: '/orders', element: <OrdersPage /> },
      { path: '/analytics', element: <AnalyticsPage /> },
      { path: '/news', element: <NewsPage /> },
      { path: '/ipo', element: <IpoPage /> },
      { path: '/settings', element: <SettingsPage /> },
    ],
  },
]);
