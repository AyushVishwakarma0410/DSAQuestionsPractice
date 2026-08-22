package Trees.FiftyQRush;

import Trees.TreeNode;
import java.util.List;
import java.util.ArrayList;

public class Q8PostOrder {
    public static void main(String[] args) {

    }

    public static void postOrder(TreeNode root){


            if(root==null){
                return;
            }

            postOrder(root.left);
            postOrder(root.right);
            System.out.println(root.data);
        }


    }



