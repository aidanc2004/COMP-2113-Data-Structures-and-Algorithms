import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
    private Node root;

    public BinarySearchTree() {
        this.root = null;
    }

    // insert data into the tree
    public void insertData(int data) {
        Node newNode = new Node(data);
        Node temp = this.root; // current node

        while (true) {
            // if node is empty
            if (temp == null) {
                this.root = newNode;
                return;
            }

            // set left or right
            if (temp.getLeft() == null && data < temp.getData()) {
                temp.setLeft(newNode);
                return;
            } else if (temp.getRight() == null && data >= temp.getData()) {
                temp.setRight(newNode);
                return;
            }

            // go to next node
            if (data < temp.getData()) {
                temp = temp.getLeft();
            } else {
                temp = temp.getRight();
            }
        }
    }

    // print size of the tree
    public int sizeBtree(Node node) {
        // if no children, return 1
        if (node.getRight() == null && node.getLeft() == null) {
            return 1;
        }

        int num = 1; // node + children

        // add 1 to num for left node
        if (node.getLeft() != null) {
            num += sizeBtree(node.getLeft());
        }

        // add 1 to num for right node
        if (node.getRight() != null) {
            num += sizeBtree(node.getRight());
        }

        return num; // number of nodes
    }

    // wrapper function for inorderTraverseRecursive that calls with the parameter this.root
    public void inorderTraverse() {
        inorderTraverseRecursive(this.root);
    }

    // wrapper function for preorderTraverseRecursive that calls with the parameter this.root
    public void preorderTraverse() {
        preorderTraverseRecursive(this.root);
    }

    // wrapper function for postorderTraverseRecursive that calls with the parameter this.root
    public void postorderTraverse() {
        postorderTraverseRecursive(this.root);
    }

    // print tree inorder
    private void inorderTraverseRecursive(Node node) {
        // if root is empty, dont print anything
        if (node == null) {
            return;
        }

        if (node.getLeft() != null) {
            inorderTraverseRecursive(node.getLeft());
        }

        System.out.println(node.getData());

        if (node.getRight() != null) {
            inorderTraverseRecursive(node.getRight());
        }
    }

    // print tree preorder
    private void preorderTraverseRecursive(Node node) {
        // if root is empty, dont pritn anything
        if (node == null) {
            return;
        }

        System.out.println(node.getData());

        if (node.getLeft() != null) {
            preorderTraverseRecursive(node.getLeft());
        }

        if (node.getRight() != null) {
            preorderTraverseRecursive(node.getRight());
        }
    }

    // print tree postorder
    private void postorderTraverseRecursive(Node node) {
        // if root is empty, dont print anything
        if (node == null) {
            return;
        }

        if (node.getLeft() != null) {
            postorderTraverseRecursive(node.getLeft());
        }

        if (node.getRight() != null) {
            postorderTraverseRecursive(node.getRight());
        }

        System.out.println(node.getData());
    }

    // traverse tree using breadth first search
    public void breadthTraverse() {
        // if root is empty, dont print anything
        if (this.root == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<>();

        queue.add(this.root); // add root to queue

        while (!queue.isEmpty()) {
            Node node = queue.remove(); // take first node from queue

            System.out.println(node.getData());

            // add left node to queue
            if (node.getLeft() != null) {
                queue.add(node.getLeft());
            }

            // add right node to queue
            if (node.getRight() != null) {
                queue.add(node.getRight());
            }
        }
    }

    // get depth of a specific node, return -1 if doesnt exist in tree
    public int depth(Node node) {
        Node temp = this.root;
        int depth = 0;

        while (true) {
            // if nodes are the same
            if (temp == node || temp.getData() == node.getData()) {
                return depth;
            }

            // go to next
            if (node.getData() < temp.getData()) {
                // make sure next exists
                if (temp.getLeft() == null) {
                    return -1;
                } else {
                    temp = temp.getLeft();
                }
            } else {
                if (temp.getRight() == null) {
                    return -1;
                } else {
                    temp = temp.getRight();
                }
            }

            depth++; // increment depth
        }
    }

    public Node getRoot() {
        return root;
    }
}
