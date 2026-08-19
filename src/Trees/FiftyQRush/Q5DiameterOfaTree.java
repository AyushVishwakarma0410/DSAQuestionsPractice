package Trees.FiftyQRush;

import Trees.TreeNode;

public class Q5DiameterOfaTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(1);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(1);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(2);

    }



    // self done but was in the course so nvm
    public static int height(TreeNode root){

        if(root == null){
            return 0;
        }

        int left = height(root.left);
        int right = height(root.right);

        if(left < right){
            return right+1;
        }
        else {
            return left+1;
        }

    }

    public static int Diameter(TreeNode root){
        if(root==null){
            return 0;
        }
        int left = height(root.left);
        int leftDiaM = Diameter(root.left);
        int right = height(root.right);
        int rightDiaM = Diameter(root.right);

        int DiaM = left+right+1;

        return Math.max(DiaM, Math.max(leftDiaM,rightDiaM));
    }

     static class NodeVal{
        int diam;
        int height;

        NodeVal(int diam,int height){
            this.diam = diam;
            this.height = height;
        }


    }


    public static NodeVal DiaMeterOptimized(TreeNode root){

        if(root==null){
            return new NodeVal(0,0);
        }

        NodeVal left = DiaMeterOptimized(root.left);
        NodeVal right = DiaMeterOptimized(root.right);

//        NodeVal current = new NodeVal(Math.max(left.diam+ right.diam+1,Math.max( left.diam,right.diam)),Math.max(left.height,right.height)+1 );

        int diameterThroughRoot = left.height + right.height + 1;
        int height = Math.max(left.height, right.height);
        int diameter = Math.max(diameterThroughRoot, Math.max(left.diam, right.diam));
        return new NodeVal(diameter,height);

    }



}
