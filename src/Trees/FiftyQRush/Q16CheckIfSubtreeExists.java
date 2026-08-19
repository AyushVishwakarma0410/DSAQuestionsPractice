package Trees.FiftyQRush;

import Trees.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Q16CheckIfSubtreeExists {
    public static void main(String[] args) {

    }
    public static boolean existsSubtree(TreeNode root,TreeNode subTree){

        if(subTree == null){
            return true;
        }

        if(root == null){
            return false;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()){
            TreeNode curr = q.poll();

            if(isIdentical(curr,subTree)){
                return true;
            }


            if(curr.left!=null){
                q.add(curr.left);
            }
            if(curr.right!=null){
                q.add(curr.right);
            }

        }
        return false;

    }

    public static boolean isIdentical(TreeNode root,TreeNode subTree){

        if(root == null && subTree == null){
            return true;
        }
        if(root==null || subTree == null){
            return false;
        }


        boolean left = isIdentical(root.left,subTree.left);
        boolean right = isIdentical(root.right,subTree.right);

        return left && right && root.data == subTree.data;

    }
}
