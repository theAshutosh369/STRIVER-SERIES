package STRIVER_SERIES.GRAPH;

import java.util.*;

public class G35_printing_the_path_from_src_to_dest_in_dijkstras_algorithm {

    static class pair{
        int v , w ;
        pair( int v , int w )
        {
            this.v = v ;
            this.w = w;
        }
    }
    public static void main ( String[] args ) {

        int V = 5 , E = 6  ;
        int[][] adj = {{0,1,2}, {1,4,5}, {1,2,4}, {0,3,1},{3,2,3},{2,4,1}} ;
        int src = 0 , dest = V-1;


        // --------------------------------------------

        ArrayList<ArrayList<pair>> g = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            g.add( new ArrayList<>());
        }
        for (int i = 0; i < E; i++) {
            g.get( adj[i][0] ).add( new pair( adj[i][1] , adj[i][2] ));
            g.get( adj[i][1] ).add( new pair( adj[i][0] , adj[i][2] ));
        }

        int parent[] = new int[V];
        for (int i = 0; i < V; i++) {
            parent[i] = i;
        }
        int dist[] = new int[V];
        Arrays.fill( dist , Integer.MAX_VALUE);
        dist[src]=0 ;

        Queue<pair> q = new LinkedList<>();
        q.add( new pair( src , 0) ) ;
        while( !q.isEmpty() )
        {
            int u = q.poll().v;

            for( int i = 0 ; i<g.get(u).size() ; i++ )
            {
                int v = g.get(u).get(i).v;
                int d = g.get(u).get(i).w;
                if( dist[u] + d < dist[v] )
                {
                    dist[v] =  dist[u] + d;
                    parent[v] = u;
                    q.add( new pair( v , dist[v]) );
                }
            }
        }


        System.out.println("Shortest path from source to all the nodes : ");
        for (int i = 0; i < V; i++) {
            System.out.print( dist[i] + " ");
        }
        System.out.println();


        ArrayList<Integer> path = new ArrayList<>();
        if( dist[dest]==Integer.MAX_VALUE){
            path.add(-1);
            System.out.println( path );
        }

        int n = dest;
        while ( parent[n]!=n )
        {
            path.add(n);
            n = parent[n];
        }
        path.add( src );

        Collections.reverse( path );
        System.out.println("Shortest path in the graph from source " + src + " to destination " + dest +" is : "+ path);



    }
}
