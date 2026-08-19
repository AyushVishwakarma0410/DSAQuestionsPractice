package Heaps;

import java.util.ArrayList;

public class Test {

    static class Heap{

        ArrayList<Integer> list = new ArrayList<>();

        public void add(int data){

            list.add(data);

            // heapifyUp

            int x  = list.size()  -1;

            while (x>0){
                int parent = (x - 1)/2;

                if(list.get(x) < list.get(parent)){
                    int temp = list.get(x);
                    list.set(x,list.get(parent));
                    list.set(parent,temp);

                    x = parent;
                }else {
                    break;
                }

            }

        }



    }

    public static int remove(ArrayList<Integer> list){

        int data = list.get(0);

        int x = list.size()-1;

        int temp = list.get(x);
        list.set(x,list.get(0));
        list.set(0,temp);

        list.remove(x);

        // heapifyDown

        heapifyDown(0,list);


        return data;

    }
    public static void heapifyDown(int idx,ArrayList<Integer> list){

        int left = 2 * idx + 1;
        int right = 2 * idx + 2;
        int minIdx = idx;

        if(left < list.size() && list.get(minIdx) > list.get(left)){
                minIdx = left;
        }
        if(right < list.size() && list.get(minIdx) > list.get(right) ){
            minIdx = right;
        }

        if(minIdx!=idx){
            int temp = list.get(idx);
            list.set(idx,list.get(minIdx));
            list.set(minIdx,temp);

            heapifyDown(minIdx,list);
        }




    }

    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5,6};
        Heap h = new Heap();
        for (int i = 0; i < arr.length;i++){
            h.add(arr[i]);
        }
        System.out.println(h.list);

        ArrayList<Integer> sortedList = new ArrayList<>();


        int n = h.list.size();
        for (int i = 0; i < n; i++) {
            sortedList.add(remove(h.list));
        }

        System.out.println(h.list);
        System.out.println(sortedList.reversed());
    }


}
