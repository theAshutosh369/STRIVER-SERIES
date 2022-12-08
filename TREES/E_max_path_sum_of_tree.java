package STRIVER_SERIES.TREES;

public class E_max_path_sum_of_tree
{


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

    static int pathsum( Node root , int maxi[] )
    {
        if( root == null ) return  0;

        int l = pathsum(root.left, maxi) ;
        int r = pathsum(root.right, maxi) ;
        int middle = Math.max( l , r )+ root.data ;

        maxi[0] = Math.max( maxi[0] , l+r+root.data ) ;

        return middle ;
    }

    public static void main ( String[] args )
    {
        Node root  = new Node(-10 );
        root.left  = new Node(  9 );
        root.right = new Node( 20 );

        root.right.left  = new Node(15 );
        root.right.right = new Node(7 );


        int maxi[] = new int[1];
        maxi[0] = Integer.MIN_VALUE;
        pathsum( root , maxi );

        System.out.println("pathsum of the given tree is : " + maxi[0]  );
    }
}
