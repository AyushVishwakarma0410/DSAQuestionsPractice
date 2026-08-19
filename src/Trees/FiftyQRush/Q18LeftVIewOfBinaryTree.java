package Trees.FiftyQRush;

import Trees.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Q18LeftVIewOfBinaryTree {
    public static void main(String[] args) {

    }


    // few changes made but overall Confident
    // self done 95 percent
    public static void leftView(TreeNode root){

        if(root==null) return;
        // sno and node
        HashMap<Integer,TreeNode> map = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        int serial = 0;
        //  BFS
        while (!q.isEmpty()){
            int size = q.size();

            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                if (!map.containsKey(serial)){
                    map.put(serial,curr);
                }
                if (curr.left!=null){
                    q.add(curr.left);
                }
                if (curr.right!=null){
                    q.add(curr.right);
                }

            }
            serial = serial+1;

        }

        for (int i = 0; i < map.size(); i++) {
            System.out.println(map.get(i).data);
        }

    }


    public static void leftViewBFSOptimal(TreeNode root){
        if(root == null) return;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int size = q.size();

            for(int i = 0; i < size; i++){
                TreeNode curr = q.poll();

                // first node at this level
                if(i == 0){
                    System.out.print(curr.data + " ");
                }

                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }
        }
    }


    // Most optimal as it avoids queue and hashmap

    static int maxLevel = 0;

    public static void leftViewDFS(TreeNode root, int level){
        if(root == null) return;

        if(level > maxLevel){
            System.out.print(root.data + " ");
            maxLevel = level;
        }

        leftViewDFS(root.left, level + 1);
        leftViewDFS(root.right, level + 1);
    }

}
