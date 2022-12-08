package STRIVER_SERIES.TREES;

import java.util.ArrayList;

public class G_Boundary_traversal_in_trees {
    static boolean isleaf( Node root )
    {
        if(root.left==null && root.right==null ) return true;
        else return false;
    }
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
    static void addLeftBoundary( Node root , ArrayList<Integer> ans )
    {
        root = root.left ;
        while ( root!=null )
        {
            if( isleaf(root) ) break;
            ans.add( root.data);
            if( root.left!=null ) root = root.left;
            else root = root.right;

        }
    }
    static void addLeaves( Node root , ArrayList<Integer> ans )
    {
        if (isleaf(root)) {
            ans.add(root.data);
            return ;
        }

        if(root.left!=null ) addLeaves(root.left , ans);
        if(root.right!=null ) addLeaves(root.right , ans);


    }
    static void addRightBoundary( Node root , ArrayList<Integer> ans )
    {
        ArrayList<Integer> tmp = new ArrayList<>();
        root = root.right ;
        while ( root!=null )
        {
            if( isleaf(root) ) break;
            tmp.add( root.data);
            if( root.left!=null ) root = root.left;
            else root = root.right;
        }


        for (int i = tmp.size()-1; i>=0 ; i--) {
            ans.add( tmp.get(i) );
        }
    }
    public static void main ( String[] args )
    {

        Node root = new Node(1 );
        root.left = new Node(2);
        root.right = new Node(7);

        root.left.left = new Node(3);
        root.left.left.right = new Node(4);
        root.left.left.right.left = new Node(5);
        root.left.left.right.right = new Node(6);
        root.right.right = new Node(8);
        root.right.right.left = new Node(9);
        root.right.right.left.left = new Node(10);
        root.right.right.left.right = new Node(11);

        ArrayList<Integer> ans = new ArrayList<>();
        if( !isleaf(root )) ans.add(root.data );

        addLeftBoundary( root , ans );
        addLeaves( root , ans );
        addRightBoundary( root , ans );

        System.out.println( ans );

    }
}
