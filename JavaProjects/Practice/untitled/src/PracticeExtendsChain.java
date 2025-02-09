import java.util.ArrayList;
import java.util.LinkedList;

public class PracticeExtendsChain {
  public static void main(String[] args) {
    ArrayList<Integer> integers = (ArrayList<Integer>) createNewInstance("java.util.ArrayList");
  }
  
  static <?> createNewInstance<T>(String classPathName) {
    try {
      return Class.forName(classPathName).newInstance();
    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
      System.out.println(e.getMessage());
      return new Object();
    }
  }
}