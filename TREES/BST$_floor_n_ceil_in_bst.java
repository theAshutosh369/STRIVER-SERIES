package STRIVER_SERIES.TREES;

public class BST$_floor_n_ceil_in_bst {
    static class Node
    {
        int data;
        Node left, right;
        Node ( int data )
        {
            this.data = data;
            left = right = null;
        }
    }

    static int floor = -1 , ceil = -1 ;
    static void floor_n_ceil( Node root , int key )
    {
        while (root!=null)
        {
            if( key == root.data )
            {
                floor = root.data;
                ceil = root.data ;
                return;
            }
            else if( key < root.data )
            {
                ceil = root.data;
                root = root.left ;
            }
            else
            {
                floor = root.data ;
                root = root.right ;
            }
        }
    }

    public static void main ( String[] args ) {
        Node root = new Node(8);
        root.left = new Node(6);

        root.right = new Node(21);
        root.right.right = new Node(26);
        root.right.left = new Node(15);
        root.right.left.left = new Node(13);


        floor_n_ceil(  root , 22 );
        System.out.println("Floor : " + floor );
        System.out.println("Ceil  : " + ceil  );
    }
}
