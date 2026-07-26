import { Card } from '../common/Card';
import { Table } from '../common/Table';
import { orders } from '../services/mockData';
import { formatCurrency } from '../utils/format';

const columns = [
  { key: 'id', label: 'Order ID' },
  { key: 'symbol', label: 'Symbol' },
  { key: 'price', label: 'Price' },
  { key: 'status', label: 'Status' },
  { key: 'time', label: 'Time' },
];

export function OrdersTable() {
  return (
    <Card title="Recent orders" subtitle="Latest executions" className="col-span-12 xl:col-span-5">
      <Table
        columns={columns}
        rows={orders}
        renderRow={(row) => (
          <>
            <td className="px-4 py-3 font-semibold text-slate-900">{row.id}</td>
            <td className="px-4 py-3 text-slate-600">{row.symbol}</td>
            <td className="px-4 py-3 text-slate-600">{formatCurrency(row.price)}</td>
            <td className="px-4 py-3 text-slate-600">{row.status}</td>
            <td className="px-4 py-3 text-slate-600">{row.time}</td>
          </>
        )}
      />
    </Card>
  );
}
