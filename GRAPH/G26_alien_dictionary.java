package STRIVER_SERIES.GRAPH;

import java.util.*;

public class G26_alien_dictionary {

    public static void main ( String[] args ) {

        int n = 5 ;
        int k = 4;
        String dict[] = {"baa","abcd","abca","cab","cad"};

        //------------------------------------------------

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for( int i =0 ; i<26 ; i++ )
        {
            adj.add( new ArrayList<>());
        }

        Set<Character> st = new HashSet<>();
        for( int i = 0 ; i<n-1; i++ )
        {
            String a = dict[i];
            String b = dict[i+1];
            int len = Math.min( a.length() , b.length() );
            for( int j = 0 ; j<len ; j++ )
            {
                char ach = a.charAt(j);
                char bch = b.charAt(j);
                if( ach!=bch )
                {
                    st.add( ach );
                    st.add( bch );
                    adj.get( ach-97 ).add( bch-97 );
                    break;
                }
            }
        }

        int indegree[] = new int[26];
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < adj.get(i).size(); j++) {
                indegree[ adj.get(i).get(j) ]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for( int i = 0 ; i<26 ; i++ )
        {
            if( st.contains((char)(i+97))  && indegree[i] ==0 ) q.add(i);
        }


        ArrayList<Integer> ans = new ArrayList<>();
        while ( !q.isEmpty()) {
            int i = q.poll();
            ans.add(i);

            for (int l : adj.get(i)) {
                indegree[l]--;
                if (indegree[l] == 0) q.add(l);
            }

        }

        String res = "";
        for (int i = 0; i < ans.size(); i++) {
            res+= (char)( ans.get(i)+97 );
        }

        System.out.println( res );



    }
}
