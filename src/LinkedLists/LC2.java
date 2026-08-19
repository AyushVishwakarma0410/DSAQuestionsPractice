package LinkedLists;

public class LC2 {
    public static void main(String[] args) {

    }

    // alr used some help but i will accept it
    public Node addTwoNumbers(Node l1, Node l2) {


        Node res = new Node(0);
        Node temp = res;
        int quotient = 0;

        while (l1!=null || l2 != null) {

            int val1 = 0;
            if(l1!=null){
                val1 = l1.value;
            }

            int val2 = 0;
            if(l2!=null){
                val2 = l2.value;
            }

            int sum = val1 + val2 + quotient ;

            int remainder = sum % 10;

            res.next = new Node(remainder);
            res = res.next;

            quotient = sum / 10;


            if(l1!=null)
                l1 = l1.next;
            if(l2!=null)
                l2 = l2.next;
        }

        if(quotient > 0){
            res.next = new Node(quotient);
        }

        return temp.next;
    }

}
