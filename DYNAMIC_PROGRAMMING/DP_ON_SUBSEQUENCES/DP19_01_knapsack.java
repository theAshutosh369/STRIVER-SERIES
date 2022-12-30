package STRIVER_SERIES.DYNAMIC_PROGRAMMING.DP_ON_SUBSEQUENCES;

import java.util.Arrays;

public class DP19_01_knapsack {

    static int rec_ks( int i , int K , int n , int dp[][] , int w[] , int p[])
    {
        // base case
        if( i==0 ) {
            if( K>=w[i] ) return dp[i][K] = p[i] ;
            else return 0;
        }

        //dp
        if( dp[i][K] != -1 ) return dp[i][K];

        // logic
        int nottaken =  rec_ks( i-1 , K , n, dp , w, p );
        int taken = Integer.MIN_VALUE;
        if( K>= w[i]){
            taken = p[i] + rec_ks( i-1 , K-w[i] , n , dp , w, p );
            dp[i][K] = taken;
        }

        return dp[i][K] = Math.max( taken , nottaken );
    }
    static int ks( int p[] , int w[] , int n , int K )
    {
        int[][] dp = new int[n+1][K+1];
        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < K+1; j++) {

                if( i==0 || j==0 ) dp[i][j] = 0;

                else if( j<w[i-1] ) dp[i][j] = dp[i-1][j];
                else {
                    dp[i][j] = Math.max( dp[i-1][j] , p[i-1]+dp[i-1][j-w[i-1]]);
                }

            }
        }

        return dp[n][K];
    }
    public static void main ( String[] args ) {
        int w[] = {1,2,4,5};
        int p[] = {5,4,8,6};

        int K = 5;
        int n = w.length;

        int[][] dp = new int[n+1][K+1];
        for (int[] i : dp )
        {
            Arrays.fill( i , -1 );
        }

        // tabulation
        System.out.println( ks(p,w,n,K));

        // recursion
        System.out.println( rec_ks( n-1 , K , n, dp ,w ,p ));

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < K + 1; j++) {
                System.out.print( dp[i][j]+" ");
            }
            System.out.println();
        }
    }
}
