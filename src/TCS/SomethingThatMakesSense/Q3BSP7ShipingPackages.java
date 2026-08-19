package TCS.SomethingThatMakesSense;

public class Q3BSP7ShipingPackages {
    public static void main(String[] args) {

    }

    public int shipWithinDays(int[] weights, int days) {
/*
The Correct Logic: For shipping packages, the smallest possible capacity must be the heaviest package.
 If you have a 10kg package, a 5kg boat can never carry it
 */
        int min = 0;
        int max = 0;

        for (int weight : weights){
            min = Math.max(min,weight);
            max += weight;
        }

        int ans = 1;
        while (min <= max){

            int mid = (min + max)/2;


            if(isPossible(weights,mid,days)){
                ans = mid;

                max = mid - 1;
            }else {
                min = mid + 1;
            }

        }

        return ans;

    }

    public static boolean isPossible(int [] arr, int mid, int days){

        int currentWeight = 0;
        int currentDays = 1;

        for(int num : arr){
            if(currentWeight + num > mid){
                currentDays++;
                currentWeight = 0;
            }

            currentWeight += num;



        }

        return currentDays <= days;

    }
}
