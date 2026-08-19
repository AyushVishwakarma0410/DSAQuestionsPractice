package LinkedLists.DoubleLinkedLists;

public class Node {
    int value;
    Node prev;
    Node next;

    Node(int value){
        this.value = value;
        this.prev = null;
        this.next = null;
    }
    public static Node head;
    public static Node tail;
    public static int size;
}
