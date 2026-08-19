package Trees.FiftyQRush;

import Trees.TreeNode;
import java.util.HashMap;
import java.util.ArrayList;

public class Q33BuildTreesFromPreAndIn {
    public static void main(String[] args) {
//        construction(new ArrayList<>(),new ArrayList<>());

    }


    // Thought this was but was too lazy for implementation

    static int preIndex = 0;
    static HashMap<Integer, Integer> map = new HashMap<>();

    public static TreeNode buildTree(int[] preorder, int[] inorder) {

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return construct(preorder, 0, inorder.length - 1);
    }
        public static TreeNode construct(int[] preorder, int start, int end){

            if (start > end) return null;

            int rootVal = preorder[preIndex++];
            TreeNode root = new TreeNode(rootVal);

            int index = map.get(rootVal);

            root.left = construct(preorder, start, index - 1);
            root.right = construct(preorder, index + 1, end);

            return root;
        }
}

