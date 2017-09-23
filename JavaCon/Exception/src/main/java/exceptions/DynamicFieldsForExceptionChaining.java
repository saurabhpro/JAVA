package exceptions;//: exceptions/DynamicFields.java
// exceptions.try_with_resources.A Class that dynamically adds fields to itself.
// Demonstrates exception chaining.

class DynamicFieldsException extends Exception {
}

public class DynamicFieldsForExceptionChaining {
	private Object[][] fields;

	private DynamicFieldsForExceptionChaining(int initialSize) {
		fields = new Object[initialSize][2];
		for (int i = 0; i < initialSize; i++)
			fields[i] = new Object[]{null, null};
	}

	public static void main(String[] args) {
		DynamicFieldsForExceptionChaining df = new DynamicFieldsForExceptionChaining(3);
		System.out.println(df);
		try {
			df.setField("d", "exceptions.try_with_resources.A value for d");
			df.setField("number", 47);
			df.setField("number2", 48);
			System.out.println(df);
			df.setField("d", "exceptions.try_with_resources.A new value for d");
			df.setField("number3", 11);
			System.out.println("df: " + df);
			System.out.println("df.getField(\"d\") : " + df.getField("d"));
			Object field = df.setField("d", null); // Exception
		} catch (NoSuchFieldException | DynamicFieldsException e) {
			e.printStackTrace(System.out);
		}
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		for (Object[] obj : fields) {
			result.append(obj[0]);
			result.append(": ");
			result.append(obj[1]);
			result.append("\n");
		}
		return result.toString();
	}

	private int hasField(String id) {
		for (int i = 0; i < fields.length; i++)
			if (id.equals(fields[i][0]))
				return i;
		return -1;
	}

	private int
	getFieldNumber(String id) throws NoSuchFieldException {
		int fieldNum = hasField(id);
		if (fieldNum == -1)
			throw new NoSuchFieldException();
		return fieldNum;
	}

	private int makeField(String id) {
		for (int i = 0; i < fields.length; i++)
			if (fields[i][0] == null) {
				fields[i][0] = id;
				return i;
			}
		// No empty fields. Add one:
		Object[][] tmp = new Object[fields.length + 1][2];

		/* Not Recommended as manual array copy is slower, use System.arraycopy() instead
		for (int i = 0; i < fields.length; i++)
			tmp[i] = fields[i];
		*/
		System.arraycopy(fields, 0, tmp, 0, fields.length);


		for (int i = fields.length; i < tmp.length; i++)
			tmp[i] = new Object[]{null, null};

		fields = tmp;

		// Recursive call with expanded fields:
		return makeField(id);
	}

	private Object
	getField(String id) throws NoSuchFieldException {
		return fields[getFieldNumber(id)][1];
	}

	private Object setField(String id, Object value) throws DynamicFieldsException {
		if (value == null) {
			// Most exceptions don't have a "cause" constructor.
			// In these cases you must use initCause(),
			// available in all Throwable subclasses.
			DynamicFieldsException dfe =
					new DynamicFieldsException();
			dfe.initCause(new NullPointerException());
			/* Exception chaining
			  we catch one exception and throw another but keep the originating exception information

			  we have a "cause" object in Throwable [error, Exception, RuntimeException] only
			  the cause will be the originating exception, and even though you are throwing a completely new exception
			  by passing it in we maintain stack trace back to origin even though you are creating a new exception

			 */
			throw dfe;
		}

		int fieldNumber = hasField(id);
		if (fieldNumber == -1)
			fieldNumber = makeField(id);
		Object result = null;
		try {
			result = getField(id); // Get old value
		} catch (NoSuchFieldException e) {
			// Use constructor that takes "cause":
			throw new RuntimeException(e);
		}
		fields[fieldNumber][1] = value;
		return result;
	}
} /* Output:
null: null
null: null
null: null

d: exceptions.try_with_resources.A value for d
number: 47
number2: 48

df: d: exceptions.try_with_resources.A new value for d
number: 47
number2: 48
number3: 11

df.getField("d") : exceptions.try_with_resources.A new value for d
exceptions.DynamicFieldsException
        at exceptions.DynamicFieldsForExceptionChaining.setField(exceptions.DynamicFieldsForExceptionChaining.java:64)
        at exceptions.DynamicFieldsForExceptionChaining.main(exceptions.DynamicFieldsForExceptionChaining.java:94)
Caused by: java.lang.NullPointerException
        at exceptions.DynamicFieldsForExceptionChaining.setField(exceptions.DynamicFieldsForExceptionChaining.java:66)
        ... 1 more
*///:~
