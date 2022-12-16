package STRIVER_SERIES.TREES;public class R_count_no_nodes_in_complete_BT
{

    static class Node {
        int data;
        Node left, right;

        Node ( int data ) {
            this.data = data;
            left = right = null;
        }
    }

    static int height(Node root , char ch )
    {
        int c = 0;
        while (root!=null) {
            c++;
            if( ch=='L') root = root.left;
            else  root = root.right;
        }
        return c;
    }
    static int noOfNodes( Node root )
    {
        if( root == null ) return 0 ;

        int lh = height( root.left , 'L' );
        int rh = height( root.right , 'R');

        if( lh==rh ) return (2<<lh) - 1;

        return 1 + noOfNodes(root.left) + noOfNodes(root.right);
    }


    public static void main ( String[] args ) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(9);
        root.right.right = new Node(8);
        root.left.left.left = new Node(6);
        root.left.left.right = new Node(7);

        System.out.println( noOfNodes(root) );
    }
}


