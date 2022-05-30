package syntax;
class Node {
    public char value;
    public Node left;
    public Node right;

    public Node(char c) {
        this.value = c;
    }
}

class TreeTraverser {
    static void preorder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.value);
        preorder(node.left);
        preorder(node.right);
    }

    static void inorder(Node node) {
        if (node == null) {
            return;
        }
        inorder(node.left);
        System.out.print(node.value);
        inorder(node.right);
    }

    static void postorder(Node node) {
        if (node == null) {
            return;
        }
        inorder(node.left);
        inorder(node.right);
        System.out.print(node.value);
    }
}

public class BinaryTreeExamples {
    public static void main(String[] args) {
        // construct the tree
        Node root = new Node('r');
        root.left = new Node('b');
        root.left.left = new Node('a');
        root.left.right = new Node('c');
        root.right = new Node('y');
        root.right.left = new Node('x');
        root.right.right = new Node('z');

        TreeTraverser.preorder(root);
        System.out.println();
        TreeTraverser.inorder(root);
        System.out.println();
        TreeTraverser.postorder(root);
        System.out.println();
    }
}
