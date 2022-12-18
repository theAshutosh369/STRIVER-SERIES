package STRIVER_SERIES.TREES;

public class BST1_searching_in_bst {
    static class Node
    {
        int data;
        Node left, right;
        Node ( int data ) {
            this.data = data;
            left = right = null;
        }
    }
    static boolean searchBST( Node root , int key )
    {
        if( root == null ) return false ;

        if( root.data == key ) return true;
        if( key < root.data ) searchBST(root.left , key );

        return searchBST( root.right , key );
    }
    public static void main ( String[] args )
    {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(4);

        root.right = new Node(5);
        root.right.right = new Node(6);
        root.right.right.left = new Node(7);

        int key = 10;
        System.out.println( "Is the key present in BST : " + searchBST( root , key ) );
    }
}
