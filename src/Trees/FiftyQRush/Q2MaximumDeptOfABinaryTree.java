package Trees.FiftyQRush;

import Trees.TreeNode;

public class Q2MaximumDeptOfABinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(1);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(1);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(2);
    }

    // Same as of height

    public static int maxDept(TreeNode root){
        if(root==null){
            return 0;
        }

        int left = maxDept(root.left);
        int right = maxDept(root.right);

        if(left < right){
            return right+1;
        }else {
            return left+1;
        }


    }


}
