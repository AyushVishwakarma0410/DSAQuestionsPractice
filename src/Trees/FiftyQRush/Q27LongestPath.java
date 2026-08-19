package Trees.FiftyQRush;

import Trees.TreeNode;

import java.util.ArrayList;

public class Q27LongestPath {
    public static void main(String[] args) {
            TreeNode root = new TreeNode(1);
//
//            root.left = new TreeNode(2);
//            root.right = new TreeNode(3);
//
//            root.left.left = new TreeNode(4);
//            root.left.right = new TreeNode(5);
//
//            root.right.left = new TreeNode(6);
//            root.right.right = new TreeNode(7);

            ArrayList<Integer> ans =  maxPath(root);

        System.out.println(ans);
    }


    // Self done

    public static ArrayList<Integer> maxPath(TreeNode root){

        if(root==null){
            return new ArrayList<>();
        }


        ArrayList<Integer> list = new ArrayList<>();
        list.add(root.data);

        if(root.left == null && root.right==null) {
            return new ArrayList<>(list);
        }
        ArrayList<Integer> leftList = maxPath( root.left);
        ArrayList<Integer> rightList = maxPath( root.right);


        if(leftList.size() > rightList.size()){
             list.addAll(leftList) ;
        }
        else {
            list.addAll(rightList);
        }

        return list;

    }

        // OPTIMIZED
    static ArrayList<Integer> longest = new ArrayList<>();

    public static ArrayList<Integer> longestPath(TreeNode root){
        dfs(root, new ArrayList<>());
        return longest;
    }

    public static void dfs(TreeNode node, ArrayList<Integer> current){

        if(node == null) return;

        current.add(node.data);

        if(node.left == null && node.right == null){
            if(current.size() > longest.size()){
                longest = new ArrayList<>(current);
            }
        }

        dfs(node.left, current);
        dfs(node.right, current);

        current.remove(current.size()-1); // backtrack
    }

}
