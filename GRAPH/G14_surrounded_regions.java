package STRIVER_SERIES.GRAPH;

public class G14_surrounded_regions {

    static void dfs( int i , int j , int n , int  m , int[][] vis , char[][] board )
    {
        vis[i][j] =1 ;
        int ii[] = { -1 , +1 , 0 , 0    };
        int jj[] = { 0 , 0  , -1 , +1   };

        for( int k = 0 ; k<4 ; k++ )
        {
            int r = i + ii[k];
            int c = j + jj[k];
            if( r>=0 && r<n && c>=0 && c<m && board[r][c]=='O' && vis[r][c]==0 )
            {
                dfs( r , c , n ,m , vis , board );
            }
        }
    }

    public static void main ( String[] args ) {

        char[][] board = {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};

        int n = board.length;
        int m = board[0].length;
        int vis[][] = new int[n][m];

        for( int i =0 ; i<n ; i++ )
        {
            for( int j = 0 ; j<m ; j++ )
            {
                if( ( i==0 || i==n-1 || j==0 || j==m-1 ) && ( vis[i][j]==0 && board[i][j]=='O' ) )
                {
                    dfs( i , j , n , m ,  vis , board );
                }

            }
        }

        for( int i =0 ; i<n ; i++ )
        {
            for( int j = 0 ; j<m ; j++ )
            {
                if( vis[i][j] == 0 )
                {
                    board[i][j] = 'X';
                }

                System.out.print( board[i][j] + " ");

            }
            System.out.println( );
        }



    }

}
