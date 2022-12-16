package STRIVER_SERIES.TREES;

import java.util.LinkedList;
import java.util.Queue;

public class U_serialise_and_deserealise_BT {

    static class Node {
        int data;
        Node left, right;
        Node ( int data ) {
            this.data = data;
            left = right = null;
        }
    }
    static void inorder( Node root )
    {
        if( root == null ) return;

        inorder( root.left );
        System.out.print( root.data + " ");
        inorder( root.right );
    }
    static String serialise( Node root )
    {
        if( root ==null ) return  "";
        Queue<Node> q = new LinkedList<>();
        StringBuilder str = new StringBuilder();
        q.add( root );
        while( !q.isEmpty() )
        {
            Node tmp = q.poll() ;
            if( tmp == null ){
                str.append("# ");
                continue;
            }
            str.append(tmp.data+" ");
            q.add( tmp.left );
            q.add( tmp.right );
        }
        return str.toString() ;
    }

    static Node deserialise( String str )
    {
        if( str.equals("")) return null;
        String[] val = str.split(" ");
        Node root = new Node(Integer.parseInt(val[0] ));
        Queue<Node> q = new LinkedList<>();
        q.add( root );
        for (int i = 1; i < val.length; i++) {
            Node tmp = q.poll();
            if( !val[i].equals("#") ){
                Node n = new Node( Integer.parseInt(val[i]));
                tmp.left = n;
                q.add( n );
            }
            if(  !val[i++].equals("#")){
                Node n = new Node( Integer.parseInt(val[i]));
                tmp.right = n;
                q.add( n );
            }
        }
        return root ;
    }

    public static void main ( String[] args )
    {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.right.left = new Node(4);
        root.right.right = new Node(5);

        String str  = serialise( root );
        System.out.println( str );

        Node rut = deserialise( str );

        inorder( rut );
    }
}
