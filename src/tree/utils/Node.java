package tree.utils;

public class Node {

    public Node left, right;
    public int data, height;

    public Node(int key){
        data = key;
        left = right = null;
    }

}
