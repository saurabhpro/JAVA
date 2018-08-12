package Ch06_Math_and_Logic_Puzzles.Q6_05_Egg_Drop;

public class Question {
    private static int breakingPoint;
    private static int countDrops;


    private static boolean willBreak(int floorWherEggIs) {
        countDrops++;
        return floorWherEggIs >= breakingPoint;
    }


    private static int findBreakingPoint(int floors) {
        int interval = 14;
        int previousFloor = 0;
        int egg1Floor = interval;

        /* Drop egg1Floor at decreasing intervals. */
        while (!willBreak(egg1Floor) && egg1Floor <= floors) {
            interval -= 1;
            previousFloor = egg1Floor;
            egg1Floor += interval;
        }

        /* Drop egg2Floor at 1 unit increments. */
        int egg2Floor = previousFloor + 1;
        while (egg2Floor < egg1Floor
                && egg2Floor <= floors
                && !willBreak(egg2Floor)) {

            egg2Floor += 1;
        }

        /* If it didn’t break, return -1. */
        return egg2Floor > floors ? -1 : egg2Floor;
    }


    public static void main(String[] args) {
        int max = 0;
        for (int i = 1; i <= 100; i++) {
            countDrops = 0;
            breakingPoint = i;

            int bp = findBreakingPoint(100);

            if (bp == breakingPoint) {
                System.out.println("SUCCESS: " + i + " -> " + bp + " -> " + countDrops);
            } else {
                System.out.println("ERROR: " + i + " -> " + bp + " vs " + breakingPoint);
                break;
            }
            max = countDrops > max ? countDrops : max;
        }
        System.out.println(max);
    }
}

