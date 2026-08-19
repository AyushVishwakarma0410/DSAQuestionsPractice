package BST;

import Trees.TreeNode;
import com.sun.source.tree.Tree;

public class DeleteNode {
    public static void main(String[] args) {

    }
    // Total 3 Cases
    // 1. No Child - put target null
    // 2. One Child - attack next left or next right whichever present
    // 3. Two Children - leftmost child in right subtree

    public static TreeNode deleteNode(TreeNode root,int k){

        if(root.data > k){
            root.left = deleteNode(root.left,k);
        }
        else if(root.data < k){
            root.right = deleteNode(root.right,k);
        }
        else {

            // case 1 -> leaf
            if(root.left==null && root.right==null){
                return null;
            }

            // case 2 -> single child
            if(root.left==null){
                return root.right;
            }else if (root.right==null){
                return root.left;
            }

            // case 3 -> both children present
            TreeNode succ = findInorderSuccessor(root.right);
                root.data = succ.data;
                root.right = deleteNode(root.right,succ.data);

        }
        return root;


    }

    public static TreeNode findInorderSuccessor(TreeNode root){
        while (root.left!=null){
            root = root.left;
        }
        return root;
    }
}
