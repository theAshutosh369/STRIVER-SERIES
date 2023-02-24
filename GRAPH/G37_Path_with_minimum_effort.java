package STRIVER_SERIES.GRAPH;

import java.util.*;

public class G37_Path_with_minimum_effort {


    static class pair{
        int i , j , d ;
        pair( int i , int j , int d )
        {
            this.i = i;
            this.j = j ;
            this.d = d;
        }
    }
    public static void main ( String[] args ) {

        int heights[][] = {{1,2,2},{3,8,2},{5,3,5}};

        //------------------------------------------------------

        int n = heights.length;
        int m = heights[0].length;

        int difference[][] = new int[n][m];
        for ( int[] i : difference) Arrays.fill( i , Integer.MAX_VALUE );
        difference[0][0] = 0;

        PriorityQueue<pair> q = new PriorityQueue<>( (x,y)->x.d -y.d );
        q.add( new pair(0 , 0 , 0 ));

        int ii[] = { 0 , 0 , -1 , 1  };
        int jj[] = { -1 , 1 , 0 , 0  };
        while (!q.isEmpty())
        {
            pair p = q.poll();
            int i = p.i ;
            int j = p.j ;
            int d = p.d ;

            if( i==n-1 && j==m-1 ) {
                System.out.println( d );
                return;
            }

            for (int k = 0; k < 4; k++) {
                int ni = i + ii[k];
                int nj = j + jj[k];

                if( ni>=0 && ni<n && nj>=0 && nj<m )
                {
                    int neweffort = Math.max( d , Math.abs( heights[ni][nj] - heights[i][j] ) );
                    if( neweffort < difference[ni][nj] )
                    {
                        difference[ni][nj] = neweffort;
                        q.add( new pair( ni ,nj , neweffort ));
                    }
                }

            }
        }
        System.out.println( 0 );




    }
}
