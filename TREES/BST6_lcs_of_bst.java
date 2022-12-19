package STRIVER_SERIES.TREES;

public class BST6_lcs_of_bst
{
    static class Node {
        int data;
        Node left, right;
        Node ( int data )
        {
            this.data = data;
            left = right = null;
        }
    }

    static Node lca( Node root , Node a , Node b )
    {
        if( root == null) return null;
        int cur = root.data;

        if( a.data<cur && b.data<cur ) return lca( root.left , a , b );
        if( a.data>cur && b.data>cur ) return lca( root.right , a , b );

        return root ;
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


        Node a = root.left.right  , b = root.right.right.left ;
        System.out.println(" Lowest common ancestor of two node "+ a.data +" and "+ b.data +" are : \n " + lca( root , a , b ).data);
    }
}
