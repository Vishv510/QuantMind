import { Card } from './Card';

interface ChartCardProps {
  title: string;
  subtitle?: string;
  children: React.ReactNode;
}

export function ChartCard({ title, subtitle, children }: ChartCardProps) {
  return <Card title={title} subtitle={subtitle}>{children}</Card>;
}
