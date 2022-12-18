package STRIVER_SERIES.TREES;

public class BST2_insert_into_BST
{
    static class Node
    {
        int data;
        Node left, right;
        Node ( int data )
        {
            this.data = data;
            left = right = null;
        }
    }

    static void inorder( Node root )
    {
        if( root==null ) return;
        inorder( root.left );
        System.out.print(root.data + " ");
        inorder( root.right );
    }
    static Node insertKey( Node root , int  key )
    {
        if( root == null ) return new Node( key );

        if( key < root.data ) root.left = insertKey( root.left , key );
        else root.right = insertKey( root.right  , key );

        return root ;
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

        int key = 5;
        insertKey( root , key );

        inorder( root );
    }
}
