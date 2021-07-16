package DataStructure.Algorithms.Sorting;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class BucketSort {

    public int[] bucketSort(int[] array) {
        int buckets = 3;
        array = bucketSort(array, buckets);

        return array;
    }

    private int[] bucketSort(int[] array, int buckets) { // O(n^2) -> worst O(n + k)-> Best // O(n +k) space
        var sorted = new int[array.length];
        MergeSort sort = new MergeSort();
        List<LinkedList<Integer>> list = new ArrayList<>();
        List<int[]> items = new ArrayList<>();

        for (int i = 0; i < buckets; i++) { // this can be organized in OOP but not doing in this code
            list.add(new LinkedList<>());
        }

        for (var numbers : array)
            list.get(numbers / buckets).add(numbers);

        // Sync
        /*
         * int k = 0; for (var bucket : list) { Collections.sort(bucket); for (var
         * number : bucket) { sorted[k] = number; k++; }
         * 
         * }
         */

        // Async implementation... I hope
        for (int j = 0; j < buckets; j++) {
            try {
                items.add(CompletableFuture
                        .supplyAsync(() -> sort.mergeSort(list.remove(0).stream().mapToInt(i -> i).toArray())).get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

        int k = 0;

        for (var lists : items)
            for (var number : lists) {
                sorted[k] = number;
                k++;
            }

        return sorted;

    }
}
