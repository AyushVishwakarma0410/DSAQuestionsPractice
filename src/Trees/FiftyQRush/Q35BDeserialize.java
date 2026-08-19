package Trees.FiftyQRush;

import Trees.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


// Learned something new
// Convert String to queues
// then using that queue make tree




public class Q35BDeserialize {
    public static void main(String[] args) {

    }

    public static TreeNode deserialize(String data){

        // remember this - split method
        String[] values = data.split(",");
        Queue<String> queue = new LinkedList<>(Arrays.asList(values));

        return buildTree(queue);
    }


    // Preorder
    public static TreeNode buildTree(Queue<String> queue){


        String val = queue.poll();

        if(val.equals("null")){
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(val));

        node.left = buildTree(queue);
        node.right = buildTree(queue);

        return node;
    }
}
