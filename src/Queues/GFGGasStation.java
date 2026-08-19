//package Queues;
//
//import java.util.LinkedList;
//import java.util.Queue;
//public class GFGGasStation {
//    public static void main(String[] args) {
//
//        int [] gas = {5,5,5};
//        int [] cost = {5,5,5};
//        int ans = startStation(gas,cost);
//        System.out.println(ans);
//    }
//    public static int startStation(int[] gas, int[] cost) {
//        // code here
//
//
//        // Iteration 1
//        for (int i = 0; i < gas.length; i++) {
//
//            int current = (i+1 )% gas.length;
//            int total ;
//
////            Queue<Integer> queue = new LinkedList<>();
////
////            // push all elements in queue
////            while(queue.size() != gas.length-1){
////                queue.add(gas[current]);
////                current =(current+1)% gas.length;
//////                System.out.println(current);
////            }
//////            System.out.println(queue);
//
////             working
//            current = i;
//            total = gas[current];
//            while (true){
//                total -= cost[current];
//                // cost is high
//                if(total < 0){
//                    break;
//                }
//
//                current = (current+1) % gas.length;
//                if(current == i){
//                    return i;
//                }
//                total += gas[current];
//            }
//
//
//
//
//
//
//        }
//
//
//        return -1;
//    }
//
//}
