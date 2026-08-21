package DP.Memorization;

import java.util.HashMap;

public class LC337TreeDPQuestion {
    public static void main(String[] args) {

        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(2);
        treeNode.left.right = new TreeNode(3);
        treeNode.right = new TreeNode(3);
        treeNode.right.right = new TreeNode(1);

        System.out.println(rob(treeNode));
    }


    // took help -> brute force
    // I got confused in trees.
    // I got the idea that we have to sum current with grandchildren but got confused in how.

    public static int rob(TreeNode root) {

        if(root==null){
            return 0;
        }

        int currentRob = root.val;

        if(root.left!=null){
            currentRob += rob(root.left.left) + rob(root.left.right);
        }
        if(root.right!=null){
            currentRob += rob(root.right.left) + rob(root.right.right);
        }


        int notRob = rob(root.left) + rob(root.right);


        return Math.max(currentRob,notRob);


    }



    // its easy but encountering this first time is tricky, nvm I was lazy
    static HashMap<TreeNode, Integer> map = new HashMap<>();
    public static int rob2(TreeNode root) {

        if(root==null){
            return 0;
        }
        if (map.containsKey(root)) {

            return map.get(root);

        }


        int currentRob = root.val;

        if(root.left!=null){
            currentRob += rob(root.left.left) + rob(root.left.right);
        }
        if(root.right!=null){
            currentRob += rob(root.right.left) + rob(root.right.right);
        }


        int notRob = rob(root.left) + rob(root.right);
        int res = Math.max(currentRob,notRob);
        map.put(root,res);
        return Math.max(currentRob,notRob);


    }


    // an another way by gpt -> special brute force


    class Solution {
        public int rob(TreeNode root) {
            int[] result = robSub(root);
            return Math.max(result[0], result[1]);
        }

        // Returns an array of size 2:
        // index 0: max money if we rob this node
        // index 1: max money if we skip this node
        private int[] robSub(TreeNode root) {
            if (root == null) {
                return new int[]{0, 0};
            }

            int[] left = robSub(root.left);
            int[] right = robSub(root.right);

            // If we rob this node, we cannot rob its immediate children
            int robCurrent = root.val + left[1] + right[1];

            // If we skip this node, we can choose to either rob or skip its children
            int skipCurrent = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

            return new int[]{robCurrent, skipCurrent};
        }
    }


}
