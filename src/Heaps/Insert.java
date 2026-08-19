package Heaps;

import java.util.ArrayList;

public class Insert {
    public static void main(String[] args) {

        ArrayList<Integer> res = new ArrayList<>();
        res.add(1);
//        res.add(2);
//        res.add(3);
//        res.add(0);
//        res.add(6);
//        res.add(5);

        Heap h = new Heap();
        h.add(50);
        h.add(40);
        h.add(30);
        h.add(20);
        h.add(10);

    }
    // Two-step process.
    // 1. add at last index.
    // 2. fix heap.

    static class Heap{
        ArrayList<Integer> arr = new ArrayList<>();


        // Add
        public void add(int data){
            arr.add(data);

            // child index
            int x = arr.size() - 1;

            // fix heap (min-heap)
            while (x > 0) {
                int par = (x - 1) / 2;

                if (arr.get(x) < arr.get(par)) {
                    // swap
                    int temp = arr.get(x);
                    arr.set(x, arr.get(par));
                    arr.set(par, temp);

                    // move up
                    x = par;
                } else {
                    break;
                }
            }
        }



        // peek
        public int peek(){
            if(arr.isEmpty()) return -1;
            return arr.get(0);
        }


        // remove
        public int remove(){
            if(arr.isEmpty()) return -1;
            int data = arr.get(0);

            // step 1 : swap first and last
            int temp = arr.get(0);
            arr.set(0, arr.get(arr.size()-1));
            arr.set(arr.size()-1,temp);


            // step 2 : remove last
            arr.remove(arr.size()-1);


            // step 3 : heapify
            heapify(0);
            return data;
        }

        private void heapify(int i){
            int left = 2*i+1;
            int right = 2*i+2;
            int minIdx = i;

            if(left < arr.size() && arr.get(minIdx) > arr.get(left)){
                minIdx = left;
            }
            if(right < arr.size() && arr.get(minIdx) > arr.get(right)){
                minIdx = right;
            }

            if(minIdx!=i){

                int temp = arr.get(i);
                arr.set(i, arr.get(minIdx));
                arr.set(minIdx, temp);

                heapify(minIdx);
            }
        }
    }
    static class maxHeap{
        ArrayList<Integer> arr = new ArrayList<>();
        public void add(int data){
            arr.add(data);

            // child index
            int x = arr.size() - 1;

            // fix heap (min-heap)
            while (x > 0) {
                int par = (x - 1) / 2;

                if (arr.get(x) > arr.get(par)) {
                    // swap
                    int temp = arr.get(x);
                    arr.set(x, arr.get(par));
                    arr.set(par, temp);

                    // move up
                    x = par;
                } else {
                    break;
                }
            }
        }

        public int peek(){
            if(arr.isEmpty()) return -1;
            return arr.get(0);
        }


        // remove
        public int remove(){
            if(arr.isEmpty()) return -1;
            int data = arr.get(0);

            // step 1 : swap first and last
            int temp = arr.get(0);
            arr.set(0, arr.get(arr.size()-1));
            arr.set(arr.size()-1,temp);


            // step 2 : remove last
            arr.remove(arr.size()-1);


            // step 3 : heapify
            heapify(0);
            return data;
        }


        private void heapify(int i){
            int left = 2*i+1;
            int right = 2*i+2;
            int maxIdx = i;

            if(left < arr.size() && arr.get(maxIdx) < arr.get(left)){
                maxIdx = left;
            }
            if(right < arr.size() && arr.get(maxIdx) < arr.get(right)){
                maxIdx = right;
            }

            if(maxIdx!=i){

                int temp = arr.get(i);
                arr.set(i, arr.get(maxIdx));
                arr.set(maxIdx, temp);

                heapify(maxIdx);
            }
        }
    }



}
