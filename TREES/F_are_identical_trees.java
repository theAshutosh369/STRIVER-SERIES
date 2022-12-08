package STRIVER_SERIES.TREES;

public class F_are_identical_trees {

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

        static boolean isSame( Node p  , Node q )
    {
        if( p==null || q==null ) return p==q ;
        return p.data==q.data && isSame( p.left,q.left) && isSame( p.right,q.right);
    }

    public static void main ( String[] args ) {

        Node p  = new Node(-10 );
        p.left  = new Node(  9 );
        p.right = new Node( 20 );

        p.right.left  = new Node(15 );
        p.right.right = new Node(7 );

        Node q = new Node(-10 );
        q.left  = new Node(  9 );
        q.right = new Node( 20 );

        q.right.left  = new Node(15 );
        q.right.right = new Node(9 );

        System.out.println("the given tree is same : " + isSame( p , q ));
    }

}
