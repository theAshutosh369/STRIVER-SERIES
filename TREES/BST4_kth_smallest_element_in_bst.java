package STRIVER_SERIES.TREES;

import java.util.ArrayList;

public class BST4_kth_smallest_element_in_bst {
    static class Node {
        int data;
        Node left, right;
        Node ( int data ) {
            this.data = data;
            left = right = null;
        }
    }

    static int kth_smallest( Node root , int k )
    {
        int count = 0;

        Node cur = root ;
        while (cur!=null )
        {
            if( cur.left==null )
            {
                count++;
                if( count==k )
                {
                    return cur.data;
                }
                cur = cur.right;
            }
            else
            {
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
                    count++;
                    if( count==k )
                    {
                        return cur.data;
                    }
                    cur = cur.right;
                }
            }
        }

        return -1;
    }
    public static void main ( String[] args )
    {
        Node root = new Node(4);
        root.left = new Node(2);
        root.left.left = new Node(1);
        root.left.right = new Node(3);

        root.right = new Node(5);
        root.right.right = new Node(7);
        root.right.right.left = new Node(6);

        int ele = kth_smallest( root , 7 );
        // morris traversal use kiya hai u can use any traversal of inorder recursive or iterative
        System.out.println("the kth smallest element is : "+ ele );
    }
}
