//package Graphs;
//
//public class LC111 {
//
//    static class TreeNode {
//        int val;
//        TreeNode left;
//        TreeNode right;
//        TreeNode(int val) {
//            this.val = val;
//        }
//
//        TreeNode(int val, TreeNode left, TreeNode right) {
//
//            this.val = val;
//            this.left = left;
//            this.right = right;
//        }
//    }
//    public static void main(String[] args) {
//
//        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(3);
//        root.left.left = new TreeNode(4);
//        root.left.right = new TreeNode(5);
//
//
//        System.out.println(minDepth(root));
////    }
////    public static int minDepth(TreeNode root) {
////        if(root == null){
////            return 0;
////        }
////
////        int left = minDepth(root.left)+1;
////        int right = minDepth(root.right)+1;
////
////        return Math.min(left,right);
////    }
//}
