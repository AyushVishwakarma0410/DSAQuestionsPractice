package ArraysAplha;

public class KadanesAlgorithmMaximumSubArraySum {
    public static void main(String[] args) {
        int [] arr = {-3,-2,-1,-3,-4,-222,-1,-3,-4};
        int [] number = {4,-4,2,3,2,-2,1,4,6,-4,1};
    }

    static int kadanes(int [] arr){

        int cs = 0;
        int ms = Integer.MIN_VALUE;


        // To check if the array is full of neg- or not 
        boolean flag = true;
        // true -> full of neg- return max value
        // false -> use kadane algo
        int maxNumber = Integer.MIN_VALUE;
        for( int num : arr){

                  maxNumber = Math.max(num,maxNumber);
            if(num > 0){
                flag = false;
            }
        }




        if(flag==false) {
            for (int i = 0; i < arr.length; i++) {
                cs = cs + arr[i];
                if (cs < 0) {
                    cs = 0;
                }
                ms = Math.max(cs, ms);

            }
            return ms;
        }
        else {
            return maxNumber;
        }


    }
}
