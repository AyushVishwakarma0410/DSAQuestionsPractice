    package Heaps.FiftyQuestionrush;

    import java.util.*;

    public class kClosestToOrigin {
        public static void main(String[] args) {


            int [][] point = {{1,3},{-2,2}};

            int [][] arr =  kClosest(point,1);

            for (int[] a : arr){
                System.out.println(Arrays.toString(a));
            }
        }

        public static int[][] kClosest(int[][] points, int k) {

            PriorityQueue<int[][]> q = new PriorityQueue<>((a, b) -> Integer.compare(b[0][0], a[0][0]));
            int count = 0;
           for (int i = 0; i < points.length;i++){
                int area = (points[i][0]*points[i][0]) + (points[i][1]*points[i][1]);
                int [][] arr = new int[1][3];
                arr[0][0] = area;
                arr[0][1] = points[i][0];
                arr[0][2] = points[i][1];

                q.add(arr);
                if(q.size() > k) {
                   q.poll();
                }

           }
            // Extract only the coordinates for the result
            int[][] result = new int[k][2];
            int i = 0;
            while (!q.isEmpty()) {
                int[][] top = q.poll();
                result[i][0] = top[0][1];
                result[i][1] = top[0][2];
                i++;
            }

            return result;
        }



        // Different version but well written by gpt






//        package Heaps.FiftyQuestionrush;
//
//import java.util.*;
//
//        public class kClosestToOrigin {
//            public static void main(String[] args) {
//
//                int[][] points = {{1, 3}, {-2, 2}, {5, 8}, {0, 1}};
//
//                int[][] arr = kClosest(points, 2);
//
//                for (int[] a : arr) {
//                    System.out.println(Arrays.toString(a));
//                }
//            }
//
//            public static int[][] kClosest(int[][] points, int k) {
//
//                // Max-heap based on distance
//                PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[0]*b[0] + b[1]*b[1], a[0]*a[0] + a[1]*a[1]));
//
//                for (int[] point : points) {
//                    pq.add(point);
//                    if (pq.size() > k) {
//                        pq.poll(); // remove farthest if more than k elements
//                    }
//                }
//
//                // Collect k closest points
//                int[][] result = new int[k][2];
//                int i = 0;
//                while (!pq.isEmpty()) {
//                    result[i++] = pq.poll();
//                }
//
//                return result;
//            }
//        }
    }
