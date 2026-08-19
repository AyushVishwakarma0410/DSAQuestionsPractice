package Trees.FiftyQRush;

import Trees.TreeNode;

public class Q12CheckIdentical {
    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        boolean ans =  checkIdentical(root,root);

        System.out.println(ans);
    }

    public static boolean checkIdentical(TreeNode root1, TreeNode root2){

        if(root1 == null && root2 == null){
            return true;
        }

        if(root1 == null || root2 == null){
            return false;
        }

        if(root1.data != root2.data){
            return false;
        }


        if(checkIdentical(root1.left,root1.left) || checkIdentical(root1.right , root2.right)){
            return false;
        }

        return true;

    }

}
