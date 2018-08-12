import java.util.Arrays;

/**
 * Given an array A[] of N integers where each value represents number of chocolates in a packet.
 * Each packet can have variable number of chocolates.
 * <p>
 * There are m students, the task is to distribute chocolate packets such that :
 * 1. Each student gets one packet.
 * 2. The difference between the number of chocolates given to the students in packet with maximum chocolates and
 * packet with minimum chocolates is minimum.
 * <p>
 * Examples
 * <p>
 * Input : A[] = {3, 4, 1, 9, 56, 7, 9, 12}
 * m = 5
 * Output: Minimum Difference is 6
 * We may pick 3,4,7,9,9 and the output
 * is 9-3 = 6
 */

class A_ChoclateDistributionProblem {
    /**
     * method to distribute choclates to noOfStudents
     *
     * @param listOfChoclates represents sizes of packets
     * @param noOfStudents    is number of students.
     * @return sub-array containing minimum difference between maximum and minimum values of distribution.
     */
    static int[] distribute(int[] listOfChoclates, int noOfStudents) {

        // if there are no chocolates or number of students is 0
        if (noOfStudents == 0 || listOfChoclates.length == 0)
            throw new RuntimeException("Distribution unsuccessful");

        // Number of students cannot be more than number of packets
        if (listOfChoclates.length <= noOfStudents)
            throw new RuntimeException("Number of Packets are less than no. of children - Distribution Aborted!");

        //	List<Integer> listOfChoclate = IntStream.of(listOfChoclates).boxed().collect(Collectors.toList());
        //	listOfChoclate.sort(Integer::compare);


        // sort the packet size of choclates in ascending
        Arrays.sort(listOfChoclates);

        int minPosition = 0;
        int currentDifference;
        int bound = listOfChoclates.length - noOfStudents + 1;
        // Find the sub-array of size noOfStudents such that difference between last (maximum in case
        // of sorted) and first (minimum in case of sorted) elements of subarray is minimum.
        int min = listOfChoclates[noOfStudents] - listOfChoclates[0];
        for (int position = 1; position < bound; position++) {
            currentDifference = listOfChoclates[noOfStudents + position - 1] - listOfChoclates[position];

            if (currentDifference < min) {
                min = currentDifference;
                minPosition = position;
            }
        }

        System.out.println("The difference is " + min + " choosen distribution would be ");
        bound = minPosition + noOfStudents;

        int[] result = new int[noOfStudents];
        for (int i = 0, position = minPosition; position < bound; i++, position++) {
            result[i] = listOfChoclates[position];
        }

        return result;

    }
}
