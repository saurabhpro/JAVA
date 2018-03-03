package class_design.inner;

/**
 * This following code looks weird but is legal:
 */
public class CaseOfThePrivateInterface {
	private interface Secret {
		public void shh();
	}

	class DontTell implements Secret {
		@Override
		public void shh() {
		}
	}
}