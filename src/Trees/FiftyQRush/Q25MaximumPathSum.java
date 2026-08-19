package Trees.FiftyQRush;

import Trees.TreeNode;

import java.util.ArrayList;

public class Q25MaximumPathSum {
    public static void main(String[] args) {

    }


    int maxSum = Integer.MIN_VALUE;
    public  int maxPathSum(TreeNode root){

            if(root == null){
                return 0;

            }


            int left = Math.max(0,maxPathSum(root.left));
            int right = Math.max(0,maxPathSum(root.right));

            int current = left + right + root.data;

            maxSum = Math.max(maxSum,current);

            return root.data + Math.max(left,right) ;
    }
}
