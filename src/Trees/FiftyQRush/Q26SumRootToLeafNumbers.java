package Trees.FiftyQRush;

import Trees.TreeNode;

import java.util.ArrayList;

public class Q26SumRootToLeafNumbers {




    // Can be optimized

    // 100 % self done LC 129 it is
    public static int sumNumbers(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        getNumbers(root,sb,ans);
        int sum = 0;
//        System.out.println(ans);
        for (int i = 0; i < ans.size(); i++) {
            sum += ans.get(i);
        }

        return sum;

    }

    public static void getNumbers(TreeNode root,StringBuilder sb,ArrayList<Integer> ans){

        if(root == null){
            return;
        }
        sb.append(root.data);

        if(root.left==null && root.right==null){
            ans.add(Integer.parseInt(sb.toString()));
            sb.deleteCharAt(sb.length()-1);
            return;
        }



        getNumbers(root.left,sb,ans);
        getNumbers(root.right,sb,ans);

        sb.deleteCharAt(sb.length()-1);

    }

    public static void main(String[] args) {
            TreeNode root = new TreeNode(1);
            root.left = new TreeNode(2);
            root.right = new TreeNode(3);

            int sum = sumNumbers(root);
//        System.out.println(sum);
    }
}
