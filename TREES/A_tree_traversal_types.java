package STRIVER_SERIES.TREES;

import java.util.*;

public class A_tree_traversal_types
{

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

    static void inorder( Node root )
    {
         if( root == null )
         {
             return ;
         }
         inorder( root.left );
         System.out.print(root.data + " ");
         inorder( root.right );
    }

    static void preorder( Node root )
    {
        if( root == null ) {
            return ;
        }
        System.out.print(root.data + " ");
        preorder( root.left );
        preorder( root.right );
    }
    static void postorder( Node root )
    {
        if( root == null ) {
            return ;
        }
        postorder( root.left );
        postorder( root.right );
        System.out.print(root.data + " ");
    }
    static void level_order( Node root )
    {
        if( root ==  null ) return;

        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Node> q = new ArrayDeque<>();
        q.add( root );

        while ( !q.isEmpty() )
        {
            Node temp = q.poll();

            if( temp.left !=null ) q.add( temp.left );
            if( temp.right !=null ) q.add( temp.right );

            ans.add( temp.data );
        }
        System.out.println( ans );
    }

    static void iterative_inorder( Node root )
    {
        Stack<Node> st = new Stack<>();

        while ( true )
        {
            if( root!=null ){
                st.add(root );
                root = root.left ;
            }
            else if( st.isEmpty() ) break;
            else {
                root = st.pop();
                System.out.print(root.data + " ");
                root = root.right ;
            }
        }
    }

    static void iterative_Preorder( Node root )
    {
        Stack<Node> st = new Stack<>();
        st.add( root );

        while ( !st.isEmpty() )
        {
            Node temp = st.pop() ;
            System.out.print( temp.data + " ");
            if( temp.right!= null ) st.add( temp.right );
            if( temp.left!= null ) st.add( temp.left );
        }
    }

    static void iterative_Postorder( Node root )
    {
        Stack<Node> st1 = new Stack<>();
        Stack<Node> st2 = new Stack<>();

        st1.add( root );

        while ( !st1.isEmpty() )
        {
           Node temp = st1.pop();
           st2.add( temp );
           if( temp.left!=null ) st1.add( temp.left );
           if( temp.right!=null ) st1.add( temp.right );
        }

        while ( !st2.isEmpty() )
        {
            System.out.print( st2.pop().data + " ");
        }
    }

    public static void main ( String[] args )
    {
        Node root = new Node(1 );
        root.left = new Node(2 );
        root.right = new Node(3 );
        root.left.left = new Node(4 );
        root.left.right = new Node(5 );
        root.right.left = new Node(6 );
        root.right.right = new Node(7 );

        System.out.println("Recursive Inorder traversal : ");
        inorder( root );
        System.out.println();

        System.out.println("Recursive Preorder traversal : ");
        preorder( root );
        System.out.println();

        System.out.println("Recursive Postorder traversal : ");
        postorder( root );
        System.out.println();

        System.out.println("Level Order traversal : ");
        level_order( root  );
        System.out.println();

        System.out.println("Iterative Inorder traversal : ");
        iterative_inorder( root );
        System.out.println();

        System.out.println("Iterative Preorder traversal : ");
        iterative_Preorder( root );
        System.out.println( );

        System.out.println("Iterative Postorder traversal : ");
        iterative_Postorder( root );
    }


}
