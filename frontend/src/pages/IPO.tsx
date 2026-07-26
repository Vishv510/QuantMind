import { motion } from 'framer-motion';
import { Card } from '../common/Card';

export default function IpoPage() {
  return (
    <motion.div initial={{ opacity: 0, y: 10 }} animate={{ opacity: 1, y: 0 }} className="p-6 pb-24 lg:p-8">
      <Card title="Upcoming IPOs" subtitle="Track new listings">
        <div className="mt-4 space-y-3">
          <div className="rounded-2xl border border-slate-200 bg-slate-50 p-4">
            <p className="font-semibold text-slate-900">Apex Diagnostics</p>
            <p className="text-sm text-slate-600">Subscription opens in 3 days • Price band ₹300–₹320</p>
          </div>
          <div className="rounded-2xl border border-slate-200 bg-slate-50 p-4">
            <p className="font-semibold text-slate-900">Northstar Logistics</p>
            <p className="text-sm text-slate-600">Grey market activity rising • Expected listing premium</p>
          </div>
        </div>
      </Card>
    </motion.div>
  );
}
