package STRIVER_SERIES.DYNAMIC_PROGRAMMING.DP_ON_MCM;

import java.util.Arrays;

public class DP48_matrix_chain_multiplication {

    static int mcm( int i , int j , int[] arr , int[][] dp )
    {
        if( i==j ) return 0;

        if( dp[i][j]!=-1 ) return dp[i][j];
        
        int mini = Integer.MAX_VALUE;
        for (int k = i; k <= j-1 ; k++) {
            int ans = arr[i-1]*arr[k]*arr[j]  + mcm( i , k , arr , dp  ) + mcm( k+1 , j , arr , dp );
            mini = Math.min( mini , ans );
        }

        return dp[i][j] = mini ;
    }
    public static void main ( String[] args ) {

        int[] arr = {10, 20, 30, 40, 50};
        int n = arr.length;

        int dp[][] = new int[n][n];
        for (int[] i : dp)
        {
            Arrays.fill( i , -1 );
        }

        System.out.println("the minimum no. of operations : "+ mcm( 1 , n-1 , arr , dp ));
    }
}
