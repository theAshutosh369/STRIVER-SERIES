package STRIVER_SERIES.TREES;

public class M_Lowest_common_ancestor_of_two_nodes {

    static class Node
    {
        int data ;
        Node left , right ;
        Node( int data )
        {
            this.data = data ;
            left = right = null ;
        }
    }

    static Node lca( Node root , int p , int q )
    {
        if( root==null || root.data==p || root.data==q ) return root;

        Node l = lca( root.left , p , q);
        Node r = lca( root.right , p , q);

        if( l==null ) return r;
        else if( r==null ) return l;
        else return root ;
    }
    public static void main ( String[] args ) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);

        root.right.left = new Node(4);
        root.right.right = new Node(5);
        root.right.right.left = new Node(6);
        root.right.right.right = new Node(7);
        root.right.left.left = new Node(8);

        System.out.println( lca( root , 7 , 8 ).data );
    }
}
