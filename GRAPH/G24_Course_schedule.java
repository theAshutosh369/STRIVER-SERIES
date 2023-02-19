package STRIVER_SERIES.GRAPH;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class G24_Course_schedule {

    public static void main ( String[] args ) {

        int V = 2;
        int prerequisites[][] = {{1,0}};

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++)
        {
            adj.add( new ArrayList<>() );
        }

        int m = prerequisites.length;
        for( int i=0  ; i<m ; i++ )
        {
            for( int j =0 ; j<2 ; j++  )
            {
                adj.get( prerequisites[i][1] ).add( prerequisites[i][0] );
            }
        }

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
        }


        ArrayList<Integer> ans = new ArrayList<>();
        while ( !q.isEmpty()) {
            int i = q.poll();
            ans.add(i);

            for (int k : adj.get(i)) {
                indegree[k]--;
                if (indegree[k] == 0) q.add(k);
            }

        }

        System.out.println( ans );

        if( ans.size()==V ) System.out.println("Finishes all courses ! ");
        else System.out.println("Can't finish all the courses !! ");

    }
}
