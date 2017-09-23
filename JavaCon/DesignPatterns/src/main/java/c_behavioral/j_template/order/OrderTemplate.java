package c_behavioral.j_template.order;

abstract class OrderTemplate {

	private boolean isGift;

	protected abstract void doCheckout();

	protected abstract void doPayment();

	protected abstract void doReceipt();

	protected abstract void doDelivery();

	private void wrapGift() {
		System.out.println("Gift wrapped.");
	}

	public final void processOrder() {
		doCheckout();
		doPayment();
		if (isGift) {
			wrapGift();
		} else {
			doReceipt();
		}

		doDelivery();
	}

}
