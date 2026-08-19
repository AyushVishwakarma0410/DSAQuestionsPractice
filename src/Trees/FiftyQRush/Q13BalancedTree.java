package Trees.FiftyQRush;

import Trees.TreeNode;

public class Q13BalancedTree {
    public static void main(String[] args) {

    }


    // brute ( self done ) o(n2)
    public static int Height(TreeNode root){

        if(root==null){
            return 0;
        }

        int left = Height(root.left);
        int right = Height(root.right);

        return Math.max(left,right)+1;

    }

    public static boolean isBalanced(TreeNode root){

        if(root==null) return true;
        int leftHeight = Height(root.left);
        int rightHeight = Height(root.right);

        if(Math.abs(leftHeight-rightHeight)<=1){
             return isBalanced(root.right) && isBalanced(root.left);

        }else {
            return false;
        }

    }


    // Optimized  O(n)

    public static int checkHeight(TreeNode root){

        if(root==null) return 0;

        int left = checkHeight(root.left);

        if(left==-1){
            return -1;
        }

        int right = checkHeight(root.right);
        if(right==-1){
            return -1;
        }

        if(Math.abs(right-left)>1){
            return -1;
        }

        return Math.max(left,right)+1;
    }
}
