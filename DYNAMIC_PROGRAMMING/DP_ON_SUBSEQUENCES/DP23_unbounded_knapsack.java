package STRIVER_SERIES.DYNAMIC_PROGRAMMING.DP_ON_SUBSEQUENCES;

import java.util.Arrays;

public class DP23_unbounded_knapsack {

    static int unbounded_knapsack( int i , int K , int n , int dp[][] , int w[] , int p[])
    {
        // base case
        if( i==0 ) {
            return ( K/w[0] )*p[0] ;
        }

        // dp
        if( dp[i][K] != -1 ) return dp[i][K];

        // logic
        int nottaken =  unbounded_knapsack( i-1 , K , n, dp , w, p );
        int taken = Integer.MIN_VALUE;
        if( K>= w[i]){
            taken = p[i] + unbounded_knapsack( i , K-w[i] , n , dp , w, p );
        }

        return dp[i][K] = Math.max( taken , nottaken );
    }
    public static void main ( String[] args ) {

        int w[] = {2,4,6};
        int p[] = {5,11,13};
        int n = w.length;
        int k = 10;

        int dp[][] = new int[n+1][k+1];
        for( int[] i : dp)
        {
            Arrays.fill( i , -1 );
        }

        int anss =  unbounded_knapsack( n-1 , k , n , dp ,w ,p  );

        System.out.println( anss );
    }
}
