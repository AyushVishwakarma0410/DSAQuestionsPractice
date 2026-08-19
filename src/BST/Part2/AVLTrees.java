package BST.Part2;

public class AVLTrees {
    public static void main(String[] args) {

    }

    // rarely asked anywhere
    static class AVLTree {

        class Node {
            int key;
            int height;
            Node left, right;

            Node(int key) {
                this.key = key;
                this.height = 1;
            }
        }

        Node root;

        // Get height of node
        int height(Node node) {
            if (node == null)
                return 0;
            return node.height;
        }

        // Get balance factor
        int getBalance(Node node) {
            if (node == null)
                return 0;
            return height(node.left) - height(node.right);
        }

        // Right Rotation
        Node rightRotate(Node y) {

            Node x = y.left;
            Node T2 = x.right;

            // rotation
            x.right = y;
            y.left = T2;

            // update heights
            y.height = Math.max(height(y.left), height(y.right)) + 1;
            x.height = Math.max(height(x.left), height(x.right)) + 1;

            return x;
        }

        // Left Rotation
        Node leftRotate(Node x) {

            Node y = x.right;
            Node T2 = y.left;

            // rotation
            y.left = x;
            x.right = T2;

            // update heights
            x.height = Math.max(height(x.left), height(x.right)) + 1;
            y.height = Math.max(height(y.left), height(y.right)) + 1;

            return y;
        }

        // Insert Node
        Node insert(Node node, int key) {

            // 1. Normal BST insertion
            if (node == null)
                return new Node(key);

            if (key < node.key)
                node.left = insert(node.left, key);
            else if (key > node.key)
                node.right = insert(node.right, key);
            else
                return node; // duplicate not allowed

            // 2. Update height
            node.height = 1 + Math.max(height(node.left), height(node.right));

            // 3. Get balance factor
            int balance = getBalance(node);

            // 4. Handle 4 cases

            // Left Left
            if (balance > 1 && key < node.left.key)
                return rightRotate(node);

            // Right Right
            if (balance < -1 && key > node.right.key)
                return leftRotate(node);

            // Left Right
            if (balance > 1 && key > node.left.key) {
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }

            // Right Left
            if (balance < -1 && key < node.right.key) {
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }

            return node;
        }

        // Inorder traversal
        void inorder(Node node) {
            if (node != null) {
                inorder(node.left);
                System.out.print(node.key + " ");
                inorder(node.right);
            }
        }

        public static void main(String[] args) {

            AVLTree tree = new AVLTree();

            tree.root = tree.insert(tree.root, 10);
            tree.root = tree.insert(tree.root, 20);
            tree.root = tree.insert(tree.root, 30);
            tree.root = tree.insert(tree.root, 40);
            tree.root = tree.insert(tree.root, 50);
            tree.root = tree.insert(tree.root, 25);

            System.out.println("Inorder traversal:");
            tree.inorder(tree.root);
        }
    }
}
