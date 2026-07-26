interface DropdownProps {
  label: string;
  children: React.ReactNode;
}

export function Dropdown({ label, children }: DropdownProps) {
  return (
    <label className="flex flex-col gap-2 text-sm text-slate-600">
      <span>{label}</span>
      <select className="rounded-2xl border border-slate-200 bg-slate-50 px-3 py-3 outline-none">{children}</select>
    </label>
  );
}
