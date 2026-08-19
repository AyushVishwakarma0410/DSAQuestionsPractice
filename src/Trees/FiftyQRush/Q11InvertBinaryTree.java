package Trees.FiftyQRush;

import Trees.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Q11InvertBinaryTree {


    // self done

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        lvlOrder(root);
        invert(root);
        lvlOrder(root);

    }

    public static void lvlOrder(TreeNode root){

        if(root == null){
            return;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()){
            int size = q.size();

            for (int i = 0; i < size; i++) {
                TreeNode curr  = q.poll();
                System.out.print(curr.data + " ");
                if(curr.left != null){
                    q.add(curr.left);
                }
                if(curr.right!=null){
                    q.add(curr.right);
                }

            }

            System.out.println();

        }


    }

    public static TreeNode invert(TreeNode root){

        if(root == null){
            return null;
        }



        TreeNode left = invert(root.left);
        TreeNode right = invert(root.right);

        root.left = right;
        root.right = left;

        return root;
    }
}
