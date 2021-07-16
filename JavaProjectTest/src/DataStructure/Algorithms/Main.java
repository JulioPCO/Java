package DataStructure.Algorithms;

import DataStructure.Algorithms.Sorting.BubbleSort;
import DataStructure.Algorithms.Sorting.CountingSort;
import DataStructure.Algorithms.Sorting.InsertionSort;
import DataStructure.Algorithms.Sorting.MergeSort;
import DataStructure.Algorithms.Sorting.SelectionSorting;
import DataStructure.Algorithms.Sorting.QuickSort;
import DataStructure.Algorithms.Sorting.BucketSort;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = { 8, 2, 3, 5, 1, 7, 4 };
        BubbleSort bubble = new BubbleSort();
        SelectionSorting sort = new SelectionSorting();
        InsertionSort sort2 = new InsertionSort();
        MergeSort sort3 = new MergeSort();
        QuickSort sort4 = new QuickSort();
        CountingSort sort5 = new CountingSort();
        BucketSort sort6 = new BucketSort();
        arr = sort6.bucketSort(arr);

        System.out.println(Arrays.toString(arr));
    }

}
