package STRIVER_SERIES.TREES;

public class J_left_and_right_view_tree {
    static class Node{
        int data ;
        Node left , right ;
        Node( int data )
        {
            this.data = data ;
            left = right = null ;
        }
    }

    static  int max = 0 ;
    static void leftview( Node root , int lvl  )
    {
        if( root==null ) return;

        if( lvl > max ) {
            System.out.print(root.data + " ");
            max = lvl;
        }
        leftview( root.left , lvl+1  );
        leftview( root.right , lvl + 1);
    }


    static void rightview( Node root , int lvl )
    {

        if( root==null ) return;

        if( lvl > max ) {
            System.out.print(root.data + " ");
            max = lvl;
        }
        rightview( root.right , lvl+1  );
        rightview( root.left , lvl + 1);
    }

    public static void main ( String[] args )
    {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);

        root.right.left = new Node(9);
        root.right.right = new Node(10);
        root.left.left = new Node(4);
        root.left.right = new Node(10);

        root.left.left.right = new Node(5);
        root.left.left.right.right = new Node(6);

        System.out.println("LEFT VIEW OF TREE :  " );
        leftview( root , 1 );
        System.out.println();

        max = 0 ;
        System.out.println("RIGHT VIEW OF TREE : " );
        rightview( root , 1 );

    }
}
