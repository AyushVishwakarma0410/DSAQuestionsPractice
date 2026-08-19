package TCS.Claude;

public class Q1BobBetting {
    public static void main(String[] args) {


        int [] arr ={30,40,50,20,20,10,90,10,10,10};
        int k = 100;

        System.out.println(bet(arr,k));
    }



    ///  READ THE QUESTIOONNN BICHHH

    // subarray sum >k
    public static int bet(int [] arr, int k){

        int currentSum = 0;

        int start = 0;
        int maxRange = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            currentSum+= arr[i];
            while (currentSum >= k){
                currentSum -= arr[start];

                start++;
                }
           maxRange =  Math.max(maxRange,i - start +1);
        }

        return maxRange;

    }
}
