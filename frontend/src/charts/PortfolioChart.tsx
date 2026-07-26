import { Area, AreaChart, CartesianGrid, ResponsiveContainer, Tooltip, XAxis, YAxis } from 'recharts';

const data = [
  { month: 'Jan', value: 120000 },
  { month: 'Feb', value: 132000 },
  { month: 'Mar', value: 129000 },
  { month: 'Apr', value: 148000 },
  { month: 'May', value: 156000 },
  { month: 'Jun', value: 168000 },
];

export function PortfolioChart() {
  return (
    <div className="h-72">
      <ResponsiveContainer width="100%" height="100%">
        <AreaChart data={data}>
          <defs>
            <linearGradient id="portfolioFill" x1="0" y1="0" x2="0" y2="1">
              <stop offset="0%" stopColor="#387ED1" stopOpacity={0.45} />
              <stop offset="100%" stopColor="#387ED1" stopOpacity={0.02} />
            </linearGradient>
          </defs>
          <CartesianGrid stroke="#e5e7eb" strokeDasharray="3 3" />
          <XAxis dataKey="month" tickLine={false} axisLine={false} />
          <YAxis tickLine={false} axisLine={false} />
          <Tooltip />
          <Area type="monotone" dataKey="value" stroke="#387ED1" fill="url(#portfolioFill)" strokeWidth={3} />
        </AreaChart>
      </ResponsiveContainer>
    </div>
  );
}
