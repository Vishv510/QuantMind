export default function OrderPanel() {
  return (
    <section className="order-card">
      <div className="card-title">
        <h3>Quick order</h3>
        <span>Place a trade in seconds</span>
      </div>
      <form className="order-form">
        <label>
          Stock symbol
          <input type="text" value="RELIANCE" readOnly />
        </label>
        <label>
          Order type
          <select>
            <option>Buy</option>
            <option>Sell</option>
          </select>
        </label>
        <label>
          Quantity
          <input type="number" defaultValue={25} />
        </label>
        <label>
          Price limit
          <input type="text" defaultValue="2,845" />
        </label>
        <button type="button" className="submit-button">
          Submit order
        </button>
      </form>
    </section>
  );
}
