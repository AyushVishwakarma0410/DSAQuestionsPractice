package GreedyAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Test {
    public static void main(String[] args) {

        int amount = 500;
        System.out.println(indianCoins(amount));
    }
    public static int activitySelection(int [] start, int [] end){

        int maxActivity;
        ArrayList<Integer> arr = new ArrayList<>();


        // Sorting activities
        // 2D array with 3 columns
        // column 1 -> indices
        // column 2 -> start
        // column 3 -> end
        int [][] arr2 = new int[start.length][3];

        for (int i = 0; i < end.length; i++) {
            arr2[i][0] = i;
            arr2[i][1] = start[i];
            arr2[i][2] = end[i];
        }
        Arrays.sort(arr2, Comparator.comparingDouble(o->o[2]));

        // adding indices
        maxActivity = 1;
//        arr.add(0);
        arr.add(arr2[0][0]);
//        int lastEnd = arr[0];
        int lastEnd = arr2[0][2];
        for (int i = 1; i < end.length; i++){

            // in case start time is greater than last activity end time then
            if(lastEnd <= arr2[i][1]){
//                arr.add(i);
                arr.add(arr2[i][0]);
                lastEnd = arr2[i][2];
                maxActivity++;
            }
        }


        System.out.println(maxActivity);
        return maxActivity;
    }

    public static int fractionalKnapsack(int maxWeight,int[] weights, int[] value) {

        double [][] ratio = new double[weights.length][2];

        for (int i = 0; i < weights.length;i++){
            ratio[i][0] = i;
            ratio[i][1] = value[i]/(double)weights[i];
        }
        Arrays.sort(ratio,Comparator.comparingDouble(o->o[1]));

        double finalValue = 0;
        for (int i = weights.length-1; i >=0 ; i--) {
            int idx = (int) ratio[i][0];
            if(maxWeight >= weights[idx]){
                maxWeight-=weights[idx];
                finalValue+= value[idx];
            }else {
                    finalValue+= (ratio[i][1] * maxWeight);
                    break;
            }
        }


        System.out.println(finalValue);


        return (int)finalValue;
    }

    public static int absoluteDifference(int [] one,int [] two){

        Arrays.sort(one);
        Arrays.sort(two);

        int ans = 0;
        for (int i = 0; i < one.length ; i++) {
            ans += Math.abs(one[i]-two[i]);
        }
        return ans;

    }

    public static int maxLengthOfPairChain(int [][] pairs){

        Arrays.sort(pairs,Comparator.comparingDouble(o->o[1]));

        int ans = 0;


        int lastEnd = pairs[0][1];


        for (int i = 0; i < pairs.length; i++) {

            if(pairs[i][1]>lastEnd){
                ans++;
                lastEnd = pairs[i][1];
            }

        }

        return ans;
    }

    // just added binary search,she was using while + for loop i just optimized it
    public static int indianCoins(int amount){


        int [] range = {1,2,5,10,20,50,100,500,2000};
        int count = 0;

        while (amount!=0){
            amount  = amount - floor(range,amount);
            count++;
        }

        return count;

    }
    public static int floor(int [] range, int target){
        int start = 0;
        int end = range.length-1;


        while (start <= end){
            int mid = (start + end)/2;
            if(range[mid]==target){
                return range[mid];
            }
            else if(range[mid] < target){
                start= mid+1;
            }
            else if(range[mid] > target){
                end = mid -1;
            }
        }

        return range[end];
    }


    // lets do it using objects

    class Pair{
        int id;
        int deadLine;
        int profit;

        Pair(int i,int d, int p){
            id = i;
            deadLine = d;
            profit = p;
        }
    }
    public int jobSequencing(int[][] jobs){

        ArrayList<Pair> job = new ArrayList<>();
        for (int i = 0; i < jobs.length; i++) {
            job.add(new Pair(i,jobs[i][0],jobs[i][1]));
        }

        Collections.sort(job,(a,b)->b.profit - a.profit); // remember all this


        ArrayList<Integer> seq  = new ArrayList<>();
        int time = 0;

        for (int i = 0; i < jobs.length;i++){
            Pair  a = job.get(i);
            if(a.deadLine > time){
                seq.add(a.id);
                time++;
            }
        }


        return time;
    }

    public static int chocolaProblem(Integer[] hor, Integer [] ver){

        Arrays.sort(hor,Collections.reverseOrder());
        Arrays.sort(ver,Collections.reverseOrder());

        int h = 0;
        int v = 0;
        int hp = 1;
        int vp = 1;
        int cost = 0;

        while (h<hor.length && v < ver.length){

            if(ver[v] >= hor[h]) {
                cost += (ver[v] * vp);
                v++;
                vp++;
            }
            else {
                cost += (ver[v] * hp);
                hp++;
                h++;
            }

        }

        while (h < hor.length){
            cost += (hor[h] * vp);
            h++;
        }
        while (v < ver.length){
            cost += (ver[v] * hp);
            v++;
        }

        return cost;
    }
}
