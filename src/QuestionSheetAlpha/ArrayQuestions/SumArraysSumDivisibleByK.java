

package QuestionSheetAlpha.ArrayQuestions;
import java.util.HashMap;
public class SumArraysSumDivisibleByK {

        public static int subarraysDivByK(int[] nums, int k) {




            // REDO needed
            HashMap<Integer,Integer> prefixFreq = new HashMap<>();
            prefixFreq.put(0,1);
            int count = 0;
            int currentSum =0;

            for( int num : nums){
                currentSum+=num;

                // Calculate the remainder, ensuring it is non-negative
                int remainder = currentSum % k;
                if (remainder < 0) {
                    remainder += k;
                }

                // OR more concisely:
                // int remainder = ((currentSum % k) + k) % k;

                if(prefixFreq.containsKey(remainder)){
                    count+=prefixFreq.get(remainder);
                }

                prefixFreq.put(remainder, prefixFreq.getOrDefault(remainder, 0) + 1);

            }

            return count;



        }


    public static void main(String[] args) {
        int [] arr ={4,5,0,-2,-3,1};
        System.out.println(subarraysDivByK(arr, 5));
    }
}
