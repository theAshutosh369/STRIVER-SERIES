package STRIVER_SERIES.TREES;

public class K_is_symmetric_tree {
    static class Node{
        int data ;
         Node left , right ;
        Node( int data )
        {
            this.data = data ;
            left = right = null ;
        }
    }

    static boolean isSymmetric( Node r1 , Node r2)
    {
        if( r1==null && r2==null) return true;
        if( r1!=null && r2!=null )
        {
            return r1.data==r2.data && isSymmetric( r1.left , r2.right) && isSymmetric(r1.right , r2.left);
        }
        return false;
    }
    public static void main ( String[] args ) {
         Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(2);

        root.right.left = new Node(4);
        root.right.right = new Node(3);
        root.left.left = new Node(3);
        root.left.right = new Node(4);

        System.out.println("The given tree is symmetric : " + isSymmetric(root , root));
    }
}
