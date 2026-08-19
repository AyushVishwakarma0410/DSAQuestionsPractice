package Trees.FiftyQRush;

import Trees.TreeNode;
import com.sun.source.tree.Tree;

public class Q1HeightOfABinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(1);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(1);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(2);

    }

    public static int height(TreeNode root){


        // if we are at null then return 0
        if(root==null){
            return 0;
        }
        // get from left subtree
        int left = height(root.left);
        // from right subtree
        int right = height(root.right);

        // return max dept
        if(left< right){
            return right+1;
        }
        else {
            return left+1;
        }

    }

    

}
