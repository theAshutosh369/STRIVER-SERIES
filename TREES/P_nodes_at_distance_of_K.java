package STRIVER_SERIES.TREES;

import java.util.*;


public class P_nodes_at_distance_of_K
{
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

    static void markParent( Node root , Map<Node,Node> parent )
    {
        Queue<Node> q = new ArrayDeque<>();
        q.add( root );

        while ( !q.isEmpty())
        {
            Node cur = q.poll();
            if( cur.left!=null ) {
                parent.put( cur.left , cur );
                q.add( cur.left );
            }
            if( cur.right!=null ) {
                parent.put( cur.right , cur );
                q.add( cur.right );
            }
        }
    }

    static void distance( Node root , Node target, int k )
    {

        // Map for parent nodes of all present nodes
        Map<Node , Node> parent= new HashMap<>();
        markParent( root , parent );

        // visited map
        Map<Node , Boolean> visited= new HashMap<>();

        Queue<Node> q = new ArrayDeque<>();
        q.add( target );
        visited.put( target , true );
        int cur_dis = 0 ;

        while ( !q.isEmpty())
        {
            int n = q.size();
            if( cur_dis==k ) break;
            cur_dis++;

            for (int i = 0; i < n; i++)
            {
                Node cur = q.poll();
                if( cur.left!=null && visited.get(cur.left)==null ){
                    q.add(cur.left);
                    visited.put( cur.left , true);
                }
                if( cur.right!=null && visited.get(cur.right)==null ){
                    q.add(cur.right);
                    visited.put( cur.right , true);
                }
                if( parent.get(cur)!=null && visited.get(parent.get(cur))==null ){
                    q.add( parent.get(cur) );
                    visited.put( parent.get(cur) , true);
                }
            }
        }

        while( !q.isEmpty() )
        {
            System.out.print( q.poll().data + " ");
        }
        System.out.println();
    }
    public static void main ( String[] args ) {

        Node root = new Node(3);
        root.left = new Node(5);
        root.right = new Node(1);

        root.left.left = new Node(6);
        root.left.right = new Node(2);

        root.left.right.left = new Node(7);
        root.left.right.right = new Node(4);

        root.right.left = new Node(0);
        root.right.right = new Node(8);

        Node target = root.left ;
        int k = 2;
        distance( root ,  target  , k );

    }
}
