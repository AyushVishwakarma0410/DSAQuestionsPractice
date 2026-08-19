package LinkedLists;

import DivideAndConqueor.MergeSort;

public class MergeSortLL {
    public static void main(String[] args) {

    }

    public static Node MergeSort(Node head){

        if(head==null || head.next == null){
            return head;
        }

        // 1. mid

        Node slow = head;
        Node fast = head.next;
        // caution : we start with fast.next because we want mid to be at pos
        // mid - 1 so that we can divide it in half
        // would have made a separate function but nope
        while (fast!=null && fast.next!=null){
            slow = slow.next;
            fast=fast.next.next;
        }




        Node rightHead = slow.next;
        slow.next = null;
        Node leftPart = MergeSort(head);
        Node rightPart = MergeSort(rightHead);


        return merge(leftPart,rightPart);

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
}
