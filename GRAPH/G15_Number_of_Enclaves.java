package STRIVER_SERIES.GRAPH;


public class G15_Number_of_Enclaves {

    static void dfs( int i , int j , int n , int m , int[][] arr , int[][] vis )
    {
        vis[i][j] = 1;

        int ii[] = { -1 , 1 , 0 ,0 };
        int jj[] = { 0 , 0 , -1 , 1 };

        for( int k = 0 ; k<4 ; k++ )
        {
            int r = i+ii[k];
            int c = j+jj[k];

            if( r>=0 && r<n && c>=0 && c<m && vis[r][c]==0 && arr[r][c]==1 )
            {
                dfs( r ,c , n ,m , arr , vis );
            }
        }

    }
    public static void main ( String[] args ) {

        int[][] grid = {{0,0,0,0},{1,0,1,0},{0,1,1,0},{0,0,0,0}};
        int n = grid.length;
        int m = grid[0].length;

        int[][]  vis = new int[n][m];

        for( int i= 0 ; i<n ; i++ )
        {
            for( int j = 0 ; j<m ; j++ )
            {
                if( (i==0 || j==0 || i==n-1 || j==m-1) && ( grid[i][j]==1 && vis[i][j]==0 ) )
                {
                    dfs( i , j , n ,m , grid, vis );
                }
            }
        }

        int c=0;
        for( int i= 0 ; i<n ; i++ )
        {
            for( int j = 0 ; j<m ; j++ )
            {
                if( grid[i][j]==1 && vis[i][j]==0 )
                {
                    c++;
                }
            }
        }

        System.out.println( c );
    }
}
