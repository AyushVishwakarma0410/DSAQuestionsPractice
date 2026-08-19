package Trees.FiftyQRush;

import Trees.TreeNode;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Q20TopView {
    public static void main(String[] args) {

    }

    static class  Pair{
        int hd;
        TreeNode node;
        Pair(int hd,TreeNode node){
            this.hd  = hd;
            this.node = node;
        }
    }
    public static void TopView(TreeNode root){

        if(root == null) return;

        HashMap<Integer,TreeNode> map = new HashMap<>();

        // for BFS
        Queue<Pair> q = new LinkedList<>();

        int min = 0;
        int max = 0;

        q.add(new Pair(0,root));

        while (!q.isEmpty()){

            Pair curr = q.poll();

            if(!map.containsKey(curr.hd)){
                map.put(curr.hd,curr.node);
            }

            if(curr.node.left!=null){
                q.add(new Pair(curr.hd-1,curr.node.left));
                min = Math.min(min,curr.hd-1);
            }
            if (curr.node.right!=null){
                q.add(new Pair(curr.hd+1,curr.node.right));
                max = Math.max(max,curr.hd+1);
            }

        }
        for (int i = min; i <= max ; i++) {
            System.out.print(map.get(i).data + " ");
        }

    }
}
