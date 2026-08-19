package Trees.FiftyQRush;

import Trees.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Q37 {


    public static TreeNode buildTree(Integer[] arr) {

        if(arr.length == 0 || arr[0] == null) {
            return null;
        }

        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;


        // BFS
        while(!queue.isEmpty() && i < arr.length) {

            TreeNode current = queue.poll();

            // left child
            if(arr[i] != null) {
                current.left = new TreeNode(arr[i]);
                queue.offer(current.left);
            }
            i++;

            if(i >= arr.length) break;

            // right child
            if(arr[i] != null) {
                current.right = new TreeNode(arr[i]);
                queue.offer(current.right);
            }
            i++;
        }

        return root;
    }
}
