import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by Saurabh on 10/5/2015.
 * HashMap Class Constructors
 * 1. HashMap();
 * 2. HashMap(int Capacity);
 * 3. HashMap(int Capacity, float LoadFactor);
 * 4. HashMap(Map m);
 */

public class HashMapBasicString {
    public static void main(String[] args) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("1001", "aaaa");
        hashMap.put("1002", "bbbb");
        hashMap.put("1003", "cccc");
        hashMap.put("1004", "dddd");
        hashMap.put(new String("1005"), "eeee");        //no difference with using new
        hashMap.put("1001", "only changed the value of 1001");      // it'll replace the value at key

        /**
         * Set set = hashMap.entrySet();
         * valid but produces raw type variable set
         * so if we want its iterator to be stores in type specific
         *         Iterator<Map.Entry> iterator = set.iterator();
         *         its valid but waring : unchecked type generated
         *         Note: Recompile with -Xlint:unchecked for details.
         */

        Set<Map.Entry<String, String>> set = hashMap.entrySet();
        Iterator<Map.Entry<String, String>> iterator = set.iterator();

        while (iterator.hasNext()) {
            Map.Entry e = iterator.next();

            System.out.println(e.getKey() + " " + e.getValue());
        }

    }
}
/**
 * OUTPUT
 * if you see the entry is shown as a addToBeginningOfLinkedList(), 5->4->3->2->1
 * 1005 eeee
 * 1004 dddd
 * 1003 cccc
 * 1002 bbbb
 * 1001 only changed the value of 1001
 */