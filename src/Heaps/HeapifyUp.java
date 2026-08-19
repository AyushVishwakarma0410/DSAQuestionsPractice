package Heaps;

import java.util.ArrayList;

public class HeapifyUp {

    ArrayList <Integer> arr = new ArrayList<>();

/// Heapify direction depends on where violation is, not what operation you did.


    // Used when adding
    public void heapifyUp(int i) {
        while (i > 0) {
            int parent = (i - 1) / 2;

            if (arr.get(i) < arr.get(parent)) {
                // swap
                int temp = arr.get(i);
                arr.set(i, arr.get(parent));
                arr.set(parent, temp);

                i = parent; // move up
            } else {
                break;
            }
        }
    }
}
