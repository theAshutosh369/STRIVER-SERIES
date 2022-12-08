package STRIVER_SERIES.TREES;

public class C_is_tree_balanced {
    static class Node
    {
        int data ;
        Node left , right ;
        Node( int d)
        {
            data = d;
            left = right = null;
        }
    }

    static int height( Node root)
    {
        if( root == null ) return 0 ;

        return 1+ Math.max( height(root.left) , height(root.right) );
    }

    static boolean isbalanced( Node root )
    {
        if( root == null ) return true;

        return isbalanced( root.left) && isbalanced( root.right) && Math.abs( height(root.left)- height(root.right) )<=1  ;
    }
    public static void main ( String[] args ) {
        Node root = new Node(1 );
        root.left = new Node(2 );
        root.right = new Node(3 );
        root.left.left = new Node(4 );
        root.left.right = new Node(5 );
        root.right.left = new Node(6 );
        root.right.right = new Node(7 );

        System.out.println("Is the tree balanced : " + isbalanced( root ));


    }
}
