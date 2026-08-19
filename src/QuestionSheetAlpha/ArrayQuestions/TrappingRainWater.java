package QuestionSheetAlpha.ArrayQuestions;

public class TrappingRainWater {



    // trapping rain water, basically gurrantee pr chalta hai,
    public static int trap(int [] height){
        int rightMAX = 0;
        int leftMAX = 0;
        int left = 0;
        int right = height.length-1;
        int totalWater = 0;


        while (left < right){

            // this condition prepares a gurantee, ki bhai right side mai ek badi boundary hai.. to hum abhi pani store kr sakte hain
            // is liye pani ki calculation kr li
            if(height[left] <= height[right]){
                leftMAX = Math.max(leftMAX,height[left]);
                int water = leftMAX - height[left];
                totalWater += water;
                left++;
            }
            // this condition prepares a gurantee ki bhai left side mai ek boundary hai.. too hum abhi pani store kr sakte hain
            // is liye pani store krne ki calculation kri gyi
            else {
                rightMAX = Math.max(rightMAX,height[right]);
                int water = rightMAX - height[right];
                totalWater += water;
                right--;
            }
        }

        return totalWater;

    }


    public static void main(String[] args) {
        int [] arr ={4,2,0,3,2,5};
        System.out.println( trap(arr));;

    }
}
