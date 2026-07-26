import { motion } from 'framer-motion';
import { Card } from '../common/Card';
import { newsItems } from '../services/mockData';

export default function NewsPage() {
  return (
    <motion.div initial={{ opacity: 0, y: 10 }} animate={{ opacity: 1, y: 0 }} className="space-y-6 p-6 pb-24 lg:p-8">
      <div className="grid gap-6 lg:grid-cols-2"> 
        {newsItems.map((item) => (
          <Card key={item.id} title={item.title} subtitle={item.category}>
            <p className="mt-2 text-sm text-slate-600">{item.summary}</p>
            <div className="mt-4 flex items-center justify-between text-sm text-slate-500">
              <span>{item.time}</span>
              <span className="font-semibold text-brand-600">Impact: {item.impact}</span>
            </div>
          </Card>
        ))}
      </div>
    </motion.div>
  );
}
