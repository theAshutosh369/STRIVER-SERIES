package STRIVER_SERIES.GRAPH;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class G22_kahns_algorithm {

    public static void main ( String[] args ) {

        int V = 7;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++)
        {
            adj.add( new ArrayList<>() );
        }
        adj.get(1).add(3);
        adj.get(2).add(3);
        adj.get(4).add(1);
        adj.get(4).add(0);
        adj.get(5).add(0);
        adj.get(5).add(2);


        //--------------------------------------------

        int indegree[] = new int[V];
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < adj.get(i).size(); j++) {
                indegree[ adj.get(i).get(j) ]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for( int i = 0 ; i<V ; i++ )
        {
            if( indegree[i] ==0 ) q.add(i);
            System.out.print( indegree[i] +" " );
        }
        System.out.println();

        System.out.println( q );


        ArrayList<Integer> ans = new ArrayList<>();
        while ( !q.isEmpty())
        {
            int i = q.poll();
            ans.add(i);

            for( int k : adj.get(i))
            {
                indegree[k]--;
                if( indegree[k]==0 ) q.add(k);
            }
        }

        System.out.println( ans );

    }
}
