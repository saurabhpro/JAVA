# Java 8


1) Default methods can be overriden in implementing class, while static cannot.

2) Static method belongs only to Interface class, so you can only invoke static method on Interface class, not on class implementing this Interface, see:
```java
public interface MyInterface {
    default void defaultMethod(){
        System.out.println("Default");
    }

    static void staticMethod(){
        System.out.println("Static");
    }    
}

public class MyClass implements MyInterface {

    public static void main(String[] args) {

        MyClass.staticMethod(); //not valid - static method may be invoked on containing interface class only
        MyInterface.staticMethod(); //valid
    }
}
```
3) Both class and interface can have static methods with same names, and neither overrides other!
```java
public class MyClass implements MyInterface {

    public static void main(String[] args) {

        //both are valid and have different behaviour
        MyClass.staticMethod();
        MyInterface.staticMethod();
    }

    static void staticMethod(){
        System.out.println("another static..");
    }
}
```


## Why were default and static methods added to interfaces in Java 8 when we already had abstract classes?


In Java 8, interfaces can contain implemented methods, static methods, and the so-called "default" methods (which the implementing classes do not need to override).

In my (probably naive) view, there was no need to violate interfaces like this. Interfaces have always been a contract you must fulfill, and this is a very simple and pure concept. Now it is a mix of several things. In my opinion:

	1.	static methods do not belong to interfaces. They belong to utility classes.
	2.	"default" methods shouldn't have been allowed in interfaces at all. You could always use an abstract class for this purpose.

In short:
Before Java 8:

	•	You could use abstract and regular classes to provide static and default methods. The role of interfaces is clear.
	•	All the methods in an interface should be overriden by implementing classes.
	•	You can't add a new method in an interface without modifying all the implementations, but this is actually a good thing.

After Java 8:

	•	There's virtually no difference between an interface and an abstract class (other than multiple inheritance). In fact you can emulate a regular class with an interface.
	•	When programming the implementations, programmers may forget to override the default methods.
	•	There is a compilation error if a class tries to implement two or more interfaces having a default method with the same signature.
	•	By adding a default method to an interface, every implementing class automatically inherits this behavior. Some of these classes might have not been designed with that new functionality in mind, and this can cause problems. For instance, if someone adds a new default method default void foo() to an interface Ix, then the class Cx implementing Ix and having a private foo method with the same signature does not compile.

What are the main reasons for such major changes, and what new benefits (if any) do they add?

# Java 9
## Private methods
## Private static methods

```java
public interface ReportGeneratorJava9 {
    /**
     * Need to get implemented as per ReportGenerator class
     * @param reportData
     * @param schema
     */
    void generateReport(String reportData, String schema);
    /**
     * Reading the report data from DB
     * @return
     */
    private String getReportDataFromDB() {
        System.out.println("Reading the data from DB ....");
        //logic to get the data from DB
        String reportData = "data from DB";
        return formatData(reportData);
    }
    /**
     * Reading the report data from FileSystem
     * @return
     */
    private String getReportDataFromFile() {
        System.out.println("Reading the data from FileSystem ....");
        //logic to get the data from File
        String reportData = "data from File";
        return formatData(reportData);
    }
    /**
     * Reading the report data from cache
     * @return
     */
    private String getReportDataFromCache() {
        System.out.println("Reading the data from Cache ....");
        //logic to get the data from Cache
        String reportData = "data from Cache";
        return formatData(reportData);
    }
    /**
     * Formatting the data to create a common standardized data,
     * as it's coming from different systems
     * @param reportData
     * @return
     */
    private String formatData(String reportData) {
        System.out.println("Formatting the data to create a common standard");
        /** Format the data and then return **/
        //logic to format the data
        return reportData;
    }
    /**
     * Get the ready data
     * @param reportSource
     * @return
     * @throws Exception
     */
    default String getReportData(String reportSource) throws Exception {
        String reportData = null;
        if (null == reportSource) {
            throw new Exception("reportSource can't be null....");
        }
        if (reportSource.equalsIgnoreCase("DB")) {
            reportData = getReportDataFromDB();
        } else if (reportSource.equalsIgnoreCase("File")) {
            reportData = getReportDataFromFile();
        } else if (reportSource.equalsIgnoreCase("Cache")) {
            reportData = getReportDataFromCache();
        }
        return reportData;
    }
}
```


## In Java SE 9 and later versions, an interface can have only two kinds of things:

 - Constant variables
 - Abstract methods
 - Default methods
 - Static methods
 - Private methods
 - Private Static methods

 ### Benefits with “Java SE 9: private methods in Interface” New Feature:

- No need to write Duplicate Code i.e. Code Reusability.
- We can expose only our intended methods to clients.