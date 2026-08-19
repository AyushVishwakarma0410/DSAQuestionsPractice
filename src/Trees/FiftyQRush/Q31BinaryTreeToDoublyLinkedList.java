package Trees.FiftyQRush;

import Trees.TreeNode;


// mehhhh....
// i am so lazy for this
public class Q31BinaryTreeToDoublyLinkedList {
    public static void main(String[] args) {

    }
        static TreeNode head ;
        static TreeNode prev;
    public static TreeNode convert(TreeNode root){
        if(root == null) return null;

        convert(root.left);
        if(prev==null){
            head= root;
        }else {
            prev.right = root;
            root.left = prev;
        }

        prev = root;
        convert(root.right);

        return head;

    }

}
