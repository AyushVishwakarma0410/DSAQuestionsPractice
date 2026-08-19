package Queues;

import java.util.ArrayList;
import java.util.List;
import Queues.LC102.TreeNode;
public class Q102_2 {
    public static void main(String[] args) {

    }

    /*
    *  int size = list.size() - index;


since the list keeps on increasing therefore we keep a separate variable size which limits the for loop.
*  But how are we managing it by substracting the index ? how is this working ?

Ans :  because when the loop finishes, we will be at the index which we added before, and after that all the elements
* will be new, suppose we added 2 3 at lvl 2 and next we have 4 5 6 7 at level 3 then list size becomes 7 and idx = 3
* we have 7 - 3 = 4.
    so loop goes from 0 to 4 ?
    *
    *
    *
    *
    *
    *
    *
    *
    * */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        List<TreeNode> list = new ArrayList<>();
        list.add(root);

        int index = 0;

        while (index < list.size()) {
            int size = list.size() - index;
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = list.get(index++);
                level.add(node.val);

                if (node.left != null){
                    list.add(node.left);
                }
                if (node.right != null){
                    list.add(node.right);
                }
            }

            result.add(level);
        }

        return result;
    }
}
