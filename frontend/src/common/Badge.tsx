import clsx from 'clsx';

interface BadgeProps {
  children: React.ReactNode;
  tone?: 'success' | 'danger' | 'neutral';
}

export function Badge({ children, tone = 'neutral' }: BadgeProps) {
  return (
    <span
      className={clsx(
        'inline-flex rounded-full px-3 py-1 text-xs font-semibold',
        tone === 'success' && 'bg-emerald-50 text-emerald-700',
        tone === 'danger' && 'bg-rose-50 text-rose-700',
        tone === 'neutral' && 'bg-slate-100 text-slate-700'
      )}
    >
      {children}
    </span>
  );
}
