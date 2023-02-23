package STRIVER_SERIES.GRAPH;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class G36_shortest_path_in_maze {

    static class pair{
        int i , j , d ;
        pair( int i , int j , int d )
        {
            this.i = i ;
            this.j = j ;
            this.d = d ;
        }
    }
    public static void main ( String[] args ) {

        int grid[][] = {{1, 1, 1, 1},
                        {1, 1, 0, 1},
                        {1, 1, 1, 1},
                        {1, 1, 0, 0},
                        {1, 0, 0, 1}};

        int si = 0 , sj = 1;
        int di = 2 , dj = 2;
        //------------------------------------

        int n = grid.length;
        int m = grid[0].length;
        int dis[][] = new int[n][m];
        for( int[] i : dis ) Arrays.fill( i , Integer.MAX_VALUE);

        Queue< pair > q = new LinkedList<>();
        if( grid[si][sj]==0 ){
            System.out.println(-1);
            return;
        }
        q.add( new pair( si , sj , 0 ));

        int ii[] = { 0 , 0 , -1 , 1  };
        int jj[] = { -1 , 1 , 0 , 0  };
        while (!q.isEmpty() )
        {
            pair p = q.peek();
            q.poll();
            int i = p.i;
            int j = p.j;
            int d = p.d;

            if( i==di && j==dj ) {
                System.out.println( d );
                return;
            }

            for (int k = 0; k < 4; k++) {
                int ni = i + ii[k];
                int nj = j + jj[k];

                if( ni>=0 && ni<n && nj>=0 && nj<m && grid[ni][nj]==1 && (1+d < dis[ni][nj]) )
                {
                    dis[ni][nj] = 1+d;
                    q.add( new pair( ni , nj , 1+d) );

                    if( ni==di && nj==dj ) {
                        System.out.println( dis[ni][nj] );
                        return;
                    }

                }
            }
        }
        System.out.println(-1 );

    }
}
