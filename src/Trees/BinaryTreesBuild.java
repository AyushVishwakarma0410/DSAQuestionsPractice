package Trees;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreesBuild {

    // Node of a Tree
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }


    // Building a Binary Tree
    static class BinaryTree{
        static int idx = -1;

        public static Node buildTree(int nodes[]){
            idx++;
            if(nodes[idx] == -1){
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }
    }


    // Traversal in Tree - DFS


    public static void preOrder(Node root){
        if(root == null){
            return;
        }

        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);

    }
    public static void postOrder(Node root){
        if(root == null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data+" ");
    }

    public static void inOrder(Node root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }


    // BFS
    public static void levelOrder(Node root){
        if(root == null){
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while (!q.isEmpty()){

            Node currentNode = q.remove();

            if (currentNode==null){
                System.out.println();
                if(q.isEmpty()){
                    break;
                }
                else {
                    q.add(null);
                }
            }
            else {
                System.out.print(currentNode.data);
                if(currentNode.left != null){
                    q.add(currentNode.left);
                }
                if (currentNode.right != null){
                    q.add(currentNode.right);
                }
            }

        }
    }

    // Height of a Tree

    public static int height(Node root){
        if(root == null){
            return 0;
        }

        int lh = height(root.left);
        int rh = height(root.right);
        return Math.max(lh,rh)+1;
    }


    // Total elements in Tree

    public static int countNodes(Node root){
        if(root==null){
            return 0;
        }
        int Lcount = countNodes(root.left);
        int Rcount = countNodes(root.right);
        return Lcount+Rcount+1;
    }



    // Diameter of a Tree - > the longest chain of elements in a Tree
    // approach 1
    public static int diameter(Node root){
        if(root == null){
            return 0;
        }

        int leftDiameter = diameter(root.left);
        int leftHeight = height(root.left);
        int rightDiameter = diameter(root.right);
        int rightHeight = height(root.right);

        int selfDiameter = leftHeight + rightHeight + 1;
        return Math.max(selfDiameter,Math.max(leftDiameter,rightDiameter));

    }

    public static class Info{
        int ht;
        int dia;

        public Info(int ht, int dia){
            this.dia = dia;
            this.ht = ht;
        }
    }


    // approach 2
    public static Info diameter2(Node root){
        if(root == null){
            return new Info(0,0);
        }

        Info leftInfo  = diameter2(root.left);
        Info rightInfo  = diameter2(root.right);
        int diameter = Math.max(leftInfo.dia,Math.max(rightInfo.dia,leftInfo.ht+1+rightInfo.ht));
        int ht = Math.max(leftInfo.ht,rightInfo.ht)+1;

        return new Info(diameter,ht);
    }




    // Identical SubTree

    public static boolean isSubtree(Node root, Node subRoot){

        if(root == null){
            return false;
        }

        if(root.data == subRoot.data){
            if(isIdentical(root,subRoot)){
                return true;
            }
        }

        // long cut 
//        boolean leftAns = isSubtree(root.left,subRoot);
//        boolean rightAns = isSubtree(root.right, subRoot);

        return isSubtree(root.left,subRoot) || isSubtree(root.right, subRoot);
    }

    public static boolean isIdentical(Node node, Node subRoot) {
        if(node == null && subRoot == null){
            return true;
        }
        else if (node == null || subRoot == null || node.data != subRoot.data){
            return false;
        }

        if(!isIdentical(node.left, subRoot.left)){
            return false;
        }
        if(!isIdentical(node.right, subRoot.right)){
            return false;
        }
        return true;
    }

    // gpt
//    public static boolean isIdentical(Node node, Node subRoot){
//        if(node == null && subRoot == null){
//            return true;
//        }
//        if(node == null || subRoot == null){
//            return false;
//        }
//        if(node.data != subRoot.data){
//            return false;
//        }
//
//        return isIdentical(node.left, subRoot.left) &&
//                isIdentical(node.right, subRoot.right);
//    }



    // Top view Of a Tree



        // for Queue
    static class Info2{
        Node node;
        int hd;

        public Info2(Node node, int hd){
            this.node = node;
            this.hd = hd;
        }


    }
    public static void topView(Node root){
        // level order Traversal
        Queue<Info2> q = new LinkedList<>();

        HashMap<Integer,Node> map = new HashMap<>();

        int min=0,max = 0;
        q.add(new Info2(root,0));
        q.add(null);

        while (!q.isEmpty()){
            Info2 curr = q.remove();
            if(curr == null){
                if(q.isEmpty()){
                    break;
                }else {
                    q.add(null);
                }
            }else {
                if(!map.containsKey(curr.hd)){ // first time hd is occurring
                    map.put(curr.hd,curr.node);
                }

                if(curr.node.left != null){
                    q.add(new Info2(curr.node.left, curr.hd-1));
                    min = Math.min(min, curr.hd-1);
                }
                if(curr.node.right != null){
                    q.add(new Info2(curr.node.right, curr.hd+1));
                    max = Math.max(max,curr.hd+1);
                }
            }


        }



        for(int i = min; i <= max; i++){
            System.out.print(map.get(i).data+ " ") ;
        }
        System.out.println();
    }

    // gpt
//    public static void topView(Node root) {
//        if (root == null) return;
//
//        Queue<Info2> q = new LinkedList<>();
//        HashMap<Integer, Integer> map = new HashMap<>();
//
//        int min = 0, max = 0;
//        q.add(new Info2(root, 0));
//
//        while (!q.isEmpty()) {
//            Info2 curr = q.remove();
//
//            if (!map.containsKey(curr.hd)) {
//                map.put(curr.hd, curr.node.data);
//            }
//
//            if (curr.node.left != null) {
//                q.add(new Info2(curr.node.left, curr.hd - 1));
//                min = Math.min(min, curr.hd - 1);
//            }
//            if (curr.node.right != null) {
//                q.add(new Info2(curr.node.right, curr.hd + 1));
//                max = Math.max(max, curr.hd + 1);
//            }
//        }
//
//        for (int i = min; i <= max; i++) {
//            System.out.print(map.get(i) + " ");
//        }
//    }



    // Kth Level Of Tree
    
    public static void KthLevelOfTree(Node root, int k, int level){
        if(root == null){
            return;
        }
        if(level == k){
            System.out.println(root.data+" ");
            return;
        }
        KthLevelOfTree(root.left, level+1, k);
        KthLevelOfTree(root.right,level+1,k);
    }

    public static void main(String[] args) {
            int [] nodes = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
            BinaryTree tree = new BinaryTree();
            Node root = tree.buildTree(nodes);
            System.out.println(root.data);


        System.out.println("post order");
            postOrder(root);
        System.out.println();
        System.out.println("In order");
            inOrder(root);
        System.out.println();
        System.out.println("pre order");
            preOrder(root);
        System.out.println();
        System.out.println("level order");
            levelOrder(root);
        System.out.println();
        System.out.println("Height of a Tree");
        System.out.println(height(root));
        System.out.println("Count nodes");
        System.out.println(countNodes(root));
        topView(root);


    }
}
