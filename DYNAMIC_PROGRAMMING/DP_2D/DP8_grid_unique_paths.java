package STRIVER_SERIES.DYNAMIC_PROGRAMMING.DP_2D;

import java.util.Arrays;

public class DP8_grid_unique_paths {
    static int paths( int i , int j , int dp[][] )
    {
        if( i==0 && j==0  ) return dp[i][j]= 1;
        if( i<0 || j<0  ) return 0 ;
        if( dp[i][j]!=-1 ) return dp[i][j];


        int t = paths(  i-1 , j  , dp ) ;
        int l = paths(   i , j-1 , dp  );

        return dp[i][j] = t+l ;
    }
    static int tabulation( int m , int n , int dp[][] )
    {
        for (int i = 0; i < m  ; i++) {
            for (int j = 0; j < n; j++) {

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


    public static void main ( String[] args ) {

        int m = 3 , n = 2 ;
        int dp[][] = new int[m][n];
        for( int[] i : dp )
        {
            Arrays.fill( i , - 1);
        }

        // recursion
        //System.out.println( paths( m-1 , n-1 , dp ) );

        // tabulation
        System.out.println( tabulation(m , n  , dp ));

    }
}
