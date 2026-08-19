package Trees.FiftyQRush;

import Trees.TreeNode;

import java.util.ArrayList;

public class Q23RootToLeafPaths {
    public static void main(String[] args) {

    }

    public static ArrayList<ArrayList<Integer>> find(TreeNode root){

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        paths(root,new ArrayList<Integer>(),res);

        return res;
    }
    public static void paths(TreeNode root,ArrayList<Integer> ans,ArrayList<ArrayList<Integer>> res){


        if(root==null){
            return;
        }
        ans.add(root.data);


        if(root.left==null && root.right==null){
            res.add(new ArrayList<>(ans));
//            return;
        }
        else {

            paths(root.left,ans,res);
            paths(root.right,ans,res);

        }

        ans.remove(ans.size()-1);

//      correct idea loose implementation


//        ans.add(root.data);
//
//        paths(root.left,ans,res);
//        ans.remove(ans.size()-1);
//        paths(root.right,ans,res);
//        ans.remove(ans.size()-1);




    }
}
