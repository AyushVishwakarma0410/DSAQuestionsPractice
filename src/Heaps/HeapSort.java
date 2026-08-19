package Heaps;

import java.lang.reflect.Array;
import java.util.ArrayList;


// borrowed logic but self implemented with two mistakes.
public class HeapSort {
    public static void main(String[] args) {
     int [] arr = {5,4,6,1,2,3,7};

        System.out.println(heapSort(arr));

    }

    static ArrayList<Integer> heapSort(int [] arr){
        HeapSort ob = new HeapSort();
        ob.add(arr);

        ArrayList<Integer> list2 = new ArrayList<>();
        int n = list.size();
        for (int i = 0; i < n; i++) {
            list2.add(ob.remove());
        }


        return list2;
    }

    // remove
    public static int remove(){
        if(list.isEmpty()) return -1;
        int data = list.get(0);

        // step 1 : swap first and last
        int temp = list.get(0);
        list.set(0, list.get(list.size()-1));
        list.set(list.size()-1,temp);


        // step 2 : remove last
        list.remove(list.size()-1);


        // step 3 : heapify
        heapify(0);
        return data;
    }

    static void heapify(int i){
        int left = 2*i+1;
        int right = 2*i+2;
        int minIdx = i;

        if(left < list.size() && list.get(minIdx) > list.get(left)){
            minIdx = left;
        }
        if(right < list.size() && list.get(minIdx) > list.get(right)){
            minIdx = right;
        }

        if(minIdx!=i){

            int temp = list.get(i);
            list.set(i, list.get(minIdx));
            list.set(minIdx, temp);

            heapify(minIdx);
        }
    }


    static ArrayList<Integer> list = new ArrayList<>();
     void add(int [] arr){
        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);

            int x = list.size()-1;


            // heapify up
            while (x > 0){
                int parent = (x-1)/2;

                if(list.get(x) < list.get(parent)){
                    int temp = list.get(x);
                    list.set(x,list.get(parent));
                    list.set(parent, temp);

                    x = parent;
                }else {
                    break;
                }
            }


        }
    }
}





//  IDEAL VERSION






//public class HeapSort {
//
//    public static void main(String[] args) {
//        int[] arr = {5, 4, 6, 1, 2, 3, 7};
//
//        heapSort(arr);
//
//        for (int num : arr) {
//            System.out.print(num + " ");
//        }
//    }
//
//    public static void heapSort(int[] arr) {
//        int n = arr.length;
//
//        // Step 1: Build max heap
//        for (int i = n / 2 - 1; i >= 0; i--) {
//            heapify(arr, n, i);
//        }
//
//        // Step 2: Extract elements one by one
//        for (int i = n - 1; i > 0; i--) {
//
//            // Move current root to end
//            int temp = arr[0];
//            arr[0] = arr[i];
//            arr[i] = temp;
//
//            // Heapify reduced heap
//            heapify(arr, i, 0);
//        }
//    }
//
//    // Heapify (max heap)
//    public static void heapify(int[] arr, int n, int i) {
//        int largest = i;
//        int left = 2 * i + 1;
//        int right = 2 * i + 2;
//
//        if (left < n && arr[left] > arr[largest]) {
//            largest = left;
//        }
//
//        if (right < n && arr[right] > arr[largest]) {
//            largest = right;
//        }
//
//        if (largest != i) {
//            int temp = arr[i];
//            arr[i] = arr[largest];
//            arr[largest] = temp;
//
//            heapify(arr, n, largest);
//        }
//    }
//}