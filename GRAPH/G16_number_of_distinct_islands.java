package STRIVER_SERIES.GRAPH;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class G16_number_of_distinct_islands {

    static class pair{
        int i , j ;
        pair(int i , int j )
        {
            this.i = i;
            this.j = j;
        }
    }
    static void dfs( int i , int j , int basei , int basec , int n , int m , ArrayList<pair> temp , int[][] arr , int[][] vis )
    {
        vis[i][j]=1 ;
        temp.add( new pair( i-basei , j-basec ));

        int[] ii = { -1 , 1 , 0 , 0 };
        int[] jj = {  0 , 0  , -1 ,1 };

        for (int k = 0; k < 4; k++) {
            int r = i + ii[k];
            int c = j + jj[k];

            if( r>=0 && r<n && c>=0 && c<m && vis[r][c]==0 && arr[r][c]==1 )
            {
                dfs( r , c  , basei , basec , n ,m , temp , arr , vis );
            }
        }

    }
    public static void main ( String[] args ) {

        int grid[][]  = {{1,1,0,0,0},
                        {1,1,0,0,0},
                        {0,0,1,0,0},
                        {0,0,0,1,1}};

        int n = grid.length;
        int m = grid[0].length;
        int vis[][] = new int[n][m];

        Set<ArrayList<pair>> st = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if( vis[i][j]==0 && grid[i][j]==1 )
                {
                    ArrayList<pair> temp = new ArrayList<>();
                    dfs( i , j , i , j , n , m , temp , grid , vis );
                    st.add( temp);
                }

            }
        }

        System.out.println( st.size() );



    }
}
