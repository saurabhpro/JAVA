package Ch13_Java.Q13_06_Object_Reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Object Reflection and its use
 * <p>
 * 1. Getting info about the methods and fields present inside the class at runtime
 * 2. Creating new instance of class
 * 3. getting and setting object fields directly by gettting field reference, regardless of what access modifier is
 */
public class Question {
    public static void main(String args[]) {
        try {
            /* Parameters */
            Object[] doubleArgs = new Object[]{4.2, 3.9};

            /* Get class */
            //noinspection unchecked
            Class<Rectangle> rectangleDefinition = (Class<Rectangle>) Class.forName(Rectangle.class.getName());

            /* Equivalent: Rectangle rectangle = new Rectangle(4.2, 3.9); */
            Class[] doubleArgsClass = new Class[]{double.class, double.class};
            Constructor<Rectangle> doubleArgsConstructor = rectangleDefinition.getConstructor(doubleArgsClass);
            Rectangle rectangle = doubleArgsConstructor.newInstance(doubleArgs);

            /* Equivalent: Double area = rectangle.area(); */
            Method m = rectangleDefinition.getDeclaredMethod("area");
            Double area = (Double) m.invoke(rectangle);

            System.out.println(area);
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalArgumentException | IllegalAccessException | InvocationTargetException e) {
            System.out.println(e);
        } catch (InstantiationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

class Rectangle {
    private final double width;
    private final double height;

    public Rectangle(double w, double h) {
        width = w;
        height = h;
    }

    @SuppressWarnings("UnusedReturnValue")
    double area() {
        return width * height;
    }
}

