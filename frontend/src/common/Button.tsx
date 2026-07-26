import clsx from 'clsx';

interface ButtonProps extends React.ButtonHTMLAttributes<HTMLButtonElement> {
  variant?: 'primary' | 'secondary' | 'ghost';
  size?: 'sm' | 'md';
  children: React.ReactNode;
}

export function Button({ variant = 'primary', size = 'md', className, children, ...props }: ButtonProps) {
  return (
    <button
      className={clsx(
        'rounded-2xl font-medium transition-all duration-200 focus:outline-none focus:ring-2 focus:ring-brand-600/30',
        size === 'sm' ? 'px-3 py-2 text-sm' : 'px-4 py-3',
        variant === 'primary' && 'bg-brand-600 text-white shadow-[0_10px_24px_rgba(56,126,209,0.24)] hover:-translate-y-0.5 hover:bg-brand-700',
        variant === 'secondary' && 'bg-slate-100 text-slate-900 hover:bg-slate-200',
        variant === 'ghost' && 'bg-transparent text-slate-600 hover:bg-slate-100 hover:text-slate-900',
        className
      )}
      {...props}
    >
      {children}
    </button>
  );
}
