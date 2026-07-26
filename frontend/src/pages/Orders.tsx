import { motion } from 'framer-motion';
import { Card } from '../common/Card';
import { OrdersTable } from '../dashboard/OrdersTable';
import { OrderForm } from '../trading/OrderForm';

export default function OrdersPage() {
  return (
    <motion.div initial={{ opacity: 0, y: 10 }} animate={{ opacity: 1, y: 0 }} className="space-y-6 p-6 pb-24 lg:p-8">
      <div className="grid gap-6 lg:grid-cols-[1.2fr_0.8fr]">
        <OrdersTable />
        <OrderForm />
      </div>
      <Card title="Open orders" subtitle="Live queue">
        <div className="mt-4"><OrdersTable /></div>
      </Card>
    </motion.div>
  );
}
