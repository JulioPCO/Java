package DataStructure.Algorithms.Sorting;

public class BubbleSort { // O(n^2) -> worst O(n) -> Best
    public int[] bubbleSort(int[] array) {
        boolean isSorted; // optimization if array is sorted before

        for (int i = 0; i < array.length; i++) {
            isSorted = true;
            for (int j = 1; j < array.length - i; j++) // another optimization, the last item is in order
                if (array[j - 1] > array[j]) {
                    swap(array, j);
                    isSorted = false;
                }
            if (isSorted)
                return array;
        }

        return array;

    }

    private void swap(int[] array, int j) {
        int aux;
        aux = array[j - 1];
        array[j - 1] = array[j];
        array[j] = aux;
    }
}
