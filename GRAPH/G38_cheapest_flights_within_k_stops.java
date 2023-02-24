package STRIVER_SERIES.GRAPH;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class G38_cheapest_flights_within_k_stops {


    static class pair{
        int v , w ;
        pair( int v , int w )
        {
            this.v = v ;
            this.w = w ;
        }
    }
    static class tuple{
        int  n , stops , cost ;
        tuple( int  n ,int stops ,int cost)
        {
            this.n = n ;
            this.stops = stops ;
            this.cost = cost;
        }
    }
    public static void main ( String[] args )
    {

        int flights[][] = {{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}};
        int n = 4 , src = 0, dst = 3, k = 1 ;

        // ------------------------------------------------

        ArrayList<ArrayList<pair>> adj = new ArrayList<>();
        for (int i = 0; i < n  ; i++) {
            adj.add( new ArrayList<>());
        }
        for (int i = 0; i < flights.length; i++) {
            adj.get( flights[i][0] ).add( new pair( flights[i][1] , flights[i][2] ) );
        }

        int dis[] = new int[n];
        Arrays.fill( dis , Integer.MAX_VALUE);
        dis[src] = 0 ;

        Queue<tuple> q = new LinkedList<>();
        q.add( new tuple(src , 0 , 0 ));
        while (!q.isEmpty())
        {
            tuple t = q.poll();
            int u = t.n;
            int stops = t.stops;
            int cost = t.cost ;

            if( stops>k ) continue;

            for (int i = 0; i < adj.get(u).size(); i++) {
                int v = adj.get(u).get(i).v;
                int w = adj.get(u).get(i).w;

                if( cost+w < dis[v] && stops<=k )
                {
                    dis[v] = cost+w;
                    q.add( new tuple(v , stops+1 , dis[v] ));
                }
            }

        }

        if( dis[dst] ==Integer.MAX_VALUE) System.out.println( -1 );
        else System.out.println( dis[dst] );






    }
}
