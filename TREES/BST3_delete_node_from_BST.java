package STRIVER_SERIES.TREES;

public class BST3_delete_node_from_BST {
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

    static void inorder( Node root )
    {
        if( root==null ) return;
        inorder( root.left );
        System.out.print(root.data + " ");
        inorder( root.right );
    }

    static int minvalue( Node root )
    {
        int min = root.data ;
        if(root.left !=null )
        {
            root = root.left ;
            min = root.data ;
        }
        return  min ;
    }

    static Node delete( Node root   , int key )
    {
        if( root==null ) return root ;
        if( key< root.data) root.left = delete(root.left , key );
        else if( key> root.data ) root.right = delete(root.right , key );
        else {
            if(root.left == null ) return root.right;
            else if(root.right == null) return root.left;
            else {
                root.data = minvalue(root.right);
                root.right = delete(root.right, root.data);
            }
        }
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

        inorder( root );

        delete(root ,  2);
        System.out.println();

        inorder( root );

    }
}
