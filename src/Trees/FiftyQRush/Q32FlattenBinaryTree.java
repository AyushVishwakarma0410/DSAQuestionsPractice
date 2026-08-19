package Trees.FiftyQRush;

import Trees.TreeNode;

public class Q32FlattenBinaryTree {
    public static void main(String[] args) {

    }




    // was really close in this question, got the exact idea, but lost in implementation completely
    // 50 % selfdone ( algorithmic wise )



    /*

    At each node:

Flatten the left subtree → becomes a linked list

Flatten the right subtree → becomes a linked list

Insert the left list between the root and the right list

So the transformation is:

      root
     /    \
   left   right

becomes

root → left-list → right-list

Important detail:

root is always the first node

So we do not place root between two lists.

Instead we place the left list after root.
    */
    public static void convert(TreeNode root) {


        if (root == null) {
            return;
        }

        convert(root.left);
        convert(root.right);

        TreeNode left = root.left;
        TreeNode right = root.right;


        root.left = null;
        root.right = left;


        TreeNode curr = root;
        while (curr.right != null) {
            curr = curr.right;
        }


        curr.right = right;
    }

}
