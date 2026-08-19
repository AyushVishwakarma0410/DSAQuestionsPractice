package GreedyAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class NActivityProblem {
    public static void main(String[] args) {
        int [] start = {1,3,0,5,8,5};
        int [] end = {2,4,6,7,9,9};

/*--------------------------------------------------------------------------------------------------------------------*/

//        // In case we need sorting we go



//        int [][] activities = new int[start.length][3];
//        for(int i = 0; i < start.length;i++){
//
//            activities[i][0] = i;
//            activities[i][1] = start[i];
//            activities[i][2] = end[i];
//
//        }
//
//        // lambda expression
//        Arrays.sort(activities, Comparator.comparingDouble(o->o[2]) );
//
//
//        // endtime based sorted
//        int maximumActivities = 0;
//
//        ArrayList<Integer> list = new ArrayList<>();
//        maximumActivities += 1;
//        list.add(activities[0][0]);
//
//
//        int lastEnd = activities[0][2];
//        for( int i = 1; i < end.length; i++){
//            if(activities[i][1]>=lastEnd){
//                // activity select
//                maximumActivities++;
//                list.add(activities[i][0]);
//                lastEnd = activities[i][2];
//            }
//        }
//
//        System.out.println(maximumActivities);
//
//

/*---------------------------------------------------------------------------------------------------------------------*/
        // endtime based sorted
        int maximumActivities = 0;

        ArrayList<Integer> list = new ArrayList<>();
        maximumActivities += 1;
        list.add(0);


        int lastEnd = end[0];
        for( int i = 1; i < end.length; i++){
            if(start[i]>=lastEnd){
                // activity select
                maximumActivities++;
                list.add(i);
                lastEnd = end[i];
            }
        }

        System.out.println(maximumActivities);
    }
}
