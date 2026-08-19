package BST;

import Trees.TreeNode;

public class Mirror {
    public static void main(String[] args) {

    }
    public static TreeNode convert(TreeNode root){

        if(root==null){
            return null;
        }

        TreeNode left = convert(root.left);
        TreeNode right = convert(root.right);

        root.right = left;
        root.left = right;

        return root;

    }
}
