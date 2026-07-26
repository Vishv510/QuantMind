import { Cell, Pie, PieChart, ResponsiveContainer, Tooltip } from 'recharts';

const data = [
  { name: 'Technology', value: 35 },
  { name: 'Financials', value: 28 },
  { name: 'Energy', value: 17 },
  { name: 'Consumer', value: 20 },
];

const colors = ['#387ED1', '#00C853', '#F59E0B', '#EF4444'];

export function PieAllocationChart() {
  return (
    <div className="h-64">
      <ResponsiveContainer width="100%" height="100%">
        <PieChart>
          <Pie data={data} dataKey="value" outerRadius={80} innerRadius={45} paddingAngle={2}>
            {data.map((entry, index) => (
              <Cell key={entry.name} fill={colors[index % colors.length]} />
            ))}
          </Pie>
          <Tooltip />
        </PieChart>
      </ResponsiveContainer>
    </div>
  );
}
