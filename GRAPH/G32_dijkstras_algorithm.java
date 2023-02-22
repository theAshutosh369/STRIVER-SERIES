package STRIVER_SERIES.GRAPH;

import java.util.Arrays;
import java.util.PriorityQueue;

public class G32_dijkstras_algorithm {


    static class pair{
        int node , w ;
        pair( int node , int w )
        {
            this.node = node ;
            this.w = w;
        }
    }
    public static void main ( String[] args ) {

        int V = 3, E = 3;
        int[][][] adj = {  {{1, 1}, {2, 6}},   {{2, 3}, {0, 1}},    {{1, 3}, {0, 6}}     };
        int s = 0; // source


        // --------------------------------------------


        int dist[] = new int[V];
        Arrays.fill( dist , Integer.MAX_VALUE);
        dist[s]=0 ;

        // simply queue use kiya to bhi chalega yaha
        // comparetor diya hai PQ ko (x,y)-> x.w - y.w  ye lamda function hai
        PriorityQueue<pair> q = new PriorityQueue< pair >( (x,y)-> x.w - y.w );
        q.add( new pair( s , 0) ) ;
        while( !q.isEmpty() )
        {
            int u = q.poll().node;

            for( int i = 0 ; i<adj[u].length ; i++ )
            {
                int v = adj[u][i][0];
                int d = adj[u][i][1];
                if( dist[u] + d < dist[v] )
                {
                    dist[v] =  dist[u] + d;
                    q.add( new pair( v , dist[v]) );
                }
            }
        }

        for (int i = 0; i < V; i++) {
            System.out.print( dist[i] + " ");
        }

    }
}
