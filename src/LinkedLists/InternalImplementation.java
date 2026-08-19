package LinkedLists;

import java.util.LinkedList;

public class InternalImplementation {
    public static void main(String[] args) {

        LinkedList<Integer> list = new LinkedList<>();

        list.add(0);
        list.addLast(1);

        System.out.println(list);

        list.removeFirst();
        list.removeLast();
        System.out.println(list);
    }
}
