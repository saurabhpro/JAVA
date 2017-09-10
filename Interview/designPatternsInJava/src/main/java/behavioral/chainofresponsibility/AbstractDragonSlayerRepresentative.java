package behavioral.chainofresponsibility;

/**
 * @author saurabh
 */
public abstract class AbstractDragonSlayerRepresentative implements DragonSlayer {

	private DragonSlayer nextRep = null;

	public AbstractDragonSlayerRepresentative(DragonSlayer nextRep) {
		this.nextRep = nextRep;
	}

	/**
	 * Action method that calls next representative
	 */
	public Boolean attack(Integer minDamage) {
		if (nextRep != null) {
			return nextRep.attack(minDamage);
		} else {
			throw new RuntimeException("To strong for us");
		}
	}
}
