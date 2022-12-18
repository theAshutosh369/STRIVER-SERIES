package STRIVER_SERIES.TREES;

import java.util.Stack;

public class W_flatten_BT_to_linked_list {
    static class Node
    {
        int data;
        Node left, right;
        Node ( int data ) {
            this.data = data;
            left = right = null;
        }
    }

    static void preorder( Node root )
    {
         if( root == null ) return;

        System.out.print(root.data + " ");
         preorder(root.left );
         preorder(root.right );
    }

    static Node prev = null ;
    static void flatten_recursive( Node root )
    {
        if( root == null ) return;
        flatten_recursive(root.right );
        flatten_recursive(root.left );

        root.right = prev;
        root.left = null ;
        prev = root;
    }

    static void flatten_iterative( Node root )
    {
        Stack<Node> st = new Stack<>();
        st.add( root );
        while ( !st.isEmpty() )
        {
            Node cur = st.pop();

            if( cur.right!=null ) st.add( cur.right );
            if( cur.left!=null ) st.add( cur.left );

            if( !st.isEmpty() ) cur.right = st.peek();
            cur.left = null ;
        }
    }
    public static void main ( String[] args )
    {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(4);

        root.right = new Node(5);
        root.right.right = new Node(6);
        root.right.right.left = new Node(7);

        preorder( root );
        System.out.println();


        flatten_recursive( root );
        preorder( root );
        System.out.println();


        flatten_iterative( root );
        preorder( root );
        System.out.println();

    }
}
