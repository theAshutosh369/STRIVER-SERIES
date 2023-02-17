package STRIVER_SERIES.GRAPH;

import java.util.ArrayList;
import java.util.Scanner;

public class G12_cycle_detection_undirected_graph_dfs {

    static boolean dfs( int node , int parent , ArrayList<ArrayList<Integer>> arr , int[] vis )
    {
        vis[node] = 1 ;
        ArrayList<Integer> curarr = arr.get( node );
        for (int i = 0; i < curarr.size(); i++) {
            int adj = curarr.get(i);
            if( vis[adj] ==0  )
            {
                if( dfs( adj , node , arr , vis ) ) return true;
            }
            else if( adj!=parent ) return true;
        }
        return false;
    }

    public static void main ( String[] args ) {

        Scanner s  = new Scanner(System.in);
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        int V = 7 , E = 7 ;
        for (int i = 0; i < V; i++) {
            arr.add( new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            int src = s.nextInt();
            int dest = s.nextInt();

            arr.get(src).add(dest);
            arr.get(dest).add(src);
        }

//        -------------------------------

        int vis[] = new int[V];
        for (int i = 0; i < V; i++) {
            if( vis[i] ==0 )
            {
                if( dfs( i , -1 , arr , vis ) ) {
                    System.out.println("true");
                    return;
                }
            }
        }
        System.out.println("false");


    }
}
