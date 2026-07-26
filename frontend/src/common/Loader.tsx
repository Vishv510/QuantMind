import { LoaderCircle } from 'lucide-react';

export function Loader() {
  return (
    <div className="flex items-center justify-center py-10">
      <LoaderCircle className="animate-spin text-brand-600" size={24} />
    </div>
  );
}
