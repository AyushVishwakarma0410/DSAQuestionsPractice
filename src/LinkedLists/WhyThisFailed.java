///**
// * Definition for singly-linked list.
// * class ListNode {
// *     int val;
// *     ListNode next;
// *     ListNode(int x) {
// *         val = x;
// *         next = null;
// *     }
// * }
// */
//
//// hinted by gpt
//public class Solution {
//    public ListNode detectCycle(ListNode head) {
//        ListNode fast = head;
//        ListNode slow = head;
//        while(fast!=null && fast.next!=null){
//            slow = slow.next;
//            fast = fast.next.next;
//            if(fast==null){
//                return null;
//            }
//
//            if(fast==slow){
//                break;
//            }
//        }
//
//        ListNode temp = head;
//
//        while(temp!=fast){
//            temp = temp.next;
//            fast = fast.next;
//        }
//
//        return temp;
//    }
//
//}