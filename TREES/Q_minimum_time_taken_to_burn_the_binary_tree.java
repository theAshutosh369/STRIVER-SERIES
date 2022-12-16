package STRIVER_SERIES.TREES;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class Q_minimum_time_taken_to_burn_the_binary_tree {
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

    static void markParent( Node root , Map<Node, Node> parent )
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
    static void distance( Node root , Node target  )
    {

        // Map for parent nodes of all present nodes
        Map<Node, Node> parent= new HashMap<>();
        markParent( root , parent );

        // visited map
        Map<Node, Boolean> visited= new HashMap<>();

        Queue<Node> q = new ArrayDeque<>();
        q.add( target );
        visited.put( target , true );
        int Ans = 0 ;

        while ( !q.isEmpty())
        {
            int n = q.size();

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

            if( !q.isEmpty() ) Ans++;
        }

        System.out.println( Ans );
    }
    public static void main ( String[] args ) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.left.left.left = new Node(8);
        root.left.right.left = new Node(9);
        root.left.right.right = new Node(10);
        root.left.right.left.left = new Node(11);

        distance( root , root.left.right.left.left  );

    }
}
