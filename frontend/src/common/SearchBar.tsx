import { Search } from 'lucide-react';

interface SearchBarProps {
  placeholder?: string;
}

export function SearchBar({ placeholder = 'Search stocks...' }: SearchBarProps) {
  return (
    <label className="flex items-center gap-2 rounded-2xl border border-slate-200 bg-slate-50 px-4 py-3 text-sm text-slate-500 shadow-sm">
      <Search size={16} />
      <input className="w-full bg-transparent outline-none" placeholder={placeholder} />
    </label>
  );
}
