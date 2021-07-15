package DataStructure.Algorithms;

import DataStructure.Algorithms.Sorting.BubbleSort;
import DataStructure.Algorithms.Sorting.InsertionSort;
import DataStructure.Algorithms.Sorting.SelectionSorting;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = { 4, 2, 3, 5, 1, 7, 8 };
        BubbleSort bubble = new BubbleSort();
        SelectionSorting sort = new SelectionSorting();
        InsertionSort sort2 = new InsertionSort();
        arr = sort2.insertionSort(arr);

        System.out.println(Arrays.toString(arr));
    }

}
