package BST.Part2;

import Trees.TreeNode;

import java.util.ArrayList;

public class ConvertBSTtoBalancedBST {
    public static void main(String[] args) {

    }

    //1. convert BST to arraylist
    //2. convert Array to Balanced BST

    public static TreeNode convert(TreeNode root){

        ArrayList<Integer> list = new ArrayList<>();
         inorder(root,list);


        return makeTree(list,0,list.size()-1);

    }

    public static TreeNode makeTree(ArrayList<Integer> list, int start, int end){

        if(start>end){
            return null;
        }

        int mid = start + (end - start) / 2;


        TreeNode root = new TreeNode(list.get(mid));

        root.left = makeTree(list,start,mid-1);
        root.right = makeTree(list,mid+1,end);

        return root;
    }

    public static void  inorder(TreeNode root, ArrayList<Integer> list){

        if(root==null){
            return;
        }
        inorder(root.left,list);
        list.add(root.data);
        inorder(root.right,list);


    }
}

