package QuestionSheetAlpha.ArrayQuestions;

public class ContainerWithMostWater {


    public static int maxArea(int [] height){
        int left = 0;
        int right = height.length-1;
        int max = 0;
        int area = 0;
        while (left < right){
            area = Math.min(height[left], height[right]) * (right-left);
            if(max < area){
                max = area;
            }

            if(height[left] < height[right]){
                left++;
            }
            else {
                right--;
            }

        }
        return max;
    }







    public static void main(String[] args) {

    }
}
