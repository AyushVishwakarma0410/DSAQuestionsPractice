package GreedyAlgorithm;

import java.util.ArrayList;
import java.util.Collections;

public class JobSequencingProblem__OBJECTSORTING__ {

    static class Job{
        int deadline;
        int profit;
        int id; // 0(A),1(B),2(C),3(D)

        public Job(int id, int deadline, int profit){
            this.id = id;
            this.deadline = deadline;
            this.profit = profit;
        }


    }
    public static void main(String[] args) {

        int[][] jobsInfo = {{4,20},{1,10},{1,40},{1,30}};

        ArrayList<Job> jobs= new ArrayList<>();

        for( int i = 0; i < jobsInfo.length;i++){
            jobs.add(new Job(i,jobsInfo[i][0],jobsInfo[i][1]));
        }

        Collections.sort(jobs,(a,b)->b.profit-a.profit); // descending order of profit



        ArrayList<Integer> seq = new ArrayList<>();
        int time=0;
        for (int i = 0; i < jobs.size(); i++) {



            Job curr = jobs.get(i);

            if(curr.deadline > time){
                seq.add(curr.id);
                time++;
            }

        }

        System.out.println(seq.size()); // max jobs
        System.out.println(seq); // indexes

    }
}
