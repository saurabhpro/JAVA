package class_design.enums;

// Enums are implicitly declared public, static, and final (in the class using it), which means you cannot extend them.
enum PrinterType {
	DOTMATRIX(5), INKJET(10), LASER(50);

	private int pagePrintCapacity;

	// a constructor in an enum class can only be specified as private.
	private PrinterType(int pagePrintCapacity) {
		this.pagePrintCapacity = pagePrintCapacity;
	}

	public int getPrintPageCapacity() {
		return pagePrintCapacity;
	}
}