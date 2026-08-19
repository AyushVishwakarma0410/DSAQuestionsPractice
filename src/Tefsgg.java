

// biweekly contest solved question


public class Tefsgg {
    public static void main(String[] args) {

        int [] nums = { 0,1,0,3,12};

        System.out.println(minimumSwaps(nums));


        System.out.println(4 % 3);

    }
        public static int minimumSwaps(int[] nums) {
            int count = 0;
            int i = 0;
            int j = nums.length-1;

            while(i < j){


                if(nums[i]==0 && nums[j]!=0){
                    count++;
                    swap(i,j,nums);

                }

                if(nums[i]!=0){
                    i++;
                }

                if(nums[j]==0){
                    j--;
                }



            }

            return count;


        }

        public static void swap(int i, int j, int [] nums){

            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;


        }




        // Question 2

    public static int minOperations(int[] nums, int k) {



        int n = nums.length;

        int res = Integer.MAX_VALUE;

        for (int x = 0; x < k; x++) {
            for (int y = 0; y < k; y++) {


                // if same values, skip
                if(x==y){
                    continue;
                }

                int ans = 0;

                for (int i = 0; i < n ; i++) {

                    int target =  i % 2 == 0 ? x : y ;
                    int diff = Math.abs((nums[i] % k) - target);
                    ans += Math.min(diff, k - diff);





                }


                res = Math.min(ans,res);
            }
        }
        
        return res;
    }


}
