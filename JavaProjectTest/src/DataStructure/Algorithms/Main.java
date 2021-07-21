package DataStructure.Algorithms;

import DataStructure.Algorithms.Searching.BinarySearching;
import DataStructure.Algorithms.Searching.ExponentialSearch;
import DataStructure.Algorithms.Searching.JumpSearch;
import DataStructure.Algorithms.Searching.LinearSearching;
import DataStructure.Algorithms.Searching.TernarySearch;
import DataStructure.Algorithms.Sorting.BubbleSort;
import DataStructure.Algorithms.Sorting.CountingSort;
import DataStructure.Algorithms.Sorting.InsertionSort;
import DataStructure.Algorithms.Sorting.MergeSort;
import DataStructure.Algorithms.Sorting.SelectionSorting;
import DataStructure.Algorithms.StringManipulation.StringUtils;
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

        LinearSearching search1 =new LinearSearching();
        BinarySearching search2 = new BinarySearching();
        TernarySearch search3 = new TernarySearch();
        JumpSearch search4 = new JumpSearch();
        ExponentialSearch search5 = new ExponentialSearch();

        search5.exponentialSearch(arr,6);

    
        StringUtils.vowels("");
        StringUtils.reverseString2("Hello World");
        StringUtils.reverseWords2("Hello World from the other side");
        StringUtils.rotationSolution("ABCD", "DABC");
        StringUtils.removeDuplicates("Heelllooooo!!!");
        StringUtils.mostRepeated("HIIIIII!!");
        StringUtils.capitilizeFirstLetter("hello this is my name");
        StringUtils.anagrams("aaab", "baaa");
        StringUtils.palindrome2("");
    }

}
