import java.util.Objects;

class C_PeekElement {

    // A wrapper over recursive function findPeakUtil()
    static int findPeak(int arr[]) {
        int n = arr.length;
        int resultIndex = findPeakUtil(arr, 0, n - 1, n);

        return arr[resultIndex];
    }


    // A binary search based function that returns index of a peak element -  O(log n)
    private static int findPeakUtil(int arr[], int low, int high, int n) {
        // Find index of middle element
        int mid = low + (high - low) / 2;  /* (low + high)/2*/

        // Compare middle element with its neighbours (if neighbours exist)
        if ((mid == 0 || arr[mid - 1] <= arr[mid]) &&
                (mid == n - 1 || arr[mid + 1] <= arr[mid]))
            return mid;

            // If middle element is not peak and its left neighbor is greater than it,
            // then left half must have a peak element
        else if (mid > 0
                && arr[mid - 1] > arr[mid])
            return findPeakUtil(arr, low, (mid - 1), n);        // left half has peek

            // If middle element is not peak and its right neighbor
            // is greater than it, then right half must have a peak element
        else return findPeakUtil(arr, (mid + 1), high, n);      // right array
    }

    static int giveFirstPeekNumberByClevererIdea(int[] arr) {

        // Test	neighbours both

        int before;
        int after;

        Objects.requireNonNull(arr);

        if (arr.length == 0) {
            return 0;
        } else if (arr.length == 1)
            return arr[0];

        before = arr[0];
        int cur;
        for (cur = 0; cur < arr.length - 1; cur++) {
            boolean ispeek;
            after = arr[cur + 1];

            // corner case where 3 2 1 - means return 3
            if (cur == 0) {
                ispeek = before > after;
                if (ispeek)
                    return arr[cur];
            }

            // corner case where 3 2 4 - means return 4
            else if (cur == arr.length - 2) {
                ispeek = after > arr[cur];

                if (ispeek)
                    return after;
            }

            // for all the middle cases
            if (arr[cur] >= before && arr[cur] >= after) {
                return arr[cur];
            }

            before = arr[cur];
        }

        return 0;
    }


}
