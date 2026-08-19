package BST.Part2;

import Trees.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class LargestBSTInABinaryTree {
    public static void main(String[] args) {


    }


//   check if a BST is present or Not
//    public static boolean isValidBST(TreeNode root,TreeNode min, TreeNode max){
//        if (root==null){
//            return true;
//        }
//
//        if(min!=null && root.data<= min.data){
//            return false;
//        }
//
//        if(max!=null && root.data >= max.data){
//            return false;
//        }
//
//        return isValidBST(root.left,min,root) && isValidBST(root.right,root,max);
//
//    }
//
//
//
//    // first attempt
//
//    public static TreeNode BST(TreeNode root){
//
//        Queue<TreeNode> q = new LinkedList<>();
//        q.add(root);
//        TreeNode max = new TreeNode(Integer.MAX_VALUE);
//        TreeNode min = new TreeNode(Integer.MIN_VALUE);
//        while (!q.isEmpty()){
//
//            TreeNode curr = q.poll();
//
//            if(isValidBST(curr,min,max)){
//                return curr;
//            }
//
//            if(curr.left!=null){
//                q.add(curr.left);
//            }
//            if(curr.right!=null){
//                q.add(curr.right);
//            }
//
//        }
//
//        return null;
//    }




// Q. Find a BST in binary tree such that it holds largest

    static class Info{
        boolean isBST;
        int size;
        int min;
        int max;
        Info(boolean isBST, int size, int min, int max){
            this.isBST = isBST;
            this.size = size;
            this.max = max;
            this.min = min;
        }
    }


    public static int maxBST = 0;

    public static Info largestBST(TreeNode root){
        if(root==null){
            return new Info(true,0,Integer.MAX_VALUE,Integer.MIN_VALUE);
        }
        Info leftInfo = largestBST(root.left);
        Info rightInfo = largestBST(root.right);

        int size = leftInfo.size + rightInfo.size + 1;
        int min = Math.min(root.data, Math.min(leftInfo.min, rightInfo.min));
        int max = Math.max(root.data, Math.max(leftInfo.max, rightInfo.max));

        if(root.data <= leftInfo.max || root.data >= rightInfo.min){
            return new Info(false,size,min,max);
        }
        if(leftInfo.isBST && rightInfo.isBST){
            maxBST = Math.max(maxBST,size);
            return new Info(true,size,min,max);
        }

        return new Info(false,size,min,max);

    }

}