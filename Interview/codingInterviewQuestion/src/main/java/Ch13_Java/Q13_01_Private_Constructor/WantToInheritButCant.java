package Ch13_Java.Q13_01_Private_Constructor;

@SuppressWarnings("ALL")
class WantToInheritButCant extends Question.B {
	//extending Question  or Question.A is not possible , but B is
	// since internally B calls the private constructor of A, which is fine
}
