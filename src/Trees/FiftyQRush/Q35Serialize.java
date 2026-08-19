package Trees.FiftyQRush;

import Trees.TreeNode;

public class Q35Serialize {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);


        String s =  serializeAndDeserialize(root);

        System.out.println(s);
    }
    public static String serializeAndDeserialize(TreeNode root){

        StringBuilder sb = new StringBuilder();

        makeString(root,sb);
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();

    }


    // 60 percent close, went a little wrong
//    public static void makeString(TreeNode root, StringBuilder sb){
//
//
//
//        // base case
//        if(root==null){
//            return;
//        }
//        if(root.left==null && root.right==null){
//
//            sb.append(root.data);
//            sb.append(',');
//            sb.append("null");
//            sb.append(',');
//            sb.append("null");
//            return;
//        }
//+
//       // Preorder traversal
//
//       sb.append(root.data);
//
//           sb.append(",");
//
//       makeString(root.left,sb);
//       sb.append(',');
//       makeString(root.right,sb);
//    }



    /*

        1
       / \
      2   3
       \   \
        4   5


     */
    public static void makeString(TreeNode root, StringBuilder sb){

        if(root == null){
            sb.append("null,");
            return;
        }

        sb.append(root.data).append(",");

        makeString(root.left, sb);
        makeString(root.right, sb);

    }

}
