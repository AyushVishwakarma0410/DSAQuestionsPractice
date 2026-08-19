package Heaps.FiftyQuestionrush;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Q2StoneWeight {

    public static void main(String[] args) {
        int [] arr = {2,7,4,1,8,1};

            int ans = stoneWeight(arr);
        System.out.println(ans);

    }

    public static int stoneWeight(int [] arr){
        PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());
        for (int num : arr){
            q.add(num);
        }

        while (!q.isEmpty()){
            int first = q.poll();
            if(q.isEmpty()) return first;
            int second = q.poll();

            q.add(Math.abs(first-second));
        }

        return 0;
    }


}
