package Trees.FiftyQRush;

import Trees.TreeNode;

import java.util.HashMap;

public class Q34BuildTreeFromPostOrderAndInOrder {


    int postIndex;
    HashMap<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        postIndex = postorder.length - 1;

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return build(postorder, 0, inorder.length - 1);
    }

    public TreeNode build(int[] post, int start, int end) {

        if (start > end) return null;

        int val = post[postIndex--];
        TreeNode root = new TreeNode(val);

        int index = map.get(val);

        root.right = build(post, index + 1, end);
        root.left = build(post, start, index - 1);

        return root;
    }
}
