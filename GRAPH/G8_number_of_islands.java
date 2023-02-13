package STRIVER_SERIES.GRAPH;

import jdk.dynalink.beans.StaticClass;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class G8_number_of_islands {


    static class pair{
        int i , j;
        pair( int i , int j )
        {
            this.i = i ;
            this.j = j ;
        }
    }
    static void bfs( int i , int j , int n , int m , int[][] grid , int[][] vis )
    {

        Queue<pair> q = new LinkedList<>();
        q.add( new pair(i,j) );
        vis[i][j] = 1;

        while ( !q.isEmpty() )
        {
            int r = q.peek().i;
            int c = q.peek().j;
            q.poll();


            for (int ii = -1; ii <=1; ii++) {
                for (int jj = -1; jj <=1 ; jj++) {
                    int newr = r+ii;
                    int newc = c+jj;

                    if( newr>=0 && newr<n && newc>=0 && newc<m && grid[newr][newc]==1 && vis[newr][newc]==0 )
                    {
                        vis[newr][newc] = 1;
                        q.add( new pair( newr , newc ));
                    }

                }
            }
        }


    }
    public static void main ( String[] args ) {

        int[][] grid =  {{0,1},{1,0},{1,1},{1,0}};
        int n = grid.length;
        int m = grid[0].length;
        int vis[][] = new int[n][m];
        int ans = 0;


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if( grid[i][j]==1 && vis[i][j]==0 )
                {
                    ans++;
                    bfs( i , j ,  n , m ,  grid , vis );
                }
            }
        }
        System.out.println( ans );

    }
}
