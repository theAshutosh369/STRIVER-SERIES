package STRIVER_SERIES.DYNAMIC_PROGRAMMING.DP_ON_SUBSEQUENCES;

import java.util.Arrays;

public class DP22_coin_change_2 {

    static int minimumCoins( int i , int k , int dp[][] , int arr[])
    {
        // base case
        if( k==0 ) return 1;
        if( i==0 )
        {
            if( k%arr[0] ==0  ) return 1;
            else return 0 ;
        }

        //dp
        if( dp[i][k] != -1 ) return  dp[i][k];

        // logic
        int nottaken = minimumCoins( i-1 , k , dp , arr );

        int taken = 0;
        if( arr[i]<= k )
        {
            taken =  minimumCoins( i , k-arr[i] , dp ,arr );
        }

        return dp[i][k] = nottaken + taken ;

    }

    public static void main ( String[] args ) {
        int arr[] = {1,2,3};
        int target = 4;
        int n = arr.length;

        int dp[][] = new int[n+1][target+1];
        for( int[] i : dp)
        {
            Arrays.fill( i , -1 );
        }

        int anss =  minimumCoins( n-1 , target , dp ,arr );
        System.out.println( anss );
    }



}
