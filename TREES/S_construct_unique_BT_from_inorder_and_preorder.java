package STRIVER_SERIES.TREES;

import java.util.HashMap;
import java.util.Map;

public class S_construct_unique_BT_from_inorder_and_preorder {

    static class Node {
        int data;
        Node left, right;
        Node ( int data ) {
            this.data = data;
            left = right = null;
        }
    }

    static Node build( int inorder[] , int inStart , int inEnd , int preorder[] , int preStart , int preEnd , Map<Integer , Integer> mp  )
    {
        if( preStart>preEnd || inStart>inEnd ) return null ;
        Node root = new Node(  preorder[ preStart] );

        int inroot = mp.get( root.data );
        int inleft = inroot - inStart ;

        root.left = build( inorder , inStart , inroot-1 , preorder , preStart+1 , preStart+inleft , mp  )  ;
        root.right = build( inorder , inroot+1 , inEnd , preorder , preStart+inleft+1 , preEnd , mp  )  ;

        return root ;
    }

    static void inorder( Node root )
    {
        if( root == null ) return;

        inorder( root.left );
        System.out.print( root.data + " ");
        inorder( root.right );
    }

    public static void main ( String[] args ) {

        int inorder[] = { 40 , 20 , 50 , 10 , 60 , 30  };
        int preorder[] = { 10 , 20 , 40 , 50 , 30 , 60  };
        Map<Integer,Integer> mp = new HashMap<>();

        for (int i = 0; i < inorder.length ; i++) {
            mp.put( inorder[i] , i );
        }

        Node root = build( inorder , 0 , inorder.length-1 , preorder , 0 , preorder.length , mp );

        inorder( root );
    }
}
