    package Trees;

    import java.util.*;



    // All codes, few are self done though

    public class Test {
        public static void main(String[] args) {
            int [] nodes = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
            binaryTree tree = new binaryTree();
            Node root = tree.buildTree(nodes);

//            System.out.println("Preorder:");
//            preOrder(root);
//
//            System.out.println("Inorder:");
//            inOrder(root);
//
//            System.out.println("Postorder:");
//            postOrder(root);

//            levelOrder(root);
            kthLevel(root,2);
            kthlvlRec(root,2);
        }
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

        static class binaryTree{

            // in nodes array, -1 means leaf node, so inside the array there are -1s showing that they are leaf.

            static int idx = -1;
            public static Node buildTree(int[] nodes){
                idx++;
                // here null == -1
                if(nodes[idx] == -1){
                    return null;
                }

                Node newNode = new Node(nodes[idx]);
                newNode.left = buildTree(nodes);
                newNode.right = buildTree(nodes);

                return newNode;
            }
        }

        public static void preOrder(Node root){
            if(root==null){
                return;
            }

            System.out.println(root.data);
            preOrder(root.left);
            preOrder(root.right);
        }


        public static void inOrder(Node root){
            if(root==null){
                return;
            }

            inOrder(root.left);
            System.out.println(root.data);
            inOrder(root.right);
        }



        public static void postOrder(Node root){
            if(root==null){
                return;
            }

            postOrder(root.left);
            postOrder(root.right);
            System.out.println(root.data);

        }


        public static void levelOrder(Node root){


            if(root == null) return;


            Queue<Node> queue = new LinkedList<>();
            queue.add(root);

            while (!queue.isEmpty()){
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    Node node = queue.poll();
                    System.out.print(node.data+" ");
                    if(node.left!=null)
                        queue.add(node.left);
                    if(node.right!=null)
                        queue.add(node.right);
                }
                System.out.println();
            }


        }
        public static int height(Node root) {


            if (root == null) {
                return 0;
            }
            int left = height(root.left);
            int right = height(root.right);
            if (left > right) {
                return left + 1;
            } else {
                return right + 1;
            }
        }


        // node count using BFS
        public static int nodeCountBFS(Node root){
            if(root==null) return 0;

            Queue<Node> q = new LinkedList<>();
            q.add(root);
            int nodeCount = 0;
            while (!q.isEmpty()){

                    Node curr = q.poll();
                    nodeCount++;
                    if (curr.left!=null)
                        q.add(curr.left);
                    if(curr.right!=null)
                        q.add(curr.right);


            }


            return nodeCount;
        }


        // used recursion
        public static int nodeCountDFS(Node root){

            if(root == null){
                return 0;
            }

            int left = nodeCountDFS(root.left);
            int right = nodeCountDFS(root.right);

            return left+right+1;
        }

        // longest possible pathway
        public static int diameter(Node root){
            if(root == null){
                return 0;
            }

            int diameterLeft = diameter(root.left);
            int heightLeft = height(root.left);
            int diameterRight = diameter(root.right);
            int heightRight = height(root.right);

            int selfDiameter = heightLeft + heightRight + 1;


            return Math.max(selfDiameter, Math.max(diameterLeft,diameterRight));


        }

        static class Info{
            int diameter;
            int height;

            public Info(int diameter, int height){
                this.diameter = diameter;
                this.height = height;
            }
        }

        public static Info diameter2(Node root){


                // Base case
                if(root == null){
                    return new Info(0,0);
                }


                // for left node
                Info leftInfo = diameter2(root.left);
                // for right node
                Info rightInfo = diameter2(root.right);

                // for current node
                int diameter = Math.max(leftInfo.diameter,Math.max( rightInfo.diameter,leftInfo.height+rightInfo.height+1));
                int height = Math.max(leftInfo.height,rightInfo.height)+1;


                return new Info(diameter,height);

        }

        public static boolean isSubTree(Node node, Node subRoot){

            // first find node
            // check structure and values


            // 1. find node
            if(node == null){
                return false;
            }

            if(subRoot.data == node.data) {
                if (isIdentical(node, subRoot)) {
                    return true;
                }
            }
            boolean left = isSubTree(node.left,subRoot);
            boolean right = isSubTree(node.right,subRoot);

            return left || right;

        }


        public static boolean isIdentical(Node root, Node subRoot){

            // if both are null that means we reached null on both sides
            if(root == null && subRoot == null){
                return true;
            }
            else if(root == null|| subRoot==null || root.data != subRoot.data) return false;

            if(!isIdentical(root.left,subRoot.left)){
                return false;
            }
            if(!isIdentical(root.right,subRoot.right)){
                return false;
            }

            return true;

        }

        // TOP VIEW

        static class Info2{
            Node node;
            int hd;

            Info2(Node node,int hd){
                this.node = node;
                this.hd = hd;
            }
        }

        public static void topView(Node root){
            // For level order traversal
            Queue<Info2> q = new LinkedList<>();
            // For storing values
            LinkedHashMap<Integer,Node> map = new LinkedHashMap();

            q.add(new Info2(root,0));
            int min = 0, max = 0;

            while (!q.isEmpty()){

                Info2 curr = q.poll();

                if(curr==null){
                    if(q.isEmpty()){
                      break;
                    }else {
                         q.add(null);
                    }
                }else {
                    // adding to map
                    if(!map.containsKey(curr.hd)){
                        map.put(curr.hd,curr.node);
                    }

                    if(curr.node.left != null){
                        q.add( new Info2(curr.node.left,curr.hd-1));
                        min = Math.min(min,curr.hd-1);
                    }
                    if(curr.node.right!=null){
                        q.add(new Info2(curr.node.right,curr.hd+1));
                        max = Math.max(max,curr.hd+1);
                    }
                }



            }



            for (int i = min; i <= max ; i++){
                System.out.println(map.get(i)+" ");
            }


        }




        // Kth level of Tree

        public static void kthLevel(Node root, int k){

            // for level order
            Queue<Node> q = new LinkedList<>();

            q.add(root);
            int level = 1;

            while (!q.isEmpty()){
                int size = q.size();

                // when found the level
                if(level == k){
                    for (int i = 0; i < size;i++){
                        System.out.print(q.poll().data+" ");
                    }
                    System.out.println();
                    return;
                }




                for (int i = 0; i < size; i++) {
                    Node curr = q.poll();
                    if(curr.left!=null){
                        q.add(curr.left);
                    }
                    if(curr.right!=null){
                        q.add(curr.right);
                    }
                }

                level++;

            }



        }


        public static void kthlvlRec(Node root, int k){

            if(root==null) return;

            k--;

            if(k==0) {
                System.out.println(root.data);
                return;
            }


            kthlvlRec(root.left,k);
            kthlvlRec(root.right,k);
        }

            // Lowest common ancestor
        public static int LCA1(Node root,Node node1,Node node2){

            ArrayList<Node> path1 = new ArrayList<>();
            ArrayList<Node> path2 = new ArrayList<>();

            getPath(root,node1.data,path1);
            getPath(root,node2.data,path2);

            int i = 0;
            while (i < path1.size() && i < path2.size()){
                if(path1.get(i) != path2.get(i)){
                    break;
                }
                i++;
            }

            Node LCA = path1.get(i-1);

            return LCA.data;
        }


        // Trying to find the node, brute force recursion
        public static boolean getPath(Node root,int n, ArrayList<Node> path){

            if(root==null){
                return false;
            }


            path.add(root);

            if(root.data==n){
                return true;
            }

            boolean foundLeft = getPath(root.left,n,path);
            boolean foundRight = getPath(root.right,n,path);

            // if found return true so that the path does not get removed
            if(foundLeft || foundRight){
                return true;
            }

            // otherwise remove the last node since we do not found the required value
            path.remove(path.size()-1);
            // and therefore we return false
            return false;
        }



        // this approach in based on the fact that if we dont find the value in any branch it will return null
        // 3 4 baar khud se likhna padega tab ayega samjh

        public static Node LCA2(Node root,int n1, int n2){

            // BASE CASES
            if(root == null){
                return null;
            }




            if(root.data==n1 || root.data==n2){
                return root;
            }


            Node left = LCA2(root.left,n1,n2);
            Node right = LCA2(root.right,n1,n2);

            if(left==null){
                return right;
            }
            if(right==null) {
                return left;
            }

            return root;


        }

        public static int LCAdist(Node root, int n){

            // If we are at the end
            if(root==null){
                return -1;
            }

            // If found, that means we are currently at that position so return 0
            if(root.data == n){
                return 0;
            }


            int leftDist = LCAdist(root.left, n);
            int rightDist = LCAdist(root.right, n);

            if(leftDist == -1 && rightDist == -1){
                return -1;
            }
            else if(leftDist == -1){
                return rightDist + 1;
            }else {
                return leftDist + 1;
            }

        }


        public static int minDist(Node root,int n1,int n2){
            Node lca = LCA2(root,n1,n2);
            int dist1 = LCAdist(lca,n1);
            int dist2 = LCAdist(lca,n2);

            return dist1 + dist2;
        }



        // For a single Node
        public static int KAncenstor(Node root, int n,int k){

            // found
            if(root.data == n){
                return 0;
            }

            int leftDist = KAncenstor(root.left,n,k);
            int rightDist = KAncenstor(root.right,n,k);


            // Node is not present in the given tree or subtree( if we are in a branch)
            if(leftDist==-1 && rightDist==-1){
                return -1;
            }

            // we could have use if else but Math.max has been used as definitely one of them is -1.
            int max = Math.max(leftDist,rightDist);
            if(max+1==k){
                System.out.println(root.data);
            }
            return k+1;
        }



        public static int sumTree(Node root){
            if(root == null){
               return 0;
            }

            int leftChild = sumTree(root.left);
            int rightChild = sumTree(root.right);

            int data = root.data;

            int newLeft = root.left == null? 0 : root.left.data;
            int newRight = root.right == null ? 0 : root.right.data;

            root.data = newLeft + leftChild + newRight + rightChild;

            return data;
        }
    }
