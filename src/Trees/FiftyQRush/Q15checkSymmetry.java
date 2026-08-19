package Trees.FiftyQRush;

import Trees.TreeNode;

public class Q15checkSymmetry {
    public static void main(String[] args) {


    }


    // NOT SELF DONE

    public static boolean isSymmetric(TreeNode root){

        if(root==null){
             return true;
        }

        return isMirror(root.left, root.right);
    }

    public static boolean isMirror(TreeNode left,TreeNode right){

        if(left==null && right==null){
            return true;
        }

        if(left == null || right == null){
            return false;
        }

        return left.data == right.data && isMirror(left.left,right.right) && isMirror(left.right,right.left);
    }

}
