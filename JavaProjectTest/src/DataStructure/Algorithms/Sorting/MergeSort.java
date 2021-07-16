package DataStructure.Algorithms.Sorting;

import java.util.Arrays;

public class MergeSort {// O(n log(n)) -> worst O(n log(n)) -> Best // O(n) space
    public int[] mergeSort(int[] array) {
        array = mergeSort(array, array.length);

        return array;

    }

    private int[] mergeSort(int[] array, int length) {
        int divide = array.length / 2;

        if (divide == 0)
            return array;

        int[] lower = Arrays.copyOfRange(array, 0, divide);
        int[] upper = Arrays.copyOfRange(array, divide, array.length);

        lower = mergeSort(lower, lower.length);
        upper = mergeSort(upper, upper.length);

        int[] sorted = new int[array.length];
        int i = 0;
        int j = 0;

        for (int k = 0; k < array.length; k++) {
            if (i >= lower.length) { // copy remaining items
                sorted[k] = upper[j];
                j++;
                continue;
            }

            if (j >= upper.length) { // copy remaining items
                sorted[k] = lower[i];
                i++;
                continue;
            }

            if (lower[i] < upper[j]) {
                sorted[k] = lower[i];
                i++;
            } else {
                sorted[k] = upper[j];
                j++;
            }

        }

        return sorted;

    }

}
