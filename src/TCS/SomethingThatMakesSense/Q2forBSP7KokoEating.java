package TCS.SomethingThatMakesSense;

public class Q2forBSP7KokoEating {
    public static void main(String[] args) {

    }
    public static int eating(int [] piles, int Hours){








        // pehle sahi socha tha nvm
        int min = 1;
        int max = 0;

        for (int pile:piles){
            max = Math.max(pile,max) ;
        }

            int ans = 0;
        while (min <= max){



            int mid = ( min + max )/2;

            // Safety check: mid can't be 0
            if (mid == 0) {
                min = 1;
                continue;
            }


            if(isPossible(piles,mid,Hours)){
                ans = mid;
                max = mid -1;
            }else {
                min = mid + 1;
            }

        }

        return ans;
    }

// Approaches for isPossible function

    // Approach 1 - hard
    // modular arithmetic of clock is used i.e. (value + divisor - 1) / divisor
    // just pushes enough


    // Approach 2 - easy
    // use division and modulo
    public static boolean isPossible(int [] arr, int speed, int allowed){

        // Approach 1

        int currentHours = 0;


        for (int pile : arr){

            currentHours += (pile+ speed -1)/ speed;

        }

        return currentHours <= allowed;

    }

}
