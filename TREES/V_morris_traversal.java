package STRIVER_SERIES.TREES;

import java.util.ArrayList;

public class V_morris_traversal {
    static class Node {
        int data;
        Node left, right;
        Node ( int data ) {
            this.data = data;
            left = right = null;
        }
    }
    static void morris_inorder( Node root )
    {
        ArrayList<Integer> arr = new ArrayList<>();
        Node cur = root ;
        while (cur!=null )
        {
            if( cur.left==null )
            {
                arr.add(cur.data);
                cur = cur.right;
            }
            else {
                Node prev = cur.left;
                while (prev.right!=null && prev.right!=cur )
                {
                    prev = prev.right;
                }

                if(prev.right==null )
                {
                    prev.right = cur ;
                    cur = cur.left;
                }
                else {
                    prev.right  = null ;
                    arr.add( cur.data);
                    cur = cur.right;
                }
            }
        }
        System.out.println("Inorder traversal will be : ");
        System.out.println( arr );
    }

    static void morris_preorder( Node root )
    {
        ArrayList<Integer> arr = new ArrayList<>();
        Node cur = root ;
        while (cur!=null )
        {
            if( cur.left==null )
            {
                arr.add(cur.data);
                cur = cur.right;
            }
            else {
                Node prev = cur.left;
                while (prev.right!=null && prev.right!=cur )
                {
                    prev = prev.right;
                }

                if(prev.right==null )
                {
                    prev.right = cur ;
                    arr.add( cur.data);
                    cur = cur.left;
                }
                else {
                    prev.right  = null ;
                    cur = cur.right;
                }
            }
        }
        System.out.println("Preorder traversal will be : ");
        System.out.println( arr );
    }
    public static void main ( String[] args )
    {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.right = new Node(6);
        root.right = new Node(3);

        morris_inorder( root );
        morris_preorder( root );
    }
}
