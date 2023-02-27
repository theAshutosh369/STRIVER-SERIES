package STRIVER_SERIES.TRIE;

public class T2_insert_countWordEqaulsTo_countWordsStartingWith_eraseWord {

    static class Node{
        Node[] links = new Node[26];
        int countEndsWith ;
        int countPrefix ;
        Node( )
        {
            countEndsWith=0;
            countPrefix=0;
        }

        boolean containsKey( char ch )
        {
            return links[ch-'a']!=null;
        }

        Node get( char ch )
        {
            return links[ch-'a'];
        }

        void put( char ch )
        {
            links[ch-'a'] = new Node();
        }

    }

    static class Trie{
        static Node root ;
        Trie()
        {
            root = new Node();
        }

        void insert( String str )
        {
            Node r = root ;
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                if( !r.containsKey(ch) )
                {
                    r.put(ch);
                }
                r=r.get(ch);
                r.countPrefix++;
            }
            r.countEndsWith++;
        }


        int CountWordsEqualTo( String str )
        {
            Node r = root ;
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                if( r.containsKey(ch) ) r = r.get(ch);
                else return 0;
            }
            return r.countEndsWith;
        }

        int CountWordsStartingWith( String str )
        {
            Node r = root ;
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                if( r.containsKey(ch) ) r = r.get(ch);
                else return 0;
            }
            return r.countPrefix;
        }

        void erase( String str )
        {
            Node r = root ;
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                if( r.containsKey(ch) ){
                    r = r.get(ch);
                    r.countPrefix--;
                }
                else return ;
            }
            r.countEndsWith--;
        }
    }

    public static void main ( String[] args ) {

        Trie t = new Trie();
        t.insert("apple");
        t.insert("apple");
        t.insert("apps");
        t.insert("apps");


        System.out.println( t.CountWordsEqualTo("apple"));
        System.out.println( t.CountWordsEqualTo("apps"));
        System.out.println( t.CountWordsStartingWith("app"));

        t.erase("apple");
        System.out.println( t.CountWordsEqualTo("apple"));





    }
}
