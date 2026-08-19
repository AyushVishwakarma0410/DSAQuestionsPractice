package Trees.FiftyQRush;

import Trees.TreeNode;

import java.util.ArrayList;

public class Q24BPathSumTwo {

    // mehhh .....

//     ( revision doing ) I have no freaking idea why wasnt able to solve this question without AI damn,.
    public static void main(String[] args) {

    }
    public static ArrayList<ArrayList<Integer>> PathSum2(TreeNode root){

        if(root == null){
            return new ArrayList<>();
        }

        ArrayList<Integer> ans = new ArrayList<>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        find(root, 5,ans,res);

        return res;

    }
    public static void find(TreeNode root, int k,ArrayList<Integer> ans,ArrayList<ArrayList<Integer>> res){


        if(root == null){
            return;
        }
        ans.add(root.data);

        // in the previous type(Q24PathSum) of this question series, we put k-= root.data after the if condition
        // but here we are putting it first, well we can actually do it exactly as it was before,
        // but we have to change the if conditions, as here we have k == 0 but in the previous one
        // we had  k == root.data

        k -= root.data;

        if(root.right == null && root.left == null && k == 0){
            res.add(new ArrayList<>(ans));
        }



        find(root.left, k, ans,res);
        find(root.right, k, ans,res);

        ans.remove(ans.size()-1);
    }
}
