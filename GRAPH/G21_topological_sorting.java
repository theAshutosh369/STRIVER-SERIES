package STRIVER_SERIES.GRAPH;

import java.util.ArrayList;
import java.util.Stack;

public class G21_topological_sorting {

    static void dfs( int i ,  ArrayList<ArrayList<Integer>> adj , int[] vis , Stack<Integer> st  )
    {
        vis[i] =  1;

        for( int k : adj.get(i))
        {
            if( vis[k]==0 )
            {
                dfs( k , adj , vis , st );
            }
        }

        st.add( i);
    }

    public static void main ( String[] args ) {

        int V = 7;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++)
        {
            adj.add( new ArrayList<>() );
        }
        adj.get(1).add(3);
        adj.get(2).add(3);
        adj.get(4).add(1);
        adj.get(4).add(0);
        adj.get(5).add(0);
        adj.get(5).add(2);


        //--------------------------------------------

        int vis[] = new int[V];
        Stack<Integer> st = new Stack<>();
        for( int i = 0 ; i<V ; i++ )
        {
            if( vis[i]==0 ) {
                dfs(i, adj, vis, st);
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        while( !st.isEmpty() )
        {
            ans.add( st.pop() );
        }
        System.out.println( ans );


    }
}
