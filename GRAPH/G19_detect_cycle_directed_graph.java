package STRIVER_SERIES.GRAPH;

import java.util.ArrayList;

public class G19_detect_cycle_directed_graph {

    static boolean dfs( int i , int[] vis , int[] pathvis , ArrayList<ArrayList<Integer>> adj )
    {
        vis[i] = 1;
        pathvis[i] = 1;


        for( int k : adj.get( i ))
        {
            if( vis[k]==0 )
            {
                if( dfs( k , vis , pathvis , adj )) return true;
            }
            else if( pathvis[k]==1 )
            {
                return true;
            }
        }


        pathvis[i]=0 ;
        return false;
    }

    public static void main ( String[] args ) {

        int V = 4;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++)
        {
            adj.add( new ArrayList<>() );
        }
        adj.get(0).add(1);
        adj.get(1).add(2);
        adj.get(2).add(3);
        adj.get(3).add(3);

//        ----------------------------------


        int vis[] = new int[V];
        int pathvis[] = new int[V];

        boolean flag = false;
        for( int i = 0 ; i<V ; i++ )
        {
            if( vis[i]==0 )
            {
                if( dfs( i , vis , pathvis , adj ) ){
                    flag = true;
                    break;
                }
            }
        }
        if( flag ) System.out.println("YES cycle is present !! ");
        else System.out.println("No cycle is not present !! ");

    }
}
