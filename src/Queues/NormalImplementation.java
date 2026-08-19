package Queues;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.LinkedList;

public class NormalImplementation {
    public static void main(String[] args) {

        // This uses a LinkedList as the underlying data structure [1]. LinkedList implements both the Queue and Deque interfaces, and is useful when you need frequent insertions and deletions at both ends of the list [2, 1].
        Queue<Integer> q = new LinkedList<>();

        //This uses an ArrayDeque, which is a resizable-array implementation of the Deque interface [3]. ArrayDeque is generally more efficient than LinkedList for queue operations and should be preferred in most scenarios where a simple queue is needed [3].
        Queue<Integer> q2 = new ArrayDeque<>();

        // In summary, the key difference lies in performance characteristics and internal data
        // handling: ArrayDeque is typically faster for standard queue operations, while
        // LinkedList offers more flexibility as a doubly-linked list.

    }
}
