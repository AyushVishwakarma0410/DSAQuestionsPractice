package DP.Tabulation;


// Tabulated version

// We are getting higher up in DP
import java.util.*;

public class LC337 {
    public static void main(String[] args) {

    }

    public static int rob(TreeNode treeNode){

        List<TreeNode> result = new ArrayList<>();

        if(treeNode==null){
            return 0;
        }

        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        stack1.push(treeNode);

        while (!stack1.isEmpty()){
            TreeNode curr = stack1.pop();
            stack2.push(curr);

            if(curr.right!=null){
                stack1.push(curr.right);
            }
            if(curr.left !=null){
                stack1.push(curr.left);
            }


        }


        while (!stack2.isEmpty()){
            result.add(stack2.pop());
        }




        Map<TreeNode, int[]> dp = new HashMap<>();

        for(TreeNode node : result){
            int[] left = dp.getOrDefault(node.left,new int[]{0,0});
            int[] right = dp.getOrDefault(node.right,new int[]{0,0});
            int leftRob    = left[0], leftSkip = left[1];
            int rightRob = right[0], rightSkip = right[1];

            // Option A: Rob current node -> must skip direct children
            int robNode = node.val + leftSkip + rightSkip;


            // Option B: Skip current node -> take max option for each child
            int skipNode = Math.max(leftRob, leftSkip) + Math.max(rightRob, rightSkip);

            dp.put(node, new int[]{robNode, skipNode});

        }

        int[] rootResult = dp.get(treeNode);
        return Math.max(rootResult[0], rootResult[1]);











        //
//        if(treeNode==null){
//            return 0;
//        }
//
//        HashMap<TreeNode, int[]> map = new HashMap<>();
//
//
//        // taken first element
//        // not taken first element
//        map.put(treeNode,new int[]{treeNode.val,0});
//












//        while (treeNode!=null) {
//            treeNode = treeNode.left;
//            if(treeNode.left==null && treeNode.right==null){
//                map.put(treeNode,new int[]{treeNode.val,0});
//            }
//            treeNode = treeNode.right;
//        }
//
//
//            while (treeNode!=null) {
//
//                int[] val = map.get(treeNode);
//                int takenVal = val[0];
//                int notTaken = val[1];
//
//                if (treeNode.left != null) {
//                    notTaken += treeNode.left.val;
//                }
//                if (treeNode.right != null) {
//                    notTaken += treeNode.right.val;
//                }
//
//                map.put(treeNode, new int[]{takenVal, notTaken});
//
//
//            }
//        }




    }
}
