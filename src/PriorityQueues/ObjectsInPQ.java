package PriorityQueues;

import java.util.PriorityQueue;

public class ObjectsInPQ {
    public static void main(String[] args) {

        PriorityQueue<Student> q = new PriorityQueue<>();

        q.add(new Student("A",1));
        q.add(new Student("B",5));
        q.add(new Student("D",3));
        q.add(new Student("C",2));
        q.add(new Student("E",4));

        while (!q.isEmpty()){
            System.out.println(q.peek().name + "->"+ q.peek().rank);
            q.remove();
        }

    }

    static class Student implements Comparable<Student>{

        String name;
        int rank;

        public Student(String name, int rank){
            this.name = name;
            this.rank = rank;
        }

        @Override
        public int compareTo(Student s2){
            return this.rank - s2.rank;
        }
    }


}
