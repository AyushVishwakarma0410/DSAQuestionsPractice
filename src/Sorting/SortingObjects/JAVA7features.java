package Sorting.SortingObjects;

import java.util.Arrays;
import java.util.Comparator;

public class JAVA7features {


    // using Comparable Interface





    // Natural Order Sorting

    /*

    Methods like:

    Comparator.comparingInt()
    Comparator.comparingDouble()

    are designed for objects (like Student, Employee, etc.), not for primitive 2D arrays like:
    int[][] arr


    BUT STILL THEY FREAKING WORK
     */

    static class Student implements Comparable<Student> {
        int marks;
        int age;

        Student(int marks, int age) {
            this.marks = marks;
            this.age = age;
        }

        @Override
        public int compareTo(Student other){
            return this.marks - other.marks;
        }
    }

    public static void main(String[] args) {

        Student[] arr = {
                new Student(90, 20),
                new Student(70, 22),
                new Student(80, 21)
        };

        Arrays.sort(arr);



        int [][] arr2 = new  int[3][2];

//        You are NOT comparing arrays directly
//        You are comparing values extracted from arrays

        Arrays.sort(arr2, Comparator.comparingInt(a -> a[1]));
    }
}
