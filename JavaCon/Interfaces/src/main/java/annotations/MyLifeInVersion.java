/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package annotations;

import java.lang.annotation.*;

@Documented /*If used then only it will be shown in java doc */
@Retention(RetentionPolicy.CLASS)   /*CLASS, SOURCE, RUNTIME (keep these annotation to be used reflectivley at runtime)*/
@Target(ElementType.TYPE)   /*On what elements in java can these annotations be used - TYPE means class related things*/ @interface MyLifeInVersion {
	String author();

	String birthDate();

	int currentRevision() default 1;

	String lastModified() default "N/A";

	String lastModifiedBy() default "N/A";

	// Note use of array
	String[] reviewers();
}


/*Annotations remove excess data to a common store and forms a contract*/