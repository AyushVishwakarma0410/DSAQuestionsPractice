package BST.Part2;

import Trees.TreeNode;

public class SortedArrayToBST {
    public static void main(String[] args) {



        // minimum possible height should be present
    }

    public static TreeNode makeTree(int [] values, int left, int right){

        if(left>right){
            return null;
        }

        int mid = (left+right)/2;

        TreeNode root = new TreeNode(values[mid]);

        root.left = makeTree(values,left,mid-1);
        root.right = makeTree(values,mid+1,right);

        return root;

    }
}
