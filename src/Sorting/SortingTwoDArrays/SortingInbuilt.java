package Sorting.SortingTwoDArrays;

import java.util.Arrays;
import java.util.Comparator;

public class SortingInbuilt {

    public static void main(String[] args) {

        int[][] arr = {{4, 1}, {2, 2}, {1, 2}, {3, 4}};

        Arrays.sort(arr,(a,b)-> Integer.compare(a[0],b[0]));

        Print2DArray.printArray(arr);
    }

}
