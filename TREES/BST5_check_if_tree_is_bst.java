package STRIVER_SERIES.TREES;

public class BST5_check_if_tree_is_bst {
    static class Node {
        int data;
        Node left, right;
        Node ( int data ) {
            this.data = data;
            left = right = null;
        }
    }

    static boolean validate_bst( Node root , int min , int max  )
    {
        if( root==null ) return true;

        int cur = root.data;
        return ( cur>min && cur<max ) && validate_bst( root.left , min , cur ) && validate_bst(root.right , cur , max );
    }
    public static void main ( String[] args ) {
        Node root = new Node(4);

        root.left = new Node(2);
        root.left.left = new Node(1);
        root.left.right = new Node(3);

        root.right = new Node(5);
        root.right.right = new Node(7);
        root.right.right.left = new Node(3);

        System.out.println("Is BST : "+ validate_bst( root , Integer.MIN_VALUE , Integer.MAX_VALUE ) );

    }
}
