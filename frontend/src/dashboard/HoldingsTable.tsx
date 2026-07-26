import { Card } from '../common/Card';
import { Table } from '../common/Table';
import { holdings } from '../services/mockData';
import { formatCurrency, formatPercent } from '../utils/format';

const columns = [
  { key: 'symbol', label: 'Symbol' },
  { key: 'quantity', label: 'Qty' },
  { key: 'currentPrice', label: 'Price' },
  { key: 'currentValue', label: 'Value' },
  { key: 'pnl', label: 'P/L' },
];

export function HoldingsTable() {
  return (
    <Card title="Holdings" subtitle="Current positions" className="col-span-12 xl:col-span-7">
      <Table
        columns={columns}
        rows={holdings}
        renderRow={(row) => (
          <>
            <td className="px-4 py-3 font-semibold text-slate-900">{row.symbol}</td>
            <td className="px-4 py-3 text-slate-600">{row.quantity}</td>
            <td className="px-4 py-3 text-slate-600">{formatCurrency(row.currentPrice)}</td>
            <td className="px-4 py-3 text-slate-600">{formatCurrency(row.currentValue)}</td>
            <td className={`px-4 py-3 ${row.pnl >= 0 ? 'text-emerald-600' : 'text-rose-600'}`}>
              {formatCurrency(row.pnl)} ({formatPercent(row.pnlPercent)})
            </td>
          </>
        )}
      />
    </Card>
  );
}
