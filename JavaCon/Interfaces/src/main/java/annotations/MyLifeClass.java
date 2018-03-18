/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package annotations;

@MyLifeInVersion(
		author = "Saurabh Kumar",
		birthDate = "11/15/1992",
		currentRevision = 6,
		lastModified = "4/12/2004",
		lastModifiedBy = "Jane Doe",
		// Note array notation
		reviewers = {"Alice", "Bob", "Cindy"}
)
class MyLifeClass {
	// can't do anything Yet
}
