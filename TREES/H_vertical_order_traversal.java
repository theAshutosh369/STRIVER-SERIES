package STRIVER_SERIES.TREES;

import javax.swing.*;
import java.util.*;

public class H_vertical_order_traversal
{
    static class Node{
        int data ;
        Node left , right ;
        Node( int data )
        {
            this.data = data ;
            left = right = null ;
        }
    }
    static class pair{
        Node node;
        int hd;
        pair( Node node , int hd )
        {
            this.node = node ;
            this.hd = hd;
        }
    }

    static void vertical_order( Node root , int hd )
    {
        Queue<pair> q = new ArrayDeque<>();
        q.add( new pair(root , 0 ) );

        Map<Integer , ArrayList<Integer>> mp = new TreeMap<>();

        while (!q.isEmpty())
        {
            pair cur = q.poll();

            // storing values in data structure
            if( !mp.containsKey(cur.hd))
            {
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add( cur.node.data );
                mp.put( cur.hd , temp) ;
            }
            else {
                mp.get( cur.hd).add( cur.node.data );
            }

            if( cur.node.left!=null ) q.add( new pair( cur.node.left , cur.hd-1 ) );
            if( cur.node.right!=null ) q.add( new pair(  cur.node.right , cur.hd+1 ) );
        }

        for ( Map.Entry<Integer , ArrayList<Integer>> e : mp.entrySet() )
        {
            ArrayList<Integer> tmp = e.getValue();
            for (int i = 0; i < tmp.size(); i++) {
                System.out.print(tmp.get(i)+ " ");
            }
        }
    }
    public static void main ( String[] args )
    {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);

        root.right.left = new Node(9);
        root.right.right = new Node(10);
        root.left.left = new Node(4);
        root.left.right = new Node(10);

        root.left.left.right = new Node(5);
        root.left.left.right.right = new Node(6);

        vertical_order( root , 0 );
    }
}
