interface TableProps<T> {
  columns: Array<{ key: string; label: string }>;
  rows: T[];
  renderRow: (row: T) => React.ReactNode;
}

export function Table<T>({ columns, rows, renderRow }: TableProps<T>) {
  return (
    <div className="overflow-hidden rounded-2xl border border-slate-200">
      <table className="min-w-full divide-y divide-slate-200 text-sm">
        <thead className="bg-slate-50">
          <tr>
            {columns.map((column) => (
              <th key={column.key} className="px-4 py-3 text-left font-medium text-slate-600">
                {column.label}
              </th>
            ))}
          </tr>
        </thead>
        <tbody className="divide-y divide-slate-200 bg-white">
          {rows.map((row, index) => (
            <tr key={index}>{renderRow(row)}</tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}
