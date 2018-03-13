This restriction is sensible because almost any attempt to catch such an exception must fail, because the type is not reifiable. One might expect a typical use of the exception to be something like the following:

```java
class ParametricExceptionTest {
  public static void main(String[] args) {
    try {
      throw new ParametricException<Integer>(42);
    } catch (ParametricException<Integer> e) {  // compile-time error
      assert e.getValue()==42;
    }
  }
}
```
This is not permitted, because the type in the catch clause is not reifiable. At the time of this writing, the Sun compiler reports a cascade of syntax errors in such a case:

```java
% javac ParametricExceptionTest.java
ParametricExceptionTest.java:5: <identifier> expected
    } catch (ParametricException<Integer> e) {
                                ^
ParametricExceptionTest.java:8: ')' expected
  }
  ^
ParametricExceptionTest.java:9: '}' expected
}
 ^
3 errors
```
Because exceptions cannot be parametric, the syntax is restricted so that the type must be written as an identifier, with no following parameter.