package STRIVER_SERIES.TREES;

public class O_children_sum_property {
    static class Node
    {
        int data ;
        Node left , right ;
        Node( int data )
        {
            this.data = data ;
            left = right = null ;
        }
    }
    static void changetree( Node root )
    {
        if( root == null) return;

        int child = 0 ;
        if( root.left!=null ) child += root.left.data;
        if( root.right!=null) child += root.right.data;

        if( child < root.data )
        {
            if( root.left!=null ) root.left.data = root.data;
            if( root.right!=null ) root.right.data = root.data;
        }
        else{
            root.data = child;
        }

        changetree( root.left);
        changetree( root.right);

        int total = 0;
        if( root.left!= null ) total = total + root.left.data;
        if( root.right!= null ) total = total + root.right.data;

        if( root.left!=null || root.right!=null ) root.data = total;
    }
    static void printTree( Node root )
    {
        if( root==null ) return;

        printTree( root.left );
        System.out.print( root.data + " " );
        printTree( root.right );
    }
    public static void main ( String[] args )
    {
        Node root = new Node(40);
        root.left = new Node(10);
        root.right = new Node(20);
        root.left.left = new Node(2);
        root.left.right = new Node(5);
        root.right.left = new Node(30);
        root.right.right = new Node(40);

        changetree( root );

        printTree( root );


    }

}
