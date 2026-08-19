package BST;

import Trees.TreeNode;

public class PrintInRange {

    public static void main(String[] args) {
            int [] values = {8,5,3,1,4,6,10,11,14};

            TreeNode root = null;

            for (int num : values){
                root = insert(root,num);
            }

            printInRange(root,5,11);
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
    public static void printInRange(TreeNode root,int k1, int k2){


        if (root==null){
            return;
        }

        if(root.data >= k1 && root.data <=k2){
            printInRange(root.left,k1,k2);
            System.out.print(root.data + " ");
            printInRange(root.right,k1,k2);
        }
        else if(root.data < k1){

            printInRange(root.right, k1, k2);
        }
        else {

            printInRange(root.left,k1,k2);
        }
    }
}
