import java.util.HashMap;
import java.util.Map;

/**
 * Created by saurabhkumar on 27/07/17.
 */
class SwapToMakeArraySumEqual {
    static boolean ifPairExistNaiveApproach(int[] ar1, int[] ar2) {
        int ar1Sum = 0, ar2Sum = 0;
        boolean check = false;
        HashMap<String, Integer[]> hm = new HashMap<>(2);

        for (int anAr1 : ar1) {
            ar1Sum += anAr1;
        }
        for (int anAr2 : ar2) {
            ar2Sum += anAr2;
        }
        System.out.println("Sum of 1st Array : " + ar1Sum);
        System.out.println("Sum of 2nd Array : " + ar2Sum);


        for (int i = 0; i < ar1.length; i++) {
            for (int j = 0; j < ar2.length; j++) {
                if (ar1Sum - ar1[i] + ar2[j] == ar2Sum - ar2[j] + ar1[i]) {

                    hm.put("From First Array ", new Integer[]{i, ar1[i]});
                    hm.put("From Second Array ", new Integer[]{j, ar2[j]});

                    check = true;
                    break;
                }
            }
        }

        for (Map.Entry<String, Integer[]> map : hm.entrySet()) {
            System.out.println("\n" + map.getKey());
            System.out.println("Position : " + map.getValue()[0]);
            System.out.println("Value : " + map.getValue()[1]);
        }

        return check;
    }
}
