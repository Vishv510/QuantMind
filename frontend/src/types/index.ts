export interface Holding {
  symbol: string;
  company: string;
  quantity: number;
  avgPrice: number;
  currentPrice: number;
  invested: number;
  currentValue: number;
  pnl: number;
  pnlPercent: number;
}

export interface Order {
  id: string;
  symbol: string;
  side: 'Buy' | 'Sell';
  quantity: number;
  price: number;
  status: 'Open' | 'Completed' | 'Pending' | 'Cancelled';
  time: string;
}

export interface MarketItem {
  symbol: string;
  company: string;
  price: number;
  change: number;
  volume: string;
}

export interface SectorPerformance {
  name: string;
  value: number;
  change: number;
}

export interface NewsItem {
  id: string;
  title: string;
  category: string;
  impact: 'High' | 'Medium' | 'Low';
  time: string;
  summary: string;
}

export interface ActivityItem {
  title: string;
  detail: string;
  time: string;
  value: string;
}
