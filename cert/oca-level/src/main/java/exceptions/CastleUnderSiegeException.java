package exceptions;

class CastleUnderSiegeException extends Exception {
}

class KnightAttackingException extends CastleUnderSiegeException {
}

class Citadel {
	public static void main(String[] moat) {
		new Citadel().openDrawbridge(); // q3
	}

	public void openDrawbridge() throws RuntimeException {
		try {
			throw new KnightAttackingException();
		} catch (Exception e) {
			throw new ClassCastException();
		} finally {
			//throw new CastleUnderSiegeException(); // q2
		}
	}
}

