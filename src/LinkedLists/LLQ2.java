package LinkedLists;

public class LLQ2 {
    public static void main(String[] args) {

    }

    public static Node deleteNNodes(Node head, int M, int N){

        if(head==null){
            return head;
        }
        if(M==0){
            return null;
        }


        Node temp = head;
        while (head != null){

            int m = M-1;
            int n = N;

            Node ptr1 = head;

            // retainList
            while (m>0 && ptr1!=null){
                ptr1 = ptr1.next;
                m-=1;
            }
            if(ptr1 == null){
                break;
            }


            Node ptr2 = ptr1.next;
            while (n > 0 && ptr2!=null ){
                ptr2 = ptr2.next;
                n-=1;
            }

            // why skip this if condition as if we suddenly reached end, we dont need anything else to do ?
//            if(ptr2 == null){
//                break;
//            }

            ptr1.next = ptr2;

            head = ptr2;
        }

        return temp;

    }
}
