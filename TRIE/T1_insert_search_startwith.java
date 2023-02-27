package STRIVER_SERIES.TRIE;



public class T1_insert_search_startwith {


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
        boolean search( String str )
        {
            Node r = root ;
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                if( r.containsKey(ch) ) r = r.get(ch);
                else return false;
            }

            return r.flag;
        }
        boolean startswith( String str )
        {
            Node r = root ;
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                if( r.containsKey(ch) ) r = r.get(ch);
                else return false;
            }

            return true;
        }


    }



    public static void main ( String[] args ) {

        int n = 5;
        int[] type = {1, 1, 2, 3, 2};
        String[] value = {"hello", "help", "help", "hel", "hel"};

        Trie t = new Trie();

        for (int i = 0; i < n; i++) {

            if( type[i]==1 )
            {
                t.insert( value[i] );
            }
            else if( type[i]==2 )
            {
                if( t.search( value[i] )) System.out.println("True");
                else System.out.println("False");
            }
            else {
                if( t.startswith( value[i] )) System.out.println("True");
                else System.out.println("False");
            }
        }


    }
}
