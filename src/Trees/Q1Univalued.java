package Trees;

import com.sun.source.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class Q1Univalued {
    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(1);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(1);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(2);


        System.out.println(isUnivalued(root));
        System.out.println(isunival(root));
    }

    // Using BFS

    public static boolean isUnivalued(TreeNode root){

        if(root == null) return true;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int val = root.data;
        while (!q.isEmpty()){
            TreeNode curr = q.poll();
            if(curr.data != val) return false;
            if(curr.left != null){
                q.add(curr.left);
            }
            if(curr.right!=null){
                q.add(curr.right);
            }

        }

        return true;

    }

    // Using DFS


    public static boolean isunival(TreeNode root){
        if(root==null) return false;


        int data = root.data;

        return preOrder(root,data);

    }


    public static boolean preOrder(TreeNode root,int data){
        if(root==null) return true;

        if(root.data!=data){
            return false;
        }

        boolean left =  preOrder(root.left,data);
        boolean right = preOrder(root.right,data);

        return left && right;
    }


}
