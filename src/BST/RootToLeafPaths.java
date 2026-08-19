package BST;

import Trees.TreeNode;

import java.util.ArrayList;

public class RootToLeafPaths {
    public static void main(String[] args) {

    }
    public static ArrayList<ArrayList<Integer>> AllPaths(TreeNode root){

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();

        findPaths(root,ans,res);
        return res;
    }

    public static void findPaths(TreeNode root, ArrayList<Integer> ans, ArrayList<ArrayList<Integer>> res){

        if(root==null){
            return;
        }


        ans.add(root.data);

        if(root.left==null && root.right==null){
            res.add(new ArrayList<>(ans));
        }else {
            findPaths(root.left, ans, res);
            findPaths(root.right, ans, res);
        }
        ans.remove(ans.size()-1);
    }
}
