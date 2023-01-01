package STRIVER_SERIES.DYNAMIC_PROGRAMMING.DP_ON_SQUARES;

public class DP56_count_square_submatrices_with_all_ones {

    public static void main ( String[] args ) {

        int mat[][] = {
                {0,1,1,1},
                {1,1,1,1},
                {0,1,1,1}
        };

        int n = mat.length;
        int m = mat[0].length;
        int dp[][] = new int[n][m];
        int sum =0;

        for( int i =0 ; i<m ; i++ )
        {
            dp[0][i] = mat[0][i];
        }
        for( int i =0 ; i<n ; i++ )
        {
            dp[i][0] = mat[i][0];
        }

        for( int i = 1 ; i<n ; i++ )
        {
            for( int j = 1 ; j<m ; j++ )
            {
                if( mat[i][j]==0 ) dp[i][j] = 0;
                else{
                    dp[i][j] = 1 + Math.min( dp[i-1][j-1] , Math.min(  dp[i-1][j] , dp[i][j-1]) );
                }
            }
        }

        for( int i = 0 ; i<n ; i++ )
        {
            for( int j = 0 ; j<m ; j++ )
            {
                sum += dp[i][j];
            }
        }

        System.out.println( sum );

    }
}
