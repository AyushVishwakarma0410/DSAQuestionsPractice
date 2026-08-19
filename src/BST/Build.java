package BST;

import Trees.TreeNode;

public class Build {
    public static void main(String[] args) {
        int [] values = {5,1,3,4,2,7};
        TreeNode root = null;
        for (int num : values){
            root = insert(root,num);
        }
        inorder(root);
    }
    public static void inorder(TreeNode root){


        if(root==null){
            return;
        }

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static TreeNode insert(TreeNode root,int val){

        if(root == null){
            root = new TreeNode(val);
            return root;
        }

        if(root.data > val){
           root.left =  insert(root.left, val);
        }else {
            root.right = insert(root.right, val);
        }
        return root;
    }
}
