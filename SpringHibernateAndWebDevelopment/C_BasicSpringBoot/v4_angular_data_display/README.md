Only thing that matters is what class we are passing, if we are passing Student details, 
we are assuming only one json object having these properties

so to get arrays/lists of students,
Create a new class AllStudents with List<StudentDetails> with getters and setters and pass it
the list name from this class should be present in the json - 

		 * like if List<> abc =...;
		 * Json should be like { abc: [{}, {}]	}