package DP.Memorization;

public class LC72 {




    // Understood something new WP.

    // DP
    public static int minDistance(String word1, String word2) {

        int [][] DP = new int[word1.length()+1][word2.length()+1];

        return solve(word1,word2,0,0,DP);
    }


    public static int solve(String word1, String word2, int i, int j, int [][] dp){





        // suppose given
        // abc and xyz
        // if we keep on deleting we will reach end of word1 (i+1 continuously), but j will have 0.
        // therefore we will have 3 - 0 i.e. 3 words are left to add.
        if(i == word1.length()){
            return word2.length() - j;
        }




        // suppose we keep on inserting values
        // j will keep on increasing, but i will be remained at 0;
        // suppose abc and xyz then if we keep on inserting then j+1 will
        if(j == word2.length()){
            return word1.length()-i;
        }

        if(dp[i][j]!=-1){
            return dp[i][j];
        }


        // if both word are same return the next solve call
        if(word1.charAt(i)==word2.charAt(j)){
            return solve(word1,word2,i+1,j+1,dp);
        }



        // increasing the j value because we are prefixing the value
        int insert = solve(word1,word2, i,j+1,dp);

        // deleting the value will result in increase of word1 i idx
        int delete = solve(word1,word2,i+1,j,dp);

        // replacing the value will result in both value increase
        int replace = solve(word1,word2,i+1,j+1,dp);



        return 1 + Math.min(insert,Math.min(delete,replace));
    }





//    public static int solve(String word1, String word2, int i, int j){
//
//
//        // suppose given
//        // abc and xyz
//        // if we keep on deleting we will reach end of word1 (i+1 continuously), but j will have 0.
//        // therefore we will have 3 - 0 i.e. 3 words are left to add.
//        if(i == word1.length()){
//            return word2.length() - j;
//        }
//
//
//        // suppose we keep on inserting values
//        // j will keep on increasing, but i will be remained at 0;
//        // suppose abc and xyz then if we keep on inserting then j+1 will
//        if(j == word2.length()){
//            return word1.length()-i;
//        }
//
//
//        // if both word are same return the next solve call
//        if(word1.charAt(i)==word2.charAt(j)){
//            return solve(word1,word2,i+1,j+1);
//        }
//
//
//
//        // increasing the j value because we are prefixing the value
//        int insert = solve(word1,word2, i,j+1);
//
//        // deleting the value will result in increase of word1 i idx
//        int delete = solve(word1,word2,i+1,j);
//
//        // replacing the value will result in both value increase
//        int replace = solve(word1,word2,i+1,j+1);
//
//
//
//        return 1 + Math.min(insert,Math.min(delete,replace));
//    }

}
