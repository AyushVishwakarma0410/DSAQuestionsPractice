public class BoyerMooreAlgorithm {
    static int majorityElement(int[] arr) {

        /*
        *   Boyer–Moore works because:
            A true majority element mathematically cannot be eliminated by pair cancellation.
            That’s the entire magic.
        */


        int candidate = -1;
        int count = 0;

        for(int num : arr){
            if(count==0){
                candidate = num;
                count = 1;
            }
            else if(num == candidate){
                count++;
            }
            else {
                count--;
            }
        }
        count = 0;
        for (int num : arr){
            if(candidate == num){
                count++;
            }
        }

        if(count>arr.length/2){
            return candidate;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {2,1, 1, 2, 1, 3, 5, 1,1};
        System.out.println(majorityElement(arr));
    }
}
