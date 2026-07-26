import { motion } from 'framer-motion';
import { Card } from '../common/Card';
import { Button } from '../common/Button';

export default function SettingsPage() {
  return (
    <motion.div initial={{ opacity: 0, y: 10 }} animate={{ opacity: 1, y: 0 }} className="space-y-6 p-6 pb-24 lg:p-8">
      <Card title="Preferences" subtitle="Personalize your workspace">
        <div className="space-y-4">
          <div className="rounded-2xl border border-slate-200 bg-slate-50 p-4">Theme switching and notification preferences are available in the header.</div>
          <Button>Save preferences</Button>
        </div>
      </Card>
    </motion.div>
  );
}
