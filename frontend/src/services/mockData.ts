import type { ActivityItem, Holding, MarketItem, NewsItem, Order, SectorPerformance } from '../types';

export const portfolioValue = 2438520;
export const todaysPnl = 18240;
export const totalReturn = 12.8;

export const watchlist: MarketItem[] = [
  { symbol: 'RELIANCE', company: 'Reliance Industries', price: 2845, change: 2.8, volume: '8.2M' },
  { symbol: 'TCS', company: 'Tata Consultancy Services', price: 3640, change: 1.1, volume: '3.6M' },
  { symbol: 'HDFC', company: 'HDFC Bank', price: 2350, change: -0.3, volume: '5.9M' },
  { symbol: 'INFY', company: 'Infosys', price: 1965, change: 1.8, volume: '6.1M' },
  { symbol: 'LT', company: 'L&T', price: 3442, change: 0.7, volume: '4.4M' },
];

export const topGainers: MarketItem[] = [
  { symbol: 'NBCC', company: 'NBCC India', price: 97.2, change: 5.8, volume: '1.1M' },
  { symbol: 'POLYCAB', company: 'Polycab India', price: 6762, change: 4.9, volume: '0.8M' },
  { symbol: 'BHEL', company: 'Bharat Heavy Electricals', price: 245.4, change: 4.5, volume: '2.3M' },
];

export const topLosers: MarketItem[] = [
  { symbol: 'INDUSINDBK', company: 'IndusInd Bank', price: 1456, change: -3.2, volume: '2.8M' },
  { symbol: 'M&M', company: 'Mahindra & Mahindra', price: 3125, change: -2.9, volume: '1.4M' },
  { symbol: 'ONGC', company: 'Oil and Natural Gas Corp', price: 281.7, change: -2.1, volume: '2.1M' },
];

export const holdings: Holding[] = [
  { symbol: 'RELIANCE', company: 'Reliance Industries', quantity: 25, avgPrice: 2680, currentPrice: 2845, invested: 67000, currentValue: 71125, pnl: 4125, pnlPercent: 6.2 },
  { symbol: 'TCS', company: 'Tata Consultancy Services', quantity: 40, avgPrice: 3450, currentPrice: 3640, invested: 138000, currentValue: 145600, pnl: 7600, pnlPercent: 5.5 },
  { symbol: 'HDFC', company: 'HDFC Bank', quantity: 50, avgPrice: 2400, currentPrice: 2350, invested: 120000, currentValue: 117500, pnl: -2500, pnlPercent: -2.1 },
];

export const orders: Order[] = [
  { id: 'O-1024', symbol: 'INFY', side: 'Buy', quantity: 15, price: 1965, status: 'Open', time: '09:15 AM' },
  { id: 'O-1023', symbol: 'TCS', side: 'Sell', quantity: 10, price: 3640, status: 'Completed', time: '08:42 AM' },
  { id: 'O-1022', symbol: 'HDFC', side: 'Buy', quantity: 20, price: 2350, status: 'Pending', time: '08:10 AM' },
  { id: 'O-1021', symbol: 'RELIANCE', side: 'Sell', quantity: 5, price: 2845, status: 'Cancelled', time: '07:35 AM' },
];

export const sectors: SectorPerformance[] = [
  { name: 'Financials', value: 32, change: 1.2 },
  { name: 'Technology', value: 24, change: 2.7 },
  { name: 'Energy', value: 16, change: -0.3 },
  { name: 'Industrials', value: 14, change: 0.8 },
  { name: 'Consumer', value: 14, change: 1.1 },
];

export const newsItems: NewsItem[] = [
  { id: 'n1', title: 'Banking sector sees strong inflows after RBI commentary', category: 'Markets', impact: 'High', time: '12 min ago', summary: 'Analysts expect selective strength in large-cap lenders.' },
  { id: 'n2', title: 'Mid-cap IT names gain on resilient global demand', category: 'Technology', impact: 'Medium', time: '32 min ago', summary: 'Momentum continues in software services and cloud automation.' },
  { id: 'n3', title: 'Crude remains steady as supply outlook improves', category: 'Energy', impact: 'Low', time: '1 hr ago', summary: 'Oil-linked counters remain range-bound ahead of weekly inventory data.' },
];

export const activityFeed: ActivityItem[] = [
  { title: 'Order executed', detail: 'Bought 15 INFY shares', time: '5 min ago', value: '+₹29,475' },
  { title: 'Portfolio updated', detail: 'Daily performance synced', time: '18 min ago', value: '+₹1,820' },
  { title: 'Alert triggered', detail: 'RELIANCE crossed your price target', time: '32 min ago', value: 'Watchlist' },
];
