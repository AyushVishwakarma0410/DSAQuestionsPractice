package Trees.FiftyQRush;

import Trees.TreeNode;

import java.util.Stack;

public class Q22BoundaryTraversal {
    public static void main(String[] args) {

    }

    public static void boundaryTraversal(TreeNode root){

        if(root==null) return;

        System.out.print(root.data + " ");

        leftBoundary(root.left);

        leafNodes(root.left);
        leafNodes(root.right);

        rightBoundary(root.right);
    }
    public static void leftBoundary(TreeNode root){

        if(root==null){
            return;
        }

        if(!(root.left==null && root.right==null)){
            System.out.print(root.data + " ");
        }
        if(root.left!=null){
            leftBoundary(root.left);
        }
        else {
            leftBoundary(root.right);
        }

    }

    public static void leafNodes(TreeNode root){

        if(root==null){
            return;
        }

        if(root.left==null && root.right==null){
            System.out.print(root.data + " ");
        }
            leafNodes(root.left);

            leafNodes(root.right);

    }


    public static void rightBoundary(TreeNode root){
        if(root==null){
            return;
        }


        if(root.right!=null){
            rightBoundary(root.right);
        }
        else {
            rightBoundary(root.left);
        }

        if(!(root.left==null && root.right == null))
            System.out.print(root.data + " ");


    }
}
