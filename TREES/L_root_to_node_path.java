package STRIVER_SERIES.TREES;

import java.awt.*;
import java.util.ArrayList;

public class L_root_to_node_path {
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
    static boolean path( Node root , int key , ArrayList<Integer> arr )
    {
        if( root==null ) return false;

        arr.add( root.data );
        if( root.data == key ) return true;

        if( path(root.left,key,arr ) || path( root.right , key, arr) ) return true;

        arr.remove( arr.size()-1 );
        return false;
    }
    public static void main ( String[] args ) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.right = new Node(7);
        root.right.right = new Node(6);

        ArrayList<Integer> arr = new ArrayList<>();
        path( root , 7 , arr );
        System.out.println( arr );


    }
}
