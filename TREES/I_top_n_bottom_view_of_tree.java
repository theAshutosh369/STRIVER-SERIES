package STRIVER_SERIES.TREES;

import java.util.ArrayDeque;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class I_top_n_bottom_view_of_tree
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

    static void topview( Node root , int hd )
    {
        Queue<pair> q = new ArrayDeque<>();
        q.add( new pair( root , 0 ));

        Map<Integer , Node > mp = new TreeMap<>();

        while (!q.isEmpty())
        {
            pair cur = q.poll();
            mp.putIfAbsent( cur.hd , cur.node );

            if( cur.node.left!=null ) q.add( new pair( cur.node.left , cur.hd -1 ));
            if( cur.node.right!=null ) q.add( new pair( cur.node.right , cur.hd +1 ))  ;
        }

        for (Map.Entry<Integer , Node > e : mp.entrySet())
        {
            Node tmp = e.getValue();
            System.out.print(tmp.data + " ");
        }
    }

    static void bottomView( Node root , int hd )
    {
        Queue<pair> q = new ArrayDeque<>();
        q.add( new pair( root , 0 ));

        Map<Integer , Node > mp = new TreeMap<>();

        while (!q.isEmpty())
        {
            pair cur = q.poll();
            mp.put( cur.hd , cur.node );

            if( cur.node.left!=null ) q.add( new pair( cur.node.left , cur.hd -1 ));
            if( cur.node.right!=null ) q.add( new pair( cur.node.right , cur.hd +1 ))  ;
        }

        for (Map.Entry<Integer , Node > e : mp.entrySet())
        {
            Node tmp = e.getValue();
            System.out.print(tmp.data + " ");
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

        System.out.println("TOP VIEW OF TREE :  " );
        topview( root , 0 );
        System.out.println();

        System.out.println("BOTTOM VIEW OF TREE : " );
        bottomView( root , 0 );

    }
}
