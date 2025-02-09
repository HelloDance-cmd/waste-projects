import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main
{
    public static void main(String[] args) throws Exception
    {
        Class<?> stringClass = Class.forName("java.lang.String");
        Method length = stringClass.getMethod("length");
        Object o = length.invoke("Hello World");
        System.out.println(o);
    }
}

class MyClass {
    private void run(String message) {
        System.out.println(message);
    }

    public void run(int x) {
        System.out.println("Running " + x);
    }
}
