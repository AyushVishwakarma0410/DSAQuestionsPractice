package Heaps.FiftyQuestionrush;

import java.util.ArrayList;

public class Q1KthLargest {
    public static void main(String[] args) {

        int arr[] = {4,56,2,1,3,5};

        Heap h = new Heap();
        System.out.println(KthLargest(arr,2));



    }

    public static int KthLargest(int [] arr,int k){

        if(k > arr.length){
            return -1;
        }

        Heap h = new Heap();
        for (int num : arr){
            h.add(num);
        }
        int data = 0;
        while (k!=0){
            data = h.list.get(0);

// swap root with last element
            int lastIdx = h.list.size() - 1;
            h.list.set(0, h.list.get(lastIdx));

// remove last
            h.list.remove(lastIdx);

// fix heap
            h.heapifyDown(0);
            k--;
        }

        return data;
    }

    static class Heap {


        ArrayList<Integer> list = new ArrayList<>();

        public void add(int data) {

            list.add(data);
            // child idx
            int x = list.size() - 1;


            // heapify up
            while (x > 0) {
                int parent = (x - 1) / 2;

                if (list.get(parent) < list.get(x)) {
                    int temp = list.get(x);
                    list.set(x, list.get(parent));
                    list.set(parent, temp);
                }
                x = parent;
            }

        }
        public  void heapifyDown ( int idx){

                int left = 2 * idx + 1;
                int right = 2 * idx + 2;
                int maxIdx = idx;
                if (left < list.size() && list.get(left) > list.get(maxIdx)) {
                    maxIdx = left;
                }
                if (right < list.size() && list.get(right) > list.get(maxIdx)) {
                    maxIdx = right;
                }

                if (maxIdx != idx) {
                    int temp = list.get(maxIdx);
                    list.set(maxIdx, list.get(idx));
                    list.set(idx, temp);
                    heapifyDown(maxIdx);
                }


            }


    }
}
