package tree.solutions;

import tree.utils.Node;

public class TreeTraversal {

    protected void preOrder(Node node){
        if (node == null)
            return;

        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    protected void inOrder(Node node){
        if (node == null)
            return;

        preOrder(node.left);

        System.out.print(node.data + " ");

        preOrder(node.right);
    }

    protected void postOrder(Node node){
        if (node == null)
            return;

        preOrder(node.left);
        preOrder(node.right);

        System.out.print(node.data + " ");
    }
}
