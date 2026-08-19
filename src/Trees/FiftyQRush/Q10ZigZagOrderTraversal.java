package Trees.FiftyQRush;

import Trees.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Q10ZigZagOrderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        zigZag(root);
    }


// Self done
        public static void zigZag(TreeNode root) {

        if (root == null) {
                return;
        }

        boolean leftToright = true;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()){

            ArrayList<Integer> list = new ArrayList<>();
            int size = q.size();


            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                list.add(curr.data);

                if(curr.left!=null){
                    q.add(curr.left);
                }
                if(curr.right!=null){
                    q.add(curr.right);
                }


            }

            // print level in correct direction
            if(!leftToright) Collections.reverse(list);

            for (int val : list){
                System.out.print(val+ " ");
            }
            System.out.println();

            leftToright = !leftToright;


        }



        }
}
