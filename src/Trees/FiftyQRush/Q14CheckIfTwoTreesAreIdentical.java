package Trees.FiftyQRush;

import Trees.TreeNode;

public class Q14CheckIfTwoTreesAreIdentical {
    public static void main(String[] args) {

    }

    // 70 percent self done
    // missed some conditions
    public static boolean isIdentical(TreeNode root1,TreeNode root2){

        // base
        if(root1==null && root2==null) return true;
        if(root1==null || root2==null) return false;

        // next call
        boolean left = isIdentical(root1.left,root2.left);

        boolean right = isIdentical(root1.right,root2.right);




        return left && right &&  root1.data == root2.data;



    }
}
