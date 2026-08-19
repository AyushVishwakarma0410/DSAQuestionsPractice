package Heaps;

import java.util.ArrayList;

public class HeapifyDown {
    public static void main(String[] args) {

    }






    ///  Heapify direction depends on where violation is, not what operation you did.
    // used when removed an element

    ArrayList<Integer> arr = new ArrayList<>();
    void heapifyDown(int i) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int minIdx = i;

        if (left < arr.size() && arr.get(left) < arr.get(minIdx)) {
            minIdx = left;
        }

        if (right < arr.size() && arr.get(right) < arr.get(minIdx)) {
            minIdx = right;
        }

        if (minIdx != i) {
            // swap
            int temp = arr.get(i);
            arr.set(i, arr.get(minIdx));
            arr.set(minIdx, temp);

            heapifyDown(minIdx); // move down
        }
    }
}
