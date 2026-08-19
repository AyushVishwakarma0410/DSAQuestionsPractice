package Queues;
import java.util.LinkedList;
import java.util.Queue;
public class LC933 {
    public static void main(String[] args) {

        RecentCounter rc = new RecentCounter();

        System.out.println( rc.ping(1));
        System.out.println( rc.ping(100));
        System.out.println( rc.ping(3001));
        System.out.println(rc.ping(3002));



    }
    static class RecentCounter {
        int counter;
        public RecentCounter() {
            counter = 0;
        }

        Queue<Integer> q = new LinkedList<>();


        public int ping(int t) {
            q.offer(t);
            counter++;
            int min = t - 3000;
            while (!q.isEmpty() &&( q.peek() < min || q.peek() > t)){
                q.poll();
                counter--;
            }
            return counter;
        }
    }

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */
}
