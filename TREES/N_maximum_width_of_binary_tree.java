package STRIVER_SERIES.TREES;

import java.util.ArrayDeque;
import java.util.Queue;

public class N_maximum_width_of_binary_tree {
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
    static class pair{
        int ind ;
        Node node ;
        pair( Node node , int ind ){
            this.node = node ;
            this.ind = ind ;
        }
    }

    static int maxwidth( Node root )
    {
        if (root== null) return 0;
        int ans = 0;
        Queue<pair>  q = new ArrayDeque<>();
        q.add( new pair(root , 0 ) );

        while (!q.isEmpty())
        {
            int n = q.size();
            int min = q.peek().ind;

            int first = 0 , last = 0 ;
            for (int i = 0; i < n; i++)
            {
                int curInd = q.peek().ind - min ;
                Node temp = q.peek().node;
                q.poll();

                if( i==0 ) first = curInd;
                if( i==n-1 ) last = curInd;

                if( temp.left!=null ) q.add( new pair( temp.left , 2*curInd+1 ));
                if( temp.right!=null ) q.add( new pair( temp.right , 2*curInd+2 ));
            }
            ans = Math.max( ans , last-first+1 );
        }
        return ans;
    }

    public static void main ( String[] args ) {
        Node root = new Node(1);
        root.left = new Node(3);
        root.right = new Node(2);

        root.left.left = new Node(5);
        root.left.left.left = new Node(7);

        root.right.right = new Node(4);
        root.right.right.right = new Node(6);

        System.out.println("Maximum width of Tree is : "+ maxwidth( root ));
    }
}
