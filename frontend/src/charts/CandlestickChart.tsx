const candles = [
  { label: '09:00', high: 82, low: 74, open: 76, close: 80 },
  { label: '10:00', high: 86, low: 78, open: 80, close: 84 },
  { label: '11:00', high: 88, low: 81, open: 84, close: 82 },
  { label: '12:00', high: 90, low: 80, open: 82, close: 89 },
  { label: '13:00', high: 92, low: 84, open: 89, close: 87 },
  { label: '14:00', high: 95, low: 85, open: 87, close: 93 },
];

export function CandlestickChart() {
  return (
    <div className="rounded-[24px] border border-slate-200 bg-slate-50 p-4">
      <div className="mb-4 flex items-center justify-between">
        <div>
          <p className="text-sm text-slate-500">Realtime candle view</p>
          <h3 className="text-lg font-semibold text-slate-900">AAPL momentum</h3>
        </div>
        <span className="rounded-full bg-emerald-50 px-3 py-1 text-sm font-medium text-emerald-700">Bullish</span>
      </div>
      <div className="flex h-56 items-end gap-3">
        {candles.map((candle) => {
          const height = Math.max(18, Math.abs(candle.close - candle.open) * 3.5);
          const top = Math.min(candle.open, candle.close) * 0.7;
          const isUp = candle.close >= candle.open;
          return (
            <div key={candle.label} className="flex flex-1 flex-col items-center gap-2">
              <div className="relative flex h-40 w-full items-end justify-center">
                <div className="absolute w-0.5 bg-slate-400" style={{ height: `${(candle.high - candle.low) * 1.8}px`, top: `${Math.max(4, 120 - candle.high * 0.9)}px` }} />
                <div className={`w-5 rounded-md ${isUp ? 'bg-emerald-500' : 'bg-rose-500'}`} style={{ height: `${height}px` }} />
              </div>
              <span className="text-xs text-slate-500">{candle.label}</span>
            </div>
          );
        })}
      </div>
    </div>
  );
}
