//package Trees;
//
//public class Q5MaximumPathSum {
//    public static void main(String[] args) {
//
//    }
//
//    static int max = 0;
////
////    public static int maxPath(TreeNode root){
////
////        if(root == null){
////            return 0;
////        }
////
////
////        int leftChild = maxPath(root.left);
////        int rightChild = maxPath(root.right);
////
////        int data = root.data;
////
////        int newLeft = root.left!=null? root.left.data : 0;
////        int newRight = root.right!=null? root.right.data:0;
////
////        root.data = newLeft + newRight + leftChild + rightChild;
////        max = Math.max(root.data+data,max);
////
////        return data;
////    }
//
//    static int max = Integer.MIN_VALUE;
//
//    public int maxPathSum(TreeNode root) {
//        dfs(root);
//        return max;
//    }
//
//    public int dfs(TreeNode node) {
//
//        if(node == null) return 0;
//
//        int left = Math.max(0, dfs(node.left));
//        int right = Math.max(0, dfs(node.right));
//
//        max = Math.max(max, left + right + node.data);
//
//        return node.data + Math.max(left, right);
//    }
//}
