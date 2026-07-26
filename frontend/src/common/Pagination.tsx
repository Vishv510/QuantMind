interface PaginationProps {
  currentPage: number;
  totalPages: number;
}

export function Pagination({ currentPage, totalPages }: PaginationProps) {
  return (
    <div className="mt-4 flex items-center justify-between text-sm text-slate-500">
      <span>Page {currentPage} of {totalPages}</span>
      <div className="flex gap-2">
        <button className="rounded-2xl border border-slate-200 px-3 py-2">Prev</button>
        <button className="rounded-2xl bg-brand-600 px-3 py-2 text-white">{currentPage}</button>
        <button className="rounded-2xl border border-slate-200 px-3 py-2">Next</button>
      </div>
    </div>
  );
}
