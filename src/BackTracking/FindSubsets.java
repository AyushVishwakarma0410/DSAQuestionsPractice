package BackTracking;

public class FindSubsets {

    public static void findSubsets(String str, String ans, int idx){
        // base case
        if(idx==str.length()){

            // incase string is empty
            if(ans.length()==0) System.out.println("null");
            // for the rest of the cases
            else System.out.println(ans);
            return;
        }

        // recursion

        //yes choice
        findSubsets(str,ans+str.charAt(idx),idx+1);


        //no choice
        findSubsets(str,ans,idx+1);

    }


    public static void main(String[] args) {
        String ans = "";
        findSubsets("abc",ans,0);
    }
}
