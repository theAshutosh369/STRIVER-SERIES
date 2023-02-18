package STRIVER_SERIES.GRAPH;

import java.util.ArrayList;
import java.util.Arrays;

public class G17_bipartite_graph {

    static boolean dfs( int i , int color , ArrayList<ArrayList<Integer>> arr , int[] col )
    {

        col[i] = color ;

        for( int k : arr.get(i))
        {
            if( col[k]==-1 )
            {
                if( dfs( k,1-color, arr ,col ) ) return false;
            }
            else if( col[k]==color )
            {
                return false;
            }
        }
        return true;
    }



    public static void main ( String[] args ) {

        int graph[][] = {{1,2,3},{0,2},{0,1,3},{0,2}};
        int V = graph.length;
        ArrayList< ArrayList<Integer> > adj = new ArrayList<>();
        for( int i=0 ; i<V; i++ )
        {
            adj.add( new ArrayList() );
        }
        for( int i = 0; i<V ; i++ )
        {
            for( int j = 0 ; j<graph[i].length ; j++ )
            {
                adj.get(i).add( graph[i][j] );
            }
        }
        int color[] = new int[V];
        for(int i = 0;i<V;i++) color[i] = -1;

        // for connected components
        for(int i = 0;i<V;i++) {
            if(color[i] == -1) {
                if(  !dfs(i, 0, adj, color) ) {
                    System.out.println("FALSE");
                    return ;
                }
            }
        }
        System.out.println("TRUE");


    }
}
