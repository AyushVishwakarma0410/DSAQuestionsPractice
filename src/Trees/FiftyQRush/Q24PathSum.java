package Trees.FiftyQRush;

import Trees.TreeNode;

public class Q24PathSum {
    public static void main(String[] args) {

    }


    // sum == k and end should be at the leaf node

    public static boolean isPathSum(TreeNode root, int k){

        if(root==null ){
            return false;
        }

        // havent read question properly but that wasnt my mistake.
//        if(k==0){
//            return true;
//        }

        if(root.left == null && root.right == null && root.data == k){
            return true;
        }

        k -= root.data;

        boolean left = isPathSum(root.left,k);
        boolean right = isPathSum(root.right,k);

        return left || right;
    }
}
