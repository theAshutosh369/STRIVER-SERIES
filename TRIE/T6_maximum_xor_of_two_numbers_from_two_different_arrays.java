package STRIVER_SERIES.TRIE;

public class T6_maximum_xor_of_two_numbers_from_two_different_arrays {

    static class Node {
        // only 2 reference , one for 0 and other for 1
        Node links[] = new Node[2];

        boolean contains( int n  )
        {
            return links[n]!=null ;
        }

        Node get( int n )
        {
            return links[n];
        }

        void put( int n)
        {
            links[n] =  new Node();
        }
    }

    static class Trie{
        Node root = new Node();

        void insert( int n )
        {
            Node r = root ;
            for (int i = 31; i>=0 ; i--) {

                // get the bit from leftmost side one by one and check for it
                int bit = (n>>i) & 1;
                if( !r.contains( bit ))
                {
                    r.put( bit );
                }
                r = r.get( bit );
            }
        }

        int getMax( int n )
        {
            Node r = root ;
            int mx = 0;
            for (int i = 31; i>=0 ; i-- ) {
                int bit = (n>>i) & 1;
                if( r.contains( 1-bit ))
                {
                    mx = mx | (1<<i);
                    r = r.get( 1-bit );
                }
                else {
                    r = r.get( bit );
                }
            }

            return mx ;
        }
    }


    public static void main ( String[] args ) {
        int n = 3 , m = 4;
        int arr1[] = { 2 , 1 , 4};
        int arr2[] = { 3, 4, 5 ,6 };

        Trie t = new Trie();
        for (int i = 0; i < n; i++) {
            t.insert( arr1[i] );
        }

        int mx = 0;
        for (int i = 0; i < m; i++) {
            mx = Math.max( mx , t.getMax(arr2[i]) );
        }
        System.out.println( mx );

    }
}
