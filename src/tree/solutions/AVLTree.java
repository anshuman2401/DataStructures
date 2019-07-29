package tree.solutions;

import tree.utils.Node;

public class AVLTree {

    private Node leftRotate(Node node) {
        Node newNode = node.right;
        node.right = node.right.left;
        newNode.left = node;

        node.height = setHeight(node);
        newNode.height = setHeight(newNode);

        return newNode;
    }

    private Node rightRotate(Node node){
        Node newNode = node.left;
        node.left = newNode.left.right;
        newNode.right = node;

        node.height = setHeight(node);
        newNode.height = setHeight(newNode);

        return newNode;
    }

    private Node insert(Node root, int data){

        if (root == null)
            return new Node(data);

        if (root.data <= data)
            root.right = insert(root.right, data);
        else
            root.left = insert(root.left, data);

        int balance = balance(root.left, root.right);

        if(balance > 1){

            if(height(root.left.left) > height(root.right.left)){
                root = rightRotate(root);
            }else {
                root.left = leftRotate(root.left);
                root = rightRotate(root);
            }
        }else if (balance < -1){
            if (height(root.right.right) > height(root.right.left)){
                root = leftRotate(root);
            }else {
                root.right = rightRotate(root.right);
                root = leftRotate(root);
            }
        }else {
            root.height = setHeight(root);
        }

        return root;
    }

    private int setHeight(Node root) {
        if (root == null)
            return 0;

        return 1 + Math.max(height(root.left), height(root.right));
    }

    private int height(Node node){
        if (node == null)
            return 0;

        return node.height;
    }

    private int balance(Node left, Node right) {
        return height(left) - height(right);
    }

    public static void main(String[] args) {

        AVLTree tree = new AVLTree();

        Node root = null;
        root = tree.insert(root, -10);
        root = tree.insert(root, 2);
        root = tree.insert(root, 13);
        root = tree.insert(root, -13);
        root = tree.insert(root, -15);
        root = tree.insert(root, 15);
        root = tree.insert(root, 17);
        root = tree.insert(root, 20);

        TreeTraversal treeTraversal = new TreeTraversal();
        treeTraversal.inOrder(root);
    }
}
