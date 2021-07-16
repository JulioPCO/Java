package DataStructure.Algorithms.Sorting;

public class InsertionSort { // O(n^2) -> worst O(n) -> Best
    public int[] insertionSort(int[] array) {
        int[] sorted = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            sorted[i] = array[i];
            for (int j = 0; j < sorted.length; j++) {
                if (sorted[j] > array[i]) {
                    swap(sorted, i, j);
                }
            }

        }
        return sorted;
    }

    private void swap(int[] array, int index1, int index2) {
        int aux;
        aux = array[index1];
        array[index1] = array[index2];
        array[index2] = aux;
    }

}
