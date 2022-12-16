package STRIVER_SERIES.TREES;

import java.util.HashMap;
import java.util.Map;

public class T_construct_BT_using_inorder_n_postorder {
    static class Node {
        int data;
        Node left, right;
        Node ( int data ) {
            this.data = data;
            left = right = null;
        }
    }

    static Node build( int inorder[] , int is , int ie , int postorder[] , int ps , int pe , Map<Integer , Integer> mp  )
    {
        if( ps>pe || is>ie ) return null ;

        Node root = new Node(  postorder[pe]  );

        int inroot = mp.get( root.data );
        int inleft = inroot - is ;

        root.left = build( inorder , is , inroot-1 , postorder , ps , ps+inleft-1 , mp  )  ;
        root.right = build( inorder , inroot+1 , ie , postorder , ps+inleft , pe-1 , mp  )  ;

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
        int postorder[] = { 40 , 50 , 20 , 60 , 30 , 10  };
        Map<Integer,Integer> mp = new HashMap<>();

        for (int i = 0; i < inorder.length ; i++) {
            mp.put( inorder[i] , i );
        }

        Node root = build( inorder , 0 , inorder.length-1 , postorder , 0 , postorder.length-1 , mp );

        inorder( root );
    }
}
