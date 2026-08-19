package Trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;




// The core idea for solving this problem is
// Create a String for each subtree.
// for creating unique String we will do post order traversal

// why post order?
// post order traversal gives left - right - root
// So suppose we have a subtree
/*
            2
           /
          4
 */
// then processing will be
// left - right - root
// 4.left null, 4.right null, and root = 4
// look at the code
// it is kind of preorder + postorder traversal but modified smartly, as we are calculating left and right first.


public class Q4FindAllDuplicateSubTree {
    public static void main(String[] args) {

    }
    Map<String,Integer> map = new HashMap<>();
    List<TreeNode> result = new ArrayList<>();

    // we will put # for neg- values.
    public String dfs(TreeNode root){
        if(root==null){
            return "#";
        }

        String left = dfs(root.left);
        String right = dfs(root.right);

        String serial = root.data + "," + left + "," + right;
        map.put(serial,map.getOrDefault(serial,0)+1);

        if(map.get(serial)==2){
            result.add(root);
        }
        return serial;

    }

}
