package Ch16_Moderate.Q16_15_Master_Mind;

import java.util.Random;

public class Question {

    private static final int MAX_COLORS = 4;

    private static int code(char c) {
        switch (c) {
            case 'B':
                return 0;
            case 'G':
                return 1;
            case 'R':
                return 2;
            case 'Y':
                return 3;
            default:
                return -1;
        }
    }

    private static Result estimate(String guess, String solution) {
        if (guess.length() != solution.length()) return null;
        Result res = new Result();
        int[] frequencies = new int[MAX_COLORS];

        /* Compute hits and built frequency table */
        for (int i = 0; i < guess.length(); i++) {
            if (guess.charAt(i) == solution.charAt(i)) {
                res.hits++;
            } else {
                /* Only increment the frequency table (which will be used for pseudo-hits) if
                 * it's not a hit. If it's a hit, the slot has already been "used." */
                int code = code(solution.charAt(i));
                if (code >= 0) {
                    frequencies[code]++;
                }
            }
        }

        /* Compute pseudo-hits */
        for (int i = 0; i < guess.length(); i++) {
            int code = code(guess.charAt(i));
            if (code >= 0 && frequencies[code] > 0 && guess.charAt(i) != solution.charAt(i)) {
                res.pseudoHits++;
                frequencies[code]--;
            }
        }
        return res;
    }

    /************************** TEST CODE **********************************/

    private static char letterFromCode(int k) {
        switch (k) {
            case 0:
                return 'B';
            case 1:
                return 'G';
            case 2:
                return 'R';
            case 3:
                return 'Y';
            default:
                return '0';
        }
    }

    private static Result estimateBad(String g, String s) {
        char[] guess = g.toCharArray();
        char[] solution = s.toCharArray();
        int hits = 0;
        for (int i = 0; i < guess.length; i++) {
            if (guess[i] == solution[i]) {
                hits++;
                solution[i] = '0';
                guess[i] = '0';
            }
        }

        int pseudohits = 0;

        for (int i = 0; i < guess.length; i++) {
            if (guess[i] != '0') {
                for (int j = 0; j < solution.length; j++) {
                    if (solution[j] != '0') {
                        if (solution[j] == guess[i]) {
                            pseudohits++;
                            solution[j] = '0';
                            break;
                        }
                    }
                }
            }
        }

        return new Result(hits, pseudohits);
    }

    private static String randomString() {
        int length = 4;
        char[] str = new char[length];
        Random generator = new Random();

        for (int i = 0; i < length; i++) {
            int v = generator.nextInt(4);
            char c = letterFromCode(v);
            str[i] = c;
        }

        return String.valueOf(str);
    }

    private static boolean test(String guess, String solution) {
        Result res1 = estimate(guess, solution);
        Result res2 = estimateBad(guess, solution);
        if (res1.hits == res2.hits && res1.pseudoHits == res2.pseudoHits) {
            return true;
        } else {
            System.out.println("FAIL: (" + guess + ", " + solution + "): " + res1.toString() + " | " + res2.toString());
            return false;
        }
    }

    private static boolean testRandom() {
        String guess = randomString();
        String solution = randomString();
        return test(guess, solution);
    }

    private static boolean test(int count) {
        for (int i = 0; i < count; i++) {
            if (!testRandom()) {
                return true;
            }
        }
        return false;
    }

    /********************** END TEST CODE ************************/


    public static void main(String[] args) {
        test(1000);
    }

    static class Result {
        int hits;
        int pseudoHits;

        Result(int h, int p) {
            hits = h;
            pseudoHits = p;
        }

        Result() {
        }

        public String toString() {
            return "(" + hits + ", " + pseudoHits + ")";
        }
    }
}
