package Trees.FiftyQRush;

import Trees.TreeNode;

public class Q19RightViewOfBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        maxLevel = 0;
        rightView(root,1);
    }

        static int maxLevel = 0;
    public static void rightView(TreeNode root,int level){

        if(root==null){
            return;
        }

        if(level > maxLevel) {
            System.out.println(root.data);
            maxLevel = level;
        }
        rightView(root.right,level+1);
        rightView(root.left,level+1);

    }
}
