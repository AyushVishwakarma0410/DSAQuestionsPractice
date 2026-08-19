package BackTracking;

public class FindPermutations {


    // Enumeration


    public static void findPermutation(String str, String ans){
        // basecase
        if(str.length()==0){
            System.out.println(ans);
            return;
        }


        //recursion
        for(int i = 0; i < str.length();i++){
            char curr = str.charAt(i);

            // removing the chosen element
            // ex abc -> substring(0,0) = "" + substring(0+1) = bc -> bc
            String newStr = str.substring(0,i)+str.substring(i+1);

            // call for next with newStr, as we cannot send str directly because it will reduce the iteration length
            findPermutation(newStr,ans+curr);

        }
    }

    // TC - O(n*n!)
    public static void main(String[] args) {

        String str = "abc";
        findPermutation(str,"");

    }
}
