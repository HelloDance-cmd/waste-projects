import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class Main
{
    public static void main(String[] args)
    {
        HashSet hashSet = new HashSet();
        hashSet.add(1);
        hashSet.add(2);
        hashSet.add(3);

        List.of(1, 2).sort((a, b) -> b - a);

        for (Object o : hashSet) {

        }
    }
}
