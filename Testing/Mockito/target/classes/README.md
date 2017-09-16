- **What is mocking?**
    - mocking is creating objects that simulate the behavior of real objects.
    - Unlike stubs, mocks can be dynamically created from code - at runtime.
    - Mocks offer more functionality than stubbing.
    - You can verify method calls and a lot of other things.


- **What if we combine a matcher with hardcoded value when stubbing.**
    - Throws `InvalidUseOfMatchersException`  - This exception may occur if matchers are combined with raw values:
    ```
      //incorrect:
      someMethod(anyObject(), "raw String");`
    
      When using matchers, all arguments have to be provided by matchers.
      For example:
    
      //correct:
      someMethod(anyObject(), eq("String by matcher"));
  ```
 
  
- **What happens if an unstubbed method is called?**
  - By default, for all methods that return a value, a mock will return either null, a primitive/primitive wrapper value, or an empty collection, as appropriate. For example 0 for an int/Integer and false for a boolean/Boolean. 