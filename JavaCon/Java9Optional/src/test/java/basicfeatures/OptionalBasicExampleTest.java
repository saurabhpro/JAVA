/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package basicfeatures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class OptionalBasicExampleTest {

	@Test
	void optionalOfNullArgument() {
		Assertions.assertThrows(NullPointerException.class,
				OptionalBasicExample::optionalOfNullArgument,
				"Optional.of(null) causes NPE!");
	}
}