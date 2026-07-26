import { CartesianGrid, Line, LineChart, ResponsiveContainer, Tooltip, XAxis, YAxis } from 'recharts';

const data = [
  { month: 'Jan', pnl: 4.5 },
  { month: 'Feb', pnl: 6.1 },
  { month: 'Mar', pnl: 5.3 },
  { month: 'Apr', pnl: 8.2 },
  { month: 'May', pnl: 7.4 },
  { month: 'Jun', pnl: 9.6 },
];

export function PerformanceChart() {
  return (
    <div className="h-72">
      <ResponsiveContainer width="100%" height="100%">
        <LineChart data={data}>
          <CartesianGrid stroke="#e5e7eb" strokeDasharray="3 3" />
          <XAxis dataKey="month" tickLine={false} axisLine={false} />
          <YAxis tickLine={false} axisLine={false} />
          <Tooltip />
          <Line type="monotone" dataKey="pnl" stroke="#00C853" strokeWidth={3} dot={{ r: 4 }} />
        </LineChart>
      </ResponsiveContainer>
    </div>
  );
}
