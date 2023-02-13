package STRIVER_SERIES.GRAPH;

import java.util.LinkedList;
import java.util.Queue;

public class G10_rotten_oranges {

    static class pair{
        int i , j , t ;
        pair( int i , int j , int t  )
        {
            this.i = i ;
            this.j = j ;
            this.t = t ;
        }
    }

    public static void main ( String[] args ) {


        int[][] arr = {{2,1,1},{0,1,1},{1,0,1}};
        int n = arr.length;
        int m = arr[0].length;


        int tot_time = 0 , fresh = 0 , fresh_to_rotten = 0 ;
        int vis[][] = new int[n][m];
        Queue<pair> q = new LinkedList<>();
        int ii[] = { -1 , 0 , 0 , 1 };
        int jj[] = { 0 , -1 , 1 , 0 };


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if( arr[i][j] ==1 ) fresh++;
                else if( arr[i][j] ==2 ) q.add( new pair(i , j , 0 ));
            }
        }

        while ( !q.isEmpty() )
        {
            int r = q.peek().i;
            int c = q.peek().j;
            int t = q.peek().t;
            q.poll();

            for (int i = 0; i < 4; i++) {
                int nr = r + ii[i];
                int nc = c + jj[i];

                if( nr>=0 && nr<n && nc>=0 && nc<m && arr[nr][nc]==1 && vis[nr][nc]==0 )
                {
                    fresh_to_rotten++;
                    q.add( new pair( nr , nc , t+1 ));
                    tot_time = Math.max( tot_time , t+1 );
                    vis[nr][nc] = 2 ;
                }
            }
        }

        if( fresh==fresh_to_rotten ) System.out.println( tot_time );
        else System.out.println( -1  );






    }
}
