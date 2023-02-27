package STRIVER_SERIES.TRIE;




// CODE IS NOT WORKING


public class T3_longest_word_with_all_prefixes {

    static class Node{
        Node[] links = new Node[26];
        boolean flag ;
        Node() {
            this.flag = false;
        }

        boolean containsKey( char ch )
        {
            return links[ch-'a']!=null;
        }

        void put( char ch , Node n )
        {
            links[ch-'a'] = n ;
        }

        Node get( char ch )
        {
            return links[ch-'a'];
        }


    }


    static class Trie{
        static Node root ;

        Trie( )
        {
            root = new Node();
        }

        void insert( String str )
        {
            Node r = root ;
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                if( !r.containsKey(ch) ) {
                    r.put( ch , new Node());
                }
                r = r.get( ch );
            }
            r.flag = true;
        }

        boolean check( String str )
        {
            Node r = root ;
            boolean flag = true;
            for (int i = 0; i < str.length() ; i++) {
                char ch = str.charAt(i);
                if( r.containsKey(ch) ) {
                    r = r.get( ch );
                    if( !r.flag ) return false;
                }
                else return false;

            }
            return true;
        }


    }

    public static void main ( String[] args ) {

        int n = 4;
        String arr[] = {"geeksforgeeks", "geeks", "geek",  "geezer"};

        //-----------------------------------------



        Trie t = new Trie();
        for( int i =0 ; i<n ; i++ )
        {
            t.insert(arr[i]);
        }

        String str = "";
        for( String i : arr )
        {
            if( t.check(i) )
            {
                if( i.length() >str.length() ) str = i;
                else if( i.length()==str.length() && i.compareTo(str)<0 ) str= i;
            }

        }

        if( str.equals("") ) System.out.println(-1);
        else System.out.println( str );



    }
}

