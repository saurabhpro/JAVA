import java.util.Stack;

class NextGreaterElement {
    static int[] getNextLargestArray(int[] arr) {
        int currentMaximum = -1;
        int nextMaximum = -1;
        int[] resultArr = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {

            nextMaximum = findNextMaximum(arr, i);

            if (i != arr.length - 1 /* last element */ && nextMaximum == -1) {
                resultArr[i] = currentMaximum;
            } else {
                resultArr[i] = nextMaximum;
            }
        }

        return resultArr;
    }

    /**
     * @param fromIdx the index from where to begin the search for next maximum number
     * @return next maximum number starting fromIdx
     */
    private static int findNextMaximum(int[] arr, int fromIdx) {
        int max = -1;

        for (int i = fromIdx + 1; i < arr.length; i++) {
            if (arr[fromIdx] < arr[i]) {
                max = arr[i];
                break;
            }
        }

        return max;
    }

    /* prints element and NGE pair for
       all elements of arr[] of size n  no need*/
    static void printNGE(int arr[], int n) {
        int i = 0;
        Stack<Integer> s = new Stack<>();
        //s.top = -1;
        int element, next;

        /* push the first element to stack */
        s.push(arr[0]);

        // iterate for rest of the elements
        for (i = 1; i < n; i++) {
            next = arr[i];

            if (!s.isEmpty()) {

                // if stack is not empty, then
                // pop an element from stack
                element = s.pop();

                /* If the popped element is smaller than 
                   next, then a) print the pair b) keep 
                   popping while elements are smaller and 
                   stack is not empty */
                while (element < next) {
                    System.out.println(element + " -- " + next);
                    if (s.isEmpty())
                        break;
                    element = s.pop();
                }

                /* If element is greater than next, then 
                   push the element back */
                if (element > next)
                    s.push(element);
            }

            /* push next to stack so that we can find next
               greater for it */
            s.push(next);
        }

        /* After iterating over the loop, the remaining 
           elements in stack do not have the next greater 
           element, so print -1 for them */
        while (!s.isEmpty()) {
            element = s.pop();
            next = -1;
            System.out.println(element + " -- " + next);
        }
    }

}