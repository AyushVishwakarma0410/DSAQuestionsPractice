package Trees;

public class Q3DeleteLeafNodesAsX {
    public static void main(String[] args) {

    }

    // correct idea wrong implementation done by me
    // i corrected it
    // This one is correct
    public static TreeNode deleteLeaf(TreeNode root, int val){

        if(root==null){
            return null;
        }



        root.left =  deleteLeaf(root.left,val);
        root.right = deleteLeaf(root.right,val);


        if(root.left==null && root.right==null && root.data==val){
            return null;
        }

        return root;
    }

}
