package STRIVER_SERIES.GRAPH;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public record G27_Shortest_Path_in_Directed_Acyclic_Graph_Topological_Sort() {

    static class pair{
        int v , w;
        pair( int v , int w )
        {
            this.v = v;
            this.w = w;
        }
    }
    static void toposort( int i , Stack<Integer> st ,  ArrayList<ArrayList<pair>> adj  , int vis[]  ){
        vis[i]=1;

        for( pair p : adj.get(i))
        {
            if( vis[ p.v ]==0 ) toposort( p.v , st ,  adj , vis );
        }
        st.add( i );
    }
    public static void main ( String[] args ) {

        int V = 6;
        int E = 7;
        int graph[][] = {{0,1,2},{0,4,1},{4,5,4},{4,2,2},{1,2,3},{2,3,6},{5,3,1}};

        //----------------------------------------------------------

        ArrayList<ArrayList<pair>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add( new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
                adj.get( graph[i][0] ).add( new pair( graph[i][1] , graph[i][2] ));
        }


        int vis[] = new int[V];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < V; i++) {
            if( vis[i]==0 ){
                toposort( i , st , adj , vis );
            }
        }



        int dis[] = new int[V];
        Arrays.fill( dis , Integer.MAX_VALUE );
        dis[ 0 ] = 0 ;
        while ( !st.isEmpty() )
        {
            int node = st.pop();

            for( pair p : adj.get(node) )
            {
                if( dis[node] + p.w < dis[p.v ] )
                {
                    dis[ p.v] = dis[node] + p.w;
                }
            }
        }

        System.out.println( "shortest distance for all the nodes using topological sorting is : ");
        for( int i : dis )
        {
            System.out.print( i + " ");
        }

    }
}
