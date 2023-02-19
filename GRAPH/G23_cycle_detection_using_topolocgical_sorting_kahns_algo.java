package STRIVER_SERIES.GRAPH;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class G23_cycle_detection_using_topolocgical_sorting_kahns_algo {

    public static void main ( String[] args ) {

        Scanner s  = new Scanner(System.in);
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int V = 3 , E = 2 ;
        for (int i = 0; i < V; i++) {
            adj.add( new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            int src = s.nextInt();
            int dest = s.nextInt();

            adj.get(src).add(dest);
        }

        //-------------------------------------------------------


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

        if( ans.size()==V ) System.out.println("No cycle is present");
        else System.out.println("Cycle is present ");



    }
}
