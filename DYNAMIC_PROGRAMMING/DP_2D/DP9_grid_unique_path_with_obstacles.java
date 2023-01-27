package STRIVER_SERIES.DYNAMIC_PROGRAMMING.DP_2D;

import java.util.Arrays;

public class DP9_grid_unique_path_with_obstacles {
    static int paths( int i , int j , int[][] dp , int[][] arr )
    {
        if( i<0 || j<0  ) return 0 ;
        if( arr[i][j]==-1) return 0;
        if( i==0 && j==0  ) return dp[i][j]= 1;
        if( dp[i][j]!=-1 ) return dp[i][j];

        int t , l  ;
        t = paths(  i-1 , j  , dp , arr ) ;
        l = paths(   i , j-1 , dp , arr );

        return dp[i][j] = t+l ;
    }

    static int tabulation( int m , int n , int[][] dp , int[][] arr )
    {
        for (int i = 0; i < m  ; i++)
        {
            for (int j = 0; j < n; j++)
            {

                if(  arr[i][j]==-1) {
                    dp[i][j] = 0;
                    continue;
                }

                if( i==0 && j==0 ) {
                    dp[i][j] = 1;
                    continue;
                }

                int up = 0 , left = 0 ;
                if(i>0 ) up = dp[i-1][j]  ;
                if(j>0 ) left = dp[i][j-1]  ;

                dp[i][j] = up+left;
            }
        }
        return dp[m-1][n-1];
    }


    public static void main ( String[] args )
    {
        int[][] arr = {{0,0,0},
                {0,-1,0},
                {0,0,0}};

        int m = arr.length;
        int n = arr[0].length;

        int[][] dp = new int[m][n];

        for( int[] i : dp )
        {
            Arrays.fill( i , - 1);
        }

        System.out.println( paths( m-1 ,n-1 , dp , arr ));
        System.out.println( tabulation( m , n , dp , arr ));

    }
}
