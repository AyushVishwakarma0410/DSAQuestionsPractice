package Heaps.FiftyQuestionrush;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Comparator;
public class LC378 {
    public static void main(String[] args) {
        int [][] matrix  = {{1,3},{2,4}};
        System.out.println(kthSmallest(matrix,2));
    }
    public static int kthSmallest(int[][] matrix, int k) {


        PriorityQueue<Integer> q = new PriorityQueue<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {

                q.add(matrix[i][j]);
            }
        }
        int count = 1;
        while (count<k){
            q.poll();
            count++;
        }

        return  q.isEmpty() ? -1 : q.poll();
    }
    public static int kthSmallest2(int[][] matrix, int k) {


        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {


                q.add(matrix[i][j]);
                if(q.size() > k){
                    q.poll();
                }
            }
        }




        return  q.poll();
    }
}
