package STRIVER_SERIES.DYNAMIC_PROGRAMMING.DP_ON_SUBSEQUENCES;

import java.util.Arrays;

public class DP20_minimum_coins {

    static int  minimumCoins( int i , int k , int dp[][] , int arr[])
    {
        // base case
        if( i==0 )
        {
            if( k%arr[0] ==0  ) return k/arr[0];
            else return Integer.MAX_VALUE  ;
        }

        //dp
        if( dp[i][k] != -1 ) return  dp[i][k];

        // logic
        int nottaken = minimumCoins( i-1 , k , dp , arr );

        int taken = Integer.MAX_VALUE;
        if( arr[i]<= k )
        {
            taken = 1 +  minimumCoins( i , k-arr[i] , dp ,arr );
        }

        return dp[i][k] = Math.min( nottaken , taken );

    }
    public static void main ( String[] args ) {
        int arr[] = {1,2,3};
        int n = arr.length;
        int k = 7;

        int dp[][] = new int[n+1][k+1];
        for( int[] i : dp)
        {
            Arrays.fill( i , -1 );
        }

        int anss =  minimumCoins( n-1 , k , dp ,arr );

        if( anss==1000000000 ) System.out.println( -1 );
        else System.out.println( anss );

    }
}
