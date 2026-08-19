package LinkedLists.DoubleLinkedLists;

public class Implementation {

    /*
     * ================= IMPORTANT DESIGN POINTS =================
     *
     * 1️⃣ head and tail should NOT be static.
     *    - Static makes them shared across all objects.
     *    - Each linked list object must have its own head & tail.
     *
     * 2️⃣ Doubly Linked List SHOULD maintain:
     *    - head (first node)
     *    - tail (last node)
     *    - size  (optional but useful)
     *
     * 3️⃣ addLast() must use tail directly.
     *    - Traversing from head makes it O(n)
     *    - Using tail makes it O(1)
     *
     * 4️⃣ Always check head == null BEFORE using head.next
     *    - Otherwise NullPointerException happens.
     *
     * 5️⃣ While printing list:
     *    - Always use while(temp != null)
     *    - Using temp.next != null skips last node.
     *
     */

    Node head = null;   // ❌ was static before — fixed
    Node tail = null;   // ❌ was static before — fixed
    int size = 0;

    // ================= ADD FIRST =================
    public void addFirst(int value) {

        Node newNode = new Node(value);
        size++;

        if (head == null) {
            // ❌ Earlier mistake:
            // head = newNode = tail;  (WRONG order of assignment)
            // Correct:
            head = tail = newNode;
            return;
        }

        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    // ================= ADD LAST =================
    public void addLast(int value) {

        Node newNode = new Node(value);
        size++;

        if (head == null) {
            // ❌ Earlier mistake:
            // head = newNode; (tail not set + no return)
            // This created self-loop
            head = tail = newNode;
            return;
        }

        // ❌ Earlier mistake:
        // You traversed entire list (O(n)).
        // Correct way: Use tail (O(1)).

        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    // ================= REMOVE FIRST =================
    public int removeFirst() {

        // ❌ Earlier mistake:
        // if(head.next == null || head == null)
        // Wrong order → causes NullPointerException

        if (head == null) {
            throw new RuntimeException("List is empty");
        }

        int val = head.value;

        if (head.next == null) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }

        size--;
        return val;
    }

    // ================= PRINT LIST =================
    public void print() {

        Node temp = head;

        System.out.print("null <-> ");

        // ❌ Earlier mistake:
        // while(temp.next != null)
        // This skipped last node.

        while (temp != null) {
            System.out.print(temp.value + " <-> ");
            temp = temp.next;
        }

        System.out.println("null");
    }

    // ================= PRINT REVERSE =================
    // Demonstrates why tail is useful
    public void printReverse() {

        Node temp = tail;

        System.out.print("null <-> ");

        while (temp != null) {
            System.out.print(temp.value + " <-> ");
            temp = temp.prev;
        }

        System.out.println("null");
    }


    // ==================REVERSE=========================

    // SAME AS OF LL
    public void reverse(){
        if(head==null || head.next == null){
            return ;
        }

        Node curr = head;
        Node next ;
        Node prev = null;
        while (curr!=null){
            next = curr.next;
            curr.next = prev;

            // this is extra added line
            curr.prev = next;

            prev = curr;
            curr = next;
        }

       tail = head;
       head = prev;
    }






    // ================= MAIN =================
    public static void main(String[] args) {

        Implementation dll = new Implementation();

        dll.addFirst(1);
        dll.addFirst(2);
        dll.addFirst(3);
        dll.addFirst(4);

        dll.print();          // Forward
        dll.printReverse();   // Backward

        dll.addLast(10);
        dll.print();

        dll.removeFirst();
        dll.print();
    }
}
