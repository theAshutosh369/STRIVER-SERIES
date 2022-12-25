package STRIVER_SERIES.DYNAMIC_PROGRAMMING.DP_2D;

import java.util.Arrays;

public class DP10_minimum_path_sum_in_grid {
    static int pathsum( int n , int m , int dp[][] , int arr[][])
    {
        if( n==0 && m==0 ) return arr[0][0];
        if( n<0 || m<0 ) return 1000000000;

        if( dp[n][m] != -1 ) return dp[n][m];

        int t = arr[n][m] + pathsum( n-1 , m , dp , arr );
        int l = arr[n][m] + pathsum( n , m-1 , dp , arr );

        return dp[n][m] = Math.min( t , l );
    }
    public static void main ( String[] args ) {

        int arr[][] = {{5,9,6},
                       {11,5,2}};

        int n= arr.length ;
        int m= arr[0].length ;

        int dp[][] = new int[n][m];
        for( int[] i : dp ){
            Arrays.fill( i , -1 );
        }
        System.out.println( pathsum( n-1 , m-1 , dp , arr ));

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print( dp[i][j] + " ");
            }
            System.out.println();
        }
    }
}
