package Trees.FiftyQRush;

import Trees.TreeNode;

public class Q7InOrderTraversal {
    public static void main(String[] args) {

    }
    public static void inOrder(TreeNode root){

        if(root == null){
            return;
        }

        System.out.println(root.data);
        inOrder(root.left);
        inOrder(root.right);

    }
}
