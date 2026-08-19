package Trees.FiftyQRush;

import Trees.TreeNode;

public class Q6PreOrderTraversal {
    public static void main(String[] args) {

    }
    public static void preOrder(TreeNode root){

        if(root == null){
            return;
        }
        preOrder(root.left);
        System.out.println(root.data);
        preOrder(root.right);

    }
}
