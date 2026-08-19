package Trees.FiftyQRush;

import LinkedLists.Node;
import Trees.TreeNode;
import com.sun.source.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class Q4SumOfNodesInBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(1);
//        root.right = new TreeNode(2);
//        root.left.left = new TreeNode(1);
//        root.left.right = new TreeNode(1);
//        root.right.left = new TreeNode(1);
//        root.right.right = new TreeNode(2);

        System.out.println(SumOfNodes(root));
        System.out.println(sumOfNodesDFS(root));

    }


    public static int SumOfNodes(TreeNode root){

        if(root==null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int sum  = 0;
        while (!q.isEmpty()){

            TreeNode curr = q.poll();
            sum += curr.data;

            if(curr.left!=null){
                q.add(curr.left);
            }
            if(curr.right!=null){
                q.add(curr.right);
            }

        }

        return sum;



    }

    // self done

    public static int sumOfNodesDFS(TreeNode root){

        if(root == null){
            return 0;
        }

        int left = sumOfNodesDFS(root.left);
        int right = sumOfNodesDFS(root.right);

        return root.data + left + right;

    }
}
