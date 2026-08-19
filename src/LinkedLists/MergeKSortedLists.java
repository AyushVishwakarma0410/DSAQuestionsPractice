package LinkedLists;

import java.util.ArrayList;

public class MergeKSortedLists {
    public static void main(String[] args) {




    }
    // k = total linkedlist present
    // n = size of each LL
    public static Node merge(int k, int n, ArrayList<Node> list){

        if(k==1){
            return list.get(list.size()-1);
        }

        Node merge = merge(list.get(0),list.get(1));
        if(k > 2) {
            for (int i = 2; i < k; i++) {
                merge = merge(merge, list.get(i));
            }
        }

        return merge;

    }

    public static Node merge(Node left, Node right){

        // making a list with single node -1
        Node mergeLL = new Node(-1);
        Node temp = mergeLL;

        while (left!=null && right != null){

            if(left.value <= right.value){
                temp.next = left;
                left = left.next;
            }else {
                temp.next = right;
                right = right.next;
            }
            temp = temp.next;

        }


        // Attach remaining nodes
        if (left != null) {
            temp.next = left;
        }
        if (right != null) {
            temp.next = right;
        }

        return mergeLL.next;
    }



    // for efficient TC

    // recursion + merging
    public static Node mergeK(ArrayList<Node> list, int start, int end) {

        // return the list
        if (start == end) return list.get(start);

        // divide arrayList in two parts
        int mid = (start + end) / 2;

        // divide further
        Node left = mergeK(list, start, mid);
        // divide further
        Node right = mergeK(list, mid + 1, end);

        // merge
        return merge(left, right);
    }

}
