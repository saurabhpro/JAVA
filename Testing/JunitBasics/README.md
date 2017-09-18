## JUnit 5 requires Java 8 to work.

The library is composed of several modules, organized in 3 main sub-projects:

* **JUnit Platform** – which enables launching testing frameworks on the JVM
* **JUnit Jupiter** – which contains new features for writing tests in JUnit 5
* **JUnit Vintage** – which provides support for running JUnit 3 and JUnit 4 tests on the JUnit 5 platform

## JUnit 5 Test Annotations

Let’s start by understanding a core feature of JUnit 5 – the annotations.

The new library provides a series of annotations for configuring tests, some of which are new to this version, and some that are equivalent to previous JUnit 4 annotations.

Let’s go through the basics:

- **@Test** – denotes a test method; unlike the @Test annotation from previous versions, it doesn’t accept any arguments
- **@DisplayName** – specifies a custom name for the test class or method
- **@BeforeEach, @AfterEach** – runs the annotated method before or after each test method in the same class; equivalent to the previous @Before and @After
- **@BeforeAll, @AfterAll** – runs the annotated method before any or after all of the test methods in the class; equivalent to the previous @BeforeClass and @AfterClass
- **@Disabled** – prevents a test class or method from running; similar to the previous @Ignore
All of these belong to the org.junit.jupiter.api package.

Now that we understand annotations better, let’s have a look at a simple example of how we could use @BeforeAll and @AfterAll to setup some test data.

For example, in an application with a simple DAO-based persistence layer, we’re going to use @BeforeAll to create a few User entities and save them to make them available to each test method:
```java
@BeforeAll
public static void addData(){
    User user1 = new User("john@gmail.com", "John");
    User user2 = new User("ana@gmail.com","Ana");
    userDAO.add(user1);
    userDAO.add(user2);
}
```

Then, you can make sure this data is removed after all the tests have completed:
```java
@AfterAll
public static void removeData(){
    userDAO.deleteAll();
}
```

This way you ensure a clean database before each set of tests runs.

Notice both of these methods annotated with @BeforeAll and @AfterAll need to be static.

Let’s also add a simple test method with a custom display name that verifies the two users do exist:
```java
@Test
@DisplayName("Test Get Users")
public void testGetUsers() {
    assertEquals(2, userDAO.findAll().size());
}
```

## Assertions

JUnit 5 contains many of the JUnit 4 assertions as well as a number of interesting new ones. And, more importantly, it also adds support for lambda expressions to be used in assertions.

One advantage of using a lambda expression for the assertion message is that it causes it to be lazily evaluated, which can save time and resources by avoiding the construction of complex messages like these:

```java
@Test
public void testGetUser() {
    User user = userDAO.findOne("john@gmail.com");
    
    assertNotNull(user);
    assertEquals("John", user.getName(),
      "User name:" + user.getName() + " incorrect");
}
```
All the assertion methods can be imported through static import from the Assertions class:
```java
import static org.junit.jupiter.api.Assertions.*;
```
Naturally, most of the JUnit 4 classic assertion methods are still available in the new format (<expected>,<actual>,<message>):

```java
@Test
public void testClassicAssertions() {
    User user1 = userDAO.findOne("john@gmail.com");
    User user2 = userDAO.findOne("john@yahoo.com");

    assertNotNull(user1);
    assertNull(user2);

    user2 = new User("john@yahoo.com", "John");
    assertEquals(user1.getName(), user2.getName(), "Names are not equal");
    assertFalse(user1.getEmail().equals(user2.getEmail()), "Emails are equal");
    assertNotSame(user1, user2);
}
```

## New Assertions

In addition to the classic assertions, it is now possible to group assertions using the assertAll() API, and have all the failed assertions reported together:
```java
@Test
public void testGetUsers() {
    User user = userDAO.findOne("john@gmail.com");

    assertAll("user", 
      () -> assertEquals("Johnson", user.getName()),
      () -> assertEquals("johnson@gmail.com", user.getEmail()));
}
```

The assertion failures will be reported in a MultipleFailuresError object:
//TODO add error snippet

This behavior is very helpful for testing sets of related properties – as you can see the result of each, as opposed to having separate assertions for them, where only the first failure would be shown.

To compare arrays and collections, you can now use the `assertArrayEquals()` and `assertIterableEquals()` methods:
```java
@Test
public void testIterableEquals() {
    User user1 = new User("john@gmail.com", "John");
    User user2 = new User("ana@gmail.com", "Ana");

    List<User> users = new ArrayList<>();
    users.add(user1);
    users.add(user2);

    assertIterableEquals(users, userDAO.findAll());
}
```
**For this assertion to succeed, the User class naturally has to implement a relevant equals() method.**


A list of Strings can also be compared using the `assertLinesMatch()` method, where the expected argument can contain Strings to compare as well as regular expressions:

```java
@Test
public void testLinesMatch() {
    List<String> expectedLines = Collections.singletonList("(.*)@(.*)");
    List<String> emails = Arrays.asList("john@gmail.com");
    assertLinesMatch(expectedLines, emails);
}
```

A quick interesting side-note – this feature was first developed internally to verify the output of the new ConsoleLauncher.

Next, since the **@Test annotation no longer accepts arguments**, such as an expected exception, JUnit 5 now provides the assertThrows() method to define and verify expected exceptions:

```java
@Test
public void testThrows() {
    User user = null;
    Exception exception = assertThrows(NullPointerException.class, () -> user.getName());
    logger.info(exception.getMessage());
}
```
An advantage of this method is that it returns the Exception object which can be further used to obtain more information about the thrown exception.

Finally, another new assertion in JUnit 5 is `fail()`, which simply fails a test:
```java
@Test
public void testFail() {
    fail("this test fails");
}
```

## Assumptions

Now that you’ve seen the most important assertions in JUnit 5, let’s now focus on a new and very promising concept – assumptions.

An assumption defines the conditions which have to be met so that a test will be run. A failing assumption does not mean a test is failing, 
but simply that the test won’t provide any relevant information, so it doesn’t need to run.

Conditions for running tests can be defined using the methods: `assumeTrue(), assumeFalse() and assumingThat()`:
```java
@Test
public void testAssumptions() {
    List<User> users = userDAO.findAll();
    assumeFalse(users == null);
    assumeTrue(users.size() > 0);

    User user1 = new User("john@gmail.com", "John");
    assumingThat(users.contains(user1), () -> assertTrue(users.size() > 1));
}
```

## Tagging and Filtering Tests

Grouping tests that logically belong together has been historically difficult.

This is exactly what this new feature addresses; the `@Tag` annotation can be added to a test class or method to group tests by a certain tag. The tag can later be used to determine which tests should run:
```java
@Tag("math")
public class TaggedTest {
    @Test
    @Tag("arithmetic")
    public void testEquals(){
        assertTrue(1==1);
    }
}
```
You can then configure tags to run by using the <groups> or <includeTags> elements in surefire, and or to be excluded via <excludedGroups> or <excludeTags>:
```xml
<plugin>
    <artifactId>maven-surefire-plugin</artifactId>
    <version>2.19</version>
    <configuration>                
        <properties>                  
            <excludeTags>math</excludeTags>                
        </properties>            
    </configuration>
</plugin>
```

## Nested Tests

JUnit 5 also offers the possibility of creating nested tests by simply annotating an inner class with @Nested:
```java
public class UsersTest {
    private static UserDAO userDAO;

    @Nested
    class DeleteUsersTest {
        @Test
        public void addUser() {
            User user = new User("bob@gmail.com", "Bob");
            userDAO.add(user);
            assertNotNull(userDAO.findOne("bob@gmail.com"));

            userDAO.delete("bob@gmail.com");
            assertNull(userDAO.findOne("bob@gmail.com"));
        }
    }
}
```
**The nested test class must be an inner class, meaning a non-static nested class. And, since inner classes cannot have static fields and methods, this prohibits the use of the @BeforeAll and @AfterAll annotations in nested tests.**

## Repeated Tests

The new release also introduces the `@RepeatedTest` annotation to mark a test that needs to run several times. The annotation must specify the number of times you want a test to run.

The @RepeatedTest benefits from the full JUnit lifecycle support. This means that if you define a @BeforeEach or @AfterEach method, it will be run before each execution of the test.

In this following example, the message “Before Each Test” will be displayed 3 times:

```java
public class IncrementTest {

    private static Logger logger = LogManager.getLogger(IncrementTest.class);

    @BeforeEach
    public void increment() {
        logger.info("Before Each Test");
    }

    @RepeatedTest(value=3, name=RepeatedTest.SHORT_DISPLAY_NAME)
    public void test(RepetitionInfo info) {
        assertTrue(1 == 1);
        logger.info("Repetition #" + info.getCurrentRepetition());
    }
}
```

The name attribute can be used to display more information about the repetitions.

Each @RepeatedTest can also take a RepetitionInfo parameter which contains repetition metadata.

The output of the above example will be:
```java
/*
Sep 18, 2017 8:45:36 PM com.saurabh.junit5basics.RepeatedIncrementTest increment
INFO: Before Each Test
Sep 18, 2017 8:45:36 PM com.saurabh.junit5basics.RepeatedIncrementTest test
INFO: Repetition #1
Sep 18, 2017 8:45:36 PM com.saurabh.junit5basics.RepeatedIncrementTest increment
INFO: Before Each Test
Sep 18, 2017 8:45:36 PM com.saurabh.junit5basics.RepeatedIncrementTest test
INFO: Repetition #2
Sep 18, 2017 8:45:36 PM com.saurabh.junit5basics.RepeatedIncrementTest increment
INFO: Before Each Test
Sep 18, 2017 8:45:36 PM com.saurabh.junit5basics.RepeatedIncrementTest test
INFO: Repetition #3
*/
```


## Dependency Injection for Constructors and Methods

You may have noticed in the previous section that we added a parameter of type RepetitionInfo to the test() method. This wasn’t possible in previous versions of JUnit.

And given just how useful constructor injection can be, JUnit 5 now allows defining parameters for test constructors and methods and enables dependency injection for them. This mechanism works by using an instance of a ParameterResolver to dynamically resolve parameters at runtime.

**Currently, there are only 3 built-in resolvers for parameters of type `TestInfo, RepetitionInfo and TestReporter.`**

Let’s see how the TestInfo parameter can be used to obtain metadata about a test method:
```java
@Test
@DisplayName("Test Get Users")
public void testGetUsersNumberWithInfo(TestInfo testInfo) {
    assertEquals(2, userDAO.findAll().size());
    assertEquals("Test Get Users", testInfo.getDisplayName());
    assertEquals(UsersTest.class, testInfo.getTestClass().get());
    
    logger.info("Running test method:" + testInfo.getTestMethod().get().getName());
}
```
**The getTestClass() and getTestMethod() methods are followed by a get() call since they return an Optional object.**

## Parameterized Tests

Parameterized tests allow running the same test multiple times, but with different arguments.

In order to enable parameterized tests, you need to add the junit-jupiter-params dependency to the classpath:
```xml
<dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter-params</artifactId>
    <version>5.0.0</version>
</dependency>
```

You can then define this style of test using the @ParameterizedTest annotation and at least one source of arguments; there are several types of parameter sources you can pick from:

- **@ValueSource** – defines an array of literals of primitive types, and can only provide a single parameter per test invocation
- **@EnumSource** – uses an Enum as a parameter source
- **@MethodSource** – uses one or more methods of the test class; the methods must return an array or a Stream, Iterable or Iterator object, and must be static and have no arguments
- **@CsvSource and @CsvFileSource** – uses parameters defined in CSV format, either in String objects or read from a file
- **@ArgumentsSource** – uses a custom ArgumentsProvider

Let’s see a quick example of a repeated test which uses a @ValueSource with a string parameter:
```java
@ParameterizedTest
@ValueSource(strings = { "john@gmail.com", "ana@gmail.com" })
public void testParameterized(String email) {
    assertNotNull(userDAO.findOne(email));
}
```

## Dynamic Tests

In addition to the standard static tests, defined with the @Test annotations, JUnit 5 introduces the possibility of defining tests at runtime. These dynamic tests can be generated using a factory method annotated with @TestFactory.

Simply put, this test factory must return a Stream, Collection, Iterable or Iterator of DynamicTest.

Note that dynamic tests do not support lifecycle callbacks. Therefore, methods annotated with @BeforeEach or @AfterEach will not be executed.

Let’s see a simple example of a test factory method returning a Collection with a DynamicTest object:
```java
@TestFactory
Collection<DynamicTest> dynamicTestCollection() {
    return Arrays.asList(DynamicTest.dynamicTest("Dynamic Test", () -> assertTrue(1==1)));
}
```
For a more dynamic method, you can create an iterator that provides inputs, a display name generator, and a test executor – then use these in a DynamicTest.stream() method:
```java
@TestFactory
Stream<DynamicTest> dynamicUserTestCollection() {
    List<User> inputList = Arrays.asList(new User("john@yahoo.com", "John"), new User("ana@yahoo.com", "Ana"));

    Function<User, String> displayNameGenerator = (input) -> "Saving user: " + input;

    UserDAO userDAO = new UserDAO();
    ThrowingConsumer<User> testExecutor = (input) -> {
        userDAO.add(input);
        assertNotNull(userDAO.findOne(input.getEmail()));
    };

    return DynamicTest.stream(inputList.iterator(), displayNameGenerator, testExecutor);
}
```

## Test Annotations in Interfaces

JUnit 5 also allows several annotations to be added to test interfaces:

@Test, @TestFactory, @BeforeEach and @AfterEach can be added to default methods in interfaces (introduced in Java 8)
@BeforeAll and @AfterAll can be added to static methods in interfaces
@ExtendsWith and @Tag can be declared on interfaces
And, as expected, the classes that implement these interface will inherit the test cases:
```java
public interface DatabaseConnectionTest {

    @Test
    default void testDatabaseConnection() {
        Connection con = ConnectionUtil.getConnection();
        assertNotNull(con);
    }
}
```
`public class UsersTest implements DatabaseConnectionTest { .... }`
In this example, the UsersTest class will run the testDatabaseConnection() test in addition to its own tests.

In small projects, this can be a nice feature, but in larger, complex codebases with extensive code suites, this can be a game changer, as it leads to much nice composition semantics in the system.

## Conditional Test Execution

JUnit 5 allows defining custom annotations that act as conditions to determine whether a test should be run or not. The classes that contain the conditional logic need to implement ContainerExecutionCondition to evaluate tests in a test class, or TestExecutionCondition to evaluate test methods.

To define a custom condition, you first need to create the annotation:
```java
@Target({ ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@ExtendWith(DisabledOnEnvironmentCondition.class)
public @interface DisabledOnEnvironment {
    String[] value();
}
```
Notice we’ve created an annotation called DisabledOnEnvironment which can now be applied to a method and will mark the test disabled on these environments.

With the annotation implemented, you now need to define the DisabledOnEnvironmentCondition class.

This simply needs to implement the TestExecutionCondition interface and override the evaluate() method. The evaluate() implementation will load the environments from a .properties file and check them against the list from the annotation itself:
```java
public class DisabledOnEnvironmentCondition implements TestExecutionCondition {
    
    @Override
    public ConditionEvaluationResult evaluate(TestExtensionContext context) {
        Properties props = new Properties();
        String env = "";
        try {
            props.load(ConnectionUtil.class.getResourceAsStream("/application.properties"));
            env = props.getProperty("env");
        } catch (IOException e) {
            e.printStackTrace();
        }
        Optional<DisabledOnEnvironment> disabled = AnnotationSupport.
          findAnnotation(context.getElement().get(), DisabledOnEnvironment.class);
        if (disabled.isPresent()) {
            String[] envs = disabled.get().value();
            if (Arrays.asList(envs).contains(env)) {
                return ConditionEvaluationResult.disabled("Disabled on environment " + env);
            }
        }      
        return ConditionEvaluationResult.enabled("Enabled on environment "+env);
    }
}
```
The method returns a ConditionEvaluationResult that specifies whether the test method will be enabled or not.

Then, you can simply add the new annotation to a test method:
```java
@Test
@DisabledOnEnvironment({ "dev", "prod" })
void testFail() {
    fail("this test fails");
}
```
Migrating from JUnit 4

JUnit 5 packs quite a punch.

But, you’ve likely been writing unit tests for a while now, and have a legacy test suite that’s already running and producing value.

And so, a proper migration plan will be critical. That’s exactly why JUnit 4 tests can still run using JUnit 5, simply by using the junit-vintage-engine dependency:

<dependency>
    <groupId>org.junit.vintage</groupId>
    <artifactId>junit-vintage-engine</artifactId>
    <version>4.12.0-M4</version>
</dependency>
However, if you want to fully migrate your tests from JUnit 4 to the JUnit 5 API – here are some of the changes you will most likely encounter:

change everything from org.junit to the org.junit.jupiter.api package
replace @BeforeClass and @AfterClass with @BeforeAll and @AfterAll
replace @Before and @After with @BeforeEach and @AfterEach
replace @Ignore with @Disabled
remove @Rule, @ClassRule and @RunWith
