package STRIVER_SERIES.GRAPH;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class G28_shortest_path_in_directed_graph {

    static class pair{
        int v , w;
        pair( int v , int w )
        {
            this.v = v ;
            this.w = w ;
        }
    }
    public static void main ( String[] args )
    {
        int V = 7 , E = 8;
        int[][] g = {{0,4,2},{0,5,3},{5,4,1},{4,6,3},{4,2,1},{6,1,2},{2,3,3},{1,3,1}};

        //---------------------------------------------------

        ArrayList<ArrayList<pair> > arr = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            arr.add( new ArrayList<>());
        }
        for (int i = 0; i < E; i++) {
            arr.get( g[i][0] ).add( new pair( g[i][1] , g[i][2] ));
        }

        int dist[] = new int[V];
        Arrays.fill( dist , Integer.MAX_VALUE);
        dist[0] = 0;
        Queue<pair> q = new LinkedList<>();
        q.add( new pair( 0 , 0 ) );

        while ( !q.isEmpty())
        {
            int cur = q.peek().v;
            int d = q.peek().w;
            q.poll();
            for (int i = 0; i < arr.get(cur).size(); i++) {

                int node = arr.get(cur).get(i).v;
                int distance = arr.get(cur).get(i).w;

                if( dist[cur]+distance < dist[node] )
                {
                    dist[node] = dist[cur]+distance;
                    q.add( new pair( node , dist[node])  );
                }
            }
        }

        for (int i = 0; i < V; i++) {
            System.out.print( dist[i] + " ");
        }
        System.out.println( );
    }
}
