package DataStructure.Algorithms.Sorting;

public class SelectionSorting {// O(n^2) -> worst O(n^2) -> Best
    public int[] selectionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int k = findMinIndex(array, i, i);
            if (k != i)
                swap(array, i, k);
        }

        return array;
    }

    private int findMinIndex(int[] array, int i, int k) {
        for (int j = i; j < array.length; j++)
            if (array[j] < array[k])
                k = j;
        return k;
    }

    private void swap(int[] array, int index1, int index2) {
        int aux;
        aux = array[index1];
        array[index1] = array[index2];
        array[index2] = aux;
    }
}