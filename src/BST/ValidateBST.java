package BST;

import Trees.TreeNode;

public class ValidateBST {
    public static void main(String[] args) {

    }
    // Approach 1
    // As we know that inorder traversal of BST is always sorted therefore we can do a inorder Traversal

    // Approach 2
    // min max range

    public static boolean isValidBST(TreeNode root,TreeNode min, TreeNode max){
        if (root==null){
            return true;
        }

        if(min!=null && root.data<= min.data){
            return false;
        }

        if(max!=null && root.data >= max.data){
            return false;
        }

        return isValidBST(root.left,min,root) && isValidBST(root.right,root,max);

    }


}
