package generics.exception;

// generic classes may not extend Throwable or its child classes
// It is a compile-time error if a generic class is a direct or indirect subclass of Throwable.
// class GenericException<T> extends Throwable { } // wrong usage - compiler error


// this is ok
class NonGeneric {
}

class Generic<T> extends NonGeneric {

}