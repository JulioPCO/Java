package DataStructure.Algorithms.Sorting;

public class CountingSort {
    public int[] countingSort(int[] array) {
        int max = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] > max)
                max = array[i];
        }

        int[] count = new int[max + 1];

        for (int i = 0; i < array.length; i++) {
            count[array[i]]++;
        }

        int k = 0;
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0)
                for (int j = 0; j < count[i]; j++) {
                    array[k] = i;
                    k++;
                }

        }

        return array;

    }

}
