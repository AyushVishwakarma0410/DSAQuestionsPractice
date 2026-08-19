package PriorityQueues;

import java.util.PriorityQueue;

public class QNearbyCars {
    public static void main(String[] args) {

        int [][] pts = {{3,3},{5,-1},{-2,4}};
        int k = 3;
        PriorityQueue<Point> q = new PriorityQueue<>();

        for (int i = 0; i < pts.length; i++) {
            int distsq = pts[i][0] * pts[i][0] + pts[i][1] * pts[i][1];
            q.add(new Point(pts[i][0],pts[i][1],distsq,i));
        }

        for (int i = 0; i < k; i++) {
            System.out.println("C" + q.remove().idx);
        }

    }
    static class Point implements Comparable<Point>{
        int x;
        int y;
        int distSq;

        // extra var idx for showing which car it is
        int idx;
        public Point(int x, int y,int distSq,int idx){
            this.x = x;
            this.y = y;
            this.distSq = distSq;
            this.idx = idx;
        }

        @Override
        public int compareTo(Point p2){
            return this.distSq - p2.distSq;
        }
    }
}
