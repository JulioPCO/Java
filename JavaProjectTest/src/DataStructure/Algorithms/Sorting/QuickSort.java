package DataStructure.Algorithms.Sorting;

import java.util.Arrays;

public class QuickSort {// O(n log(n)) -> worst O(n ^2)//Space complexity O(log(n)) -> worst O(n)
    public int[] quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);

        return array;
    }

    private void quickSort(int[] array, int start, int end) {
        if (start >= end)
            return;
        // select a pivot
        int pivot = partitioning(array, start, end);

        quickSort(array, start, pivot - 1); // left sort
        quickSort(array, pivot + 1, end); // right sort

    }

    private int partitioning(int[] array, int start, int end) {

        int b = start - 1;
        for (int i = start; i < end + 1; i++) {
            if (array[i] <= array[end]) {
                b++;
                swap(array, i, b);
            }
        }

        return b;
    }

    private void swap(int[] array, int index1, int index2) {
        int aux;
        aux = array[index1];
        array[index1] = array[index2];
        array[index2] = aux;
    }
}