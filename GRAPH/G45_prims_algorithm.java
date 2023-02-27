package STRIVER_SERIES.GRAPH;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class G45_prims_algorithm {

    static class pair{
        int v , w ;
        pair( int v , int w )
        {
            this.v = v ;
            this.w = w ;
        }
    }
    public static void main ( String[] args ) {

        int V = 3 , E = 3;
        int g[][] = {{0, 1 ,5},
                {1, 2, 3},
                {0, 2, 1}};

        //-------------------------------------------------

        ArrayList<ArrayList<pair>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add( new ArrayList<>());
        }
        for (int i = 0; i < E; i++) {
            adj.get( g[i][0] ).add( new pair( g[i][1] , g[i][2] ));
            adj.get( g[i][1] ).add( new pair( g[i][0] , g[i][2] ));
        }

        int vis[] = new int[V];
        PriorityQueue<pair> q = new PriorityQueue<>((x,y)->x.w-y.w);
        q.add( new pair(0,0));

        int mst = 0;
        while (!q.isEmpty())
        {
            pair p = q.poll();
            int cur = p.v;
            int weight = p.w;

            if( vis[cur]==1 ) continue;

            vis[cur]=1;
            mst+=weight;

            for (int i = 0; i < adj.get(cur).size(); i++) {
                int v = adj.get(cur).get(i).v;
                int w = adj.get(cur).get(i).w;

                if( vis[v]==0 ) q.add( new pair(v , w ));
            }

        }

        System.out.println( "Minimum spanning tree : " +  mst );

    }
}
