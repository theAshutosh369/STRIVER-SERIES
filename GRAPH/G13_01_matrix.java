package STRIVER_SERIES.GRAPH;

import java.util.LinkedList;
import java.util.Queue;

public class G13_01_matrix {


    static class pair{
        int row , col , dis;
        pair( int row , int col , int dis )
        {
            this.row = row;
            this.col = col;
            this.dis = dis;
        }
    }

    public static void main ( String[] args ) {

        int mat[][] = { { 0,0,0 }, { 0,1,0 } , { 1,1,1 }};


        int n = mat.length;
        int m = mat[0].length;
        int vis[][] = new int[n][m] ;
        int ans[][] = new int[n][m];

        Queue<pair > q = new LinkedList<>();



        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < m  ; j++) {
                if( mat[i][j] == 0 ) {
                    q.add( new pair( i , j , 0 ));
                    vis[i][j] = 1;
                }
            }
        }



        int ii[] = { -1 , 0 , 0 , 1 };
        int jj[] = { 0 , -1 , 1 , 0 };

        while (!q.isEmpty() )
        {
            int r = q.peek().row;
            int c = q.peek().col;
            int d = q.peek().dis;
            q.poll();

            ans[r][c] = d;
            for (int k = 0; k < 4; k++) {
                int nr = r + ii[k];
                int nc = c + jj[k];

                if( nr>=0 && nr<n && nc>=0 && nc<m && vis[nr][nc]==0 )
                {
                    vis[nr][nc]=1;
                    q.add( new pair(nr , nc , d+1) );
                }
            }
        }


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print( ans[i][j] + " ");
            }
            System.out.println();
        }

    }
}

