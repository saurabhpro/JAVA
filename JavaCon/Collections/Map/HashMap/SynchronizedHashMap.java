import java.util.*;

/**
 * Created by Saurabh on 10/5/2015.
 */
public class SynchronizedHashMap {
    @SuppressWarnings("SynchronizationOnLocalVariableOrMethodParameter")
    public static void main(String[] args) {
        HashMap<Integer, String> hashMap = new HashMap<>();

        hashMap.put(2, "Anil");
        hashMap.put(44, "Ajit");
        hashMap.put(4, "Sachin");
        hashMap.put(88, "xyz");

        Map map = Collections.synchronizedMap(hashMap);

        Set set = map.entrySet();

        synchronized (map) {
            Iterator iterator = set.iterator();
            while (iterator.hasNext()) {
                Map.Entry e = (Map.Entry) iterator.next();
                System.out.println(e.getKey() + " " + e.getValue());
            }
        }
    }
}
