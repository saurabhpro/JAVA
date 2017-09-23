class FinalizeOfObjectDeprecated {

	@Override
	protected void finalize() throws Throwable {
		System.out.println("These are the last days of finalize from Object Class");
		super.finalize();
	}
}
