interface StatCardProps {
  label: string;
  value: string;
  subtitle?: string;
  tone?: 'positive' | 'negative' | 'neutral';
}

export function StatCard({ label, value, subtitle, tone = 'neutral' }: StatCardProps) {
  const toneClasses = {
    positive: 'text-emerald-600',
    negative: 'text-rose-600',
    neutral: 'text-slate-900',
  };

  return (
    <div className="rounded-[22px] border border-slate-200 bg-slate-50 p-4">
      <p className="text-sm text-slate-500">{label}</p>
      <p className={`mt-2 text-2xl font-semibold ${toneClasses[tone]}`}>{value}</p>
      {subtitle && <p className="mt-2 text-sm text-slate-500">{subtitle}</p>}
    </div>
  );
}
