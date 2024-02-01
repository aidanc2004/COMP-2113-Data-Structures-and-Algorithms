public class Main {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        /* FINAL TREE:
                0               depth: 0
               / \
              -1  3             depth: 1
                 / \
                2   10          depth: 2
               /
              1                 depth: 3
        */

        tree.insertData(0);
        tree.insertData(-1);
        tree.insertData(3);
        tree.insertData(10);
        tree.insertData(2);
        tree.insertData(1);

        //tree.testPrint();
        System.out.println("Inorder:");
        tree.inorderTraverse();
        System.out.println("\nPreorder:");
        tree.preorderTraverse();
        System.out.println("\nPostorder:");
        tree.postorderTraverse();
        System.out.println("\nBreadth First Traverse:");
        tree.breadthTraverse();

        // depth
        System.out.println("\nDepth:");
        System.out.println(tree.depth(new Node(0)));
        System.out.println(tree.depth(new Node(3)));
        System.out.println(tree.depth(new Node(1)));
        System.out.println(tree.depth(new Node(123)));

        System.out.println("Size : " + tree.sizeBtree(tree.getRoot()));
    }
}