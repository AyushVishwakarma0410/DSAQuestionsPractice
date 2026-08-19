package LinkedLists;

import java.util.ArrayList;
import java.util.Objects;

public class LLQ1 {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(6);
        head.next.next.next.next = new Node(7);
        Node head2 = new Node(4);
        head2.next = new Node(5);
        head2.next.next = head.next.next.next;

        getNodeConnection(head,head2);

    }


    public static Node getNodeConnection(Node head1, Node head2){



        // suppose l1 size m
        // l2 size n
        // common ll = c
        // l1 elements before getting same = a
        // l2 elements before getting same = b
        // a + c = m
        // b + c = n
        // m - a = n - b





    /*

    If:

List A length = m
List B length = n

After switching:

Pointer1 travels: m + n

Pointer2 travels: n + m

They align automatically.

Time Complexity: O(m+n)
Space Complexity: O(1)

     */

        Node ptr1 = head1;
        Node ptr2 = head2;

        while (ptr1 != ptr2){
            ptr1 = ptr1==null? head2 : ptr1.next;
            ptr2 = ptr2==null? head1 : ptr2.next;
        }

        return ptr1;






        //         wrong because i compared values


//        ArrayList<Integer>list1 =  new ArrayList<>();
//        ArrayList<Integer> list2 = new ArrayList<>();
//
//        while (head1.next!=null){
//            list1.add(head1.value);
//            head1 = head1.next;
//        }
//
//
//        while (head2.next!=null){
//            list2.add(head2.value);
//            head2 = head2.next;
//        }
//
//        int index1 = list1.size()-1;
//
//        int index2 = list2.size()-1;
//
//        int ans = 0;
//
//            while (Objects.equals(list1.get(index1), list2.get(index2))) {
//               ans = list1.remove(list1.size() - 1);
//                list2.remove(list2.size() - 1);
//                index1--;
//                index2--;
//            }
//
//        System.out.println(ans);


    }

}
