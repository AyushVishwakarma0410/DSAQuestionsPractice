package Queues;

import java.util.ArrayList;
import java.util.List;
import Queues.LC102.TreeNode;
import com.sun.source.tree.Tree;

///========================== GPT ========================///
public class Q102_1 {
    public static void main(String[] args) {

    }
    // using two lists
    public static List<List<Integer>> levelOrder(TreeNode node){

        List<List<Integer>> result = new ArrayList<>();

        if(node==null){
            return result;
        }



        List<TreeNode> currentLevel = new ArrayList<>();
        currentLevel.add(node);
        while (!currentLevel.isEmpty()){

            List<Integer> values = new ArrayList<>();
            List<TreeNode> nextLevel = new ArrayList<>();

            for (TreeNode Node : currentLevel){
                values.add(Node.val);
                if(Node.left!=null) nextLevel.add(Node.left);
                if(Node.right!=null) nextLevel.add(Node.right);
            }

            result.add(values);
            currentLevel = nextLevel;
        }

        return result;

    }

}
