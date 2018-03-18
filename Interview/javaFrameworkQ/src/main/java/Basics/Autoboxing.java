package Basics;

public class Autoboxing {

	/*
	 public static Integer valueOf(int i) {
		    if (i >= IntegerCache.low && i <= IntegerCache.high)
		        return IntegerCache.cache[i + (-IntegerCache.low)];
		    return new Integer(i);
		 }

		 The cache is initialized on first usage.  The size of the cache
     * may be controlled by the {@code -XX:AutoBoxCacheMax=<size>} option.
     *
     * During VM initialization, java.lang.Integer.IntegerCache.high property
     * may be set and saved in the private system properties in the
     * jdk.internal.misc.VM class.
	 */
	public static void main(String[] args) {
		//Q why new Integer(34); is not recommended
		/*
		 * This method will always cache values in the range -128 to 127,
		 * inclusive, and may cache other values outside of this range.
		 */
		Integer i = Integer.valueOf(23);

		i = new Integer(23);
	}
}
