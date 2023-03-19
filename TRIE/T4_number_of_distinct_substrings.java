package STRIVER_SERIES.TRIE;

public class T4_number_of_distinct_substrings {

    static class Node {
        Node links[] = new Node[26];

        boolean contains( char ch )
        {
            return links[ch-'a']!=null ;
        }

        Node get( char ch )
        {
            return links[ch-'a'];
        }

        void put( char ch )
        {
            links[ch-'a'] =  new Node();
        }
    }


    public static void main ( String[] args ) {

        String str = "ccfdf";

        int n = str.length();

        Node root = new Node();
        int c= 0;

        for (int i = 0; i < n; i++) {
            Node r = root ;
            for (int j = i; j < n; j++) {
                char ch = str.charAt(j);
                if( !r.contains( ch) )
                {
                    c++;
                    r.put( ch );
                }
                r = r.get( ch );
            }
        }


        System.out.println("total number of distinct substrings in the given string are : " + (c+1) );


    }
}
