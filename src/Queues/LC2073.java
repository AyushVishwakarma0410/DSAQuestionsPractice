package Queues;

import java.util.LinkedList;
import java.util.Queue;

public class LC2073 {
    public static void main(String[] args) {

        int [] tickets = {5,1,1,1};
        System.out.println(timeRequiredToBuy(tickets,0));

    }
    public static int timeRequiredToBuy(int[] tickets, int k) {


        Queue<Integer> q = new LinkedList<>();

        for(int num : tickets){
            q.add(num);
        }

        int target = tickets[k];
        int ans = 0;
        while (!q.isEmpty() && target>0 ){



            int val = q.poll() -1;
            ans++;
            if(k==0 ){
                k = q.size();
                target--;
            }else
                k--;

            if(val!=0){
                q.add(val);
            }

        }




        return ans;
    }
}
