package STRIVER_SERIES.GRAPH;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class G11_cycle_detection_undirected_graph_bfs {

    static class pair{
        int node , parent ;
        pair( int node , int parent )
        {
            this.node = node ;
            this.parent = parent;
        }
    }

    static boolean bfs( int node , ArrayList<ArrayList<Integer>> arr , int[] vis )
    {
        vis[node] = 1 ;
        Queue<pair> q = new LinkedList<>();
        q.add( new pair( node , -1 ));

        while ( !q.isEmpty())
        {
            int cur = q.peek().node;
            int par = q.peek().parent;
            q.poll();

            ArrayList<Integer> curarr = arr.get( cur );
            for (int i = 0; i < curarr.size(); i++) {
                int adj = curarr.get(i);
                if( vis[adj] ==0  )
                {
                    vis[adj ] = 1;
                    q.add( new pair( adj , cur ));
                }
                else if( adj!=par ) return true;
            }
        }
        return false;
    }
    public static void main ( String[] args ) {

        Scanner s  = new Scanner(System.in);
        ArrayList< ArrayList<Integer> > arr = new ArrayList<>();
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
                if( bfs( i , arr , vis ) ) {
                    System.out.println("true");
                    return;
                }
            }
        }
        System.out.println("false");


    }
}
