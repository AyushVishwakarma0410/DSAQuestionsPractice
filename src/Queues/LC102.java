package Queues;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC102 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

// Left subtree
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

// Right subtree
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        levelOrder(root);

    }

    public static List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;

        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);
        while (!q.isEmpty()){

            List<Integer> LevelValues = new ArrayList<>();
            int size = q.size();

            for (int i = 0 ; i < size; i++){

                TreeNode node = q.poll();
                LevelValues.add(node.val);

                if(node.left!=null) q.add(node.left);
                if(node.right!=null) q.add(node.right);
            }

            result.add(LevelValues);

        }

        return result;
    }


}
