package depthFirstSearch;

public class Node<T> {
    T key;
    Node left, right;

    public Node(T key) {
        this.key = key;
        left = right = null;
    }

    public void printVertical() {
        printVerticalHelper(this, 0);
    }

    private void printVerticalHelper(Node node, int indentation) {
        if (node == null) {
            return;
        }

        printVerticalHelper(node.left, indentation + 1);

        for (int i = 0; i < indentation; i++) {
            System.out.print("  ");
        }
        System.out.println(node.key);

        printVerticalHelper(node.right, indentation + 1);
    }
}
