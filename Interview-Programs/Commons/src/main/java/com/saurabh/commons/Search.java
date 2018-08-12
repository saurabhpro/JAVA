package com.saurabh.commons;

import java.util.Arrays;

/**
 * Created by Saurabh on 8/5/2015.
 */
public class Search {
    public static void main(String[] args) {
        SearchRepeat s = new SearchRepeat();
        int[] a = {1, 2, 4, 5};
        int[] b = {2, 4, 3, 2, 2};
        s.CheckDuplicate(b, b.length);
        // s.CheckMaximumOccurrence(b, b.length);
        // s.FirstRepeated(a, a.length, 5);
        // System.out.println("Missing: "+ s.findMissingNumber(a, a.length));
        //s.SumEqualToK(b, b.length, 5);
    }

    void showArray(int a[]) {
        Arrays.stream(a).mapToObj(i1 -> i1 + " ").forEach(System.out::print);
        System.out.println();
    }
}


class SearchRepeat {

    Search s = new Search();

    void CheckDuplicate(int A[], int size) {
        for (int i = 0; i < size; i++) {
            s.showArray(A);
            if (A[Math.abs(A[i])] < 0) {
                System.out.printf("Duplicate " + -A[i] + "\n");
                return;
            } else
                A[Math.abs(A[i])] = -A[Math.abs(A[i])];
        }
        System.out.println("No Duplicates\n");
    }

    int CheckMaximumOccurrence(int A[], int size) {
        s.showArray(A);
        for (int i = 0; i < size; i++)
            A[A[i] % size] += size;

        s.showArray(A);
        int max = A[0], maxIndex = 0;
        for (int i = 1; i < size; i++) {
            //  s.showArray(A);
            if (A[i] > max) {
                max = A[i];
                maxIndex = i;
            }
        }

        //getting originial array
        for (int i = 0; i < size; i++)
            A[i] = A[i] % size;

        s.showArray(A);
        System.out.println("Max = " + maxIndex);
        return maxIndex;
    }

    void FirstRepeated(int A[], int size, int k) {
        int H[] = new int[k];

        for (int i = 0; i < size; i++) {
            if (A[i] == H[A[i]]) {
                H[A[i]] = -H[A[i]];
            } else
                H[A[i]] = A[i];

        }
        s.showArray(A);

        int maxNeg = H[0];
        int result = 0;

        for (int i = 1; i < H.length; i++) {

            if (maxNeg > H[i]) {
                maxNeg = H[i];
                result = i;
            }
        }
        System.out.println(H[result]);

    }

    int findMissingNumber(int A[], int size) {
        int X = A[0], Y = 1;
        for (int i = 1; i < size; i++)
            X ^= A[i];
        for (int i = 2; i <= size + 1; i++)
            Y ^= i;

      /*  int c=A[0];
        for (int i = 1; i<size; i++)
            c ^=A[i];*/

        System.out.println(X + " " + Y);
        return X ^ Y;
    }

    void SumEqualToK(int A[], int size, int K) {
        int temp = 0;
        Arrays.sort(A);
        s.showArray(A);

        for (int i = 0, j = size - 1; i < j; ) {
            System.out.println("Hey");
            temp = A[i] + A[j];
            if (temp == K) {
                System.out.println("Values are " + A[i] + A[j]);
                return;
            } else if (temp < K)
                i++;
            else
                j--;
        }
    }

    void secondBest(int A[], int size) {
        int i = 0, j = 0, current = 0;

        for (j = 1; j < size; j++) {
            if (i <= j)
                current = i;
            if (i < j && i > current)
                i++;

            i = j;

        }
    }
}
