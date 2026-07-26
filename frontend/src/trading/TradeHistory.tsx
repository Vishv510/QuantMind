import { Card } from '../common/Card';
import { Table } from '../common/Table';
import { orders } from '../services/mockData';
import { formatCurrency } from '../utils/format';

const columns = [
  { key: 'id', label: 'ID' },
  { key: 'symbol', label: 'Symbol' },
  { key: 'side', label: 'Side' },
  { key: 'price', label: 'Price' },
];

export function TradeHistory() {
  return (
    <Card title="Trade history" subtitle="Recent activity" className="col-span-12">
      <Table
        columns={columns}
        rows={orders}
        renderRow={(row) => (
          <>
            <td className="px-4 py-3 font-semibold text-slate-900">{row.id}</td>
            <td className="px-4 py-3 text-slate-600">{row.symbol}</td>
            <td className="px-4 py-3 text-slate-600">{row.side}</td>
            <td className="px-4 py-3 text-slate-600">{formatCurrency(row.price)}</td>
          </>
        )}
      />
    </Card>
  );
}
