package Trees.FiftyQRush;

import Trees.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Q3CountNodesInaBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(1);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(1);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(2);
        System.out.println(countNodes(root));
    }



    // Used BFS
    // Also remember we count nodes by visiting them
    // this itself is a way of how to visit every node
    public static int countNodes(TreeNode root){


        int count = 0;
        if(root==null) return count;
        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);


        while (!q.isEmpty()){

            TreeNode curr = q.poll();
            count++;
            if(curr.left != null){
                q.add(curr.left);
            }
            if(curr.right!=null){
                q.add(curr.right);
            }

        }

        return count;

    }


}
