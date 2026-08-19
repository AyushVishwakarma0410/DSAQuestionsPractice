package BST;

import Trees.TreeNode;

public class Search {
    public static void main(String[] args) {

    }
    public static boolean isPresent(TreeNode root,int val){

        if(root==null ){
            return false;
        }

        if(root.data==val) return true;

        if(val < root.data){
            return isPresent(root.left,val);
        }
        else {
            return isPresent(root.right,val);
        }
    }
}
