package STRIVER_SERIES.GRAPH;

import java.util.ArrayList;

public class G20_eventual_safe_states {

    static boolean dfs( int i , int[] vis , int[] pathvis , int[] check , ArrayList<ArrayList<Integer>> adj , ArrayList<Integer> ans  )
    {
        vis[i] = 1;
        pathvis[i] = 1;

        for( int k : adj.get( i ))
        {
            if( vis[k]==0 )
            {
                if( dfs( k , vis , pathvis , check , adj ,ans)) {
                    check[i] = 1 ;
                    return true;
                }
            }
            else if( pathvis[k]==1 )
            {
                check[i] = 1 ;
                return true;
            }
        }

        check[i]= 0;
        pathvis[i]=0 ;
        return false;
    }
    public static void main ( String[] args ) {

        int V = 7;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++)
        {
            adj.add( new ArrayList<>() );
        }
        adj.get(0).add(1);
        adj.get(0).add(2);
        adj.get(1).add(2);
        adj.get(1).add(3);
        adj.get(2).add(5);
        adj.get(3).add(0);
        adj.get(4).add(5);


        //----------------------------------------------------


        int vis[] = new int[V];
        int pathvis[] = new int[V];
        int check[] = new int[V];
        ArrayList<Integer> ans = new ArrayList<>();

        boolean flag = false;
        for( int i = 0 ; i<V ; i++ )
        {
            if( vis[i]==0 )
            {
                dfs( i , vis , pathvis , check , adj  , ans ) ;
            }
        }

        for (int i = 0; i < V; i++) {
            if( check[i]==0 ) ans.add(i);
        }
        System.out.println( ans );




    }
}
