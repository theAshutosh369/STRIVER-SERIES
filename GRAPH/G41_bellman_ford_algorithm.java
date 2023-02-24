package STRIVER_SERIES.GRAPH;

import java.util.Arrays;

public class G41_bellman_ford_algorithm {

    public static void main ( String[] args ) {

        int V = 3;
        int g[][] = {{0,1,5},{1,0,3},{1,2,-1},{2,0,1}};
        int s=2;

        //---------------------------------------------------

        int e = g.length;
        int dis[] = new int[V];
        Arrays.fill( dis , Integer.MAX_VALUE);
        dis[s] = 0 ;

        for (int i = 0; i < V - 1; i++)
        {
            for (int j = 0; j < e ; j++)
            {
                int u = g[j][0];
                int v = g[j][1];
                int w = g[j][2];
                if( dis[u]!=Integer.MAX_VALUE && dis[u]+w < dis[v] )
                {
                    dis[v] = dis[u]+w;
                }
            }
        }

        // to check if negative cycle is present or not
        for (int j = 0; j < e ; j++)
        {
            int u = g[j][0];
            int v = g[j][1];
            int w = g[j][2];
            if( dis[u]!=Integer.MAX_VALUE && dis[u]+w < dis[v] )
            {
                System.out.println( "NEgative cycle present !! ");
                return;
            }
        }

        for (int i = 0; i < V; i++) {
            System.out.print( dis[i]+ " ");
        }


    }
}
