import { motion } from 'framer-motion';
import { Card } from '../common/Card';
import { HoldingsTable } from '../dashboard/HoldingsTable';

export default function HoldingsPage() {
  return (
    <motion.div initial={{ opacity: 0, y: 10 }} animate={{ opacity: 1, y: 0 }} className="p-6 pb-24 lg:p-8">
      <Card title="All holdings" subtitle="Current portfolio positions">
        <div className="mt-4"><HoldingsTable /></div>
      </Card>
    </motion.div>
  );
}
