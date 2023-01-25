package STRIVER_SERIES.DYNAMIC_PROGRAMMING.DP_1D;

import java.util.Arrays;

public class DP5_maximum_sum_subsequence {
    static int f( int i , int arr[] , int dp[] )
    {
        if( i == 0 )    return arr[0];
        if( i<0 )       return 0;
        if( dp[i]!=-1 ) return dp[i];

        int pick      = arr[i] + f( i-2 , arr , dp );
        int not_pick  =          f( i-1 , arr , dp );

        return dp[i] = Math.max( pick , not_pick );
    }
    public static void main ( String[] args )
    {
        int[] arr = { 2 , 1 , 4 , 9 };
        int n = 4;
        int[] dp = new int[n];
        Arrays.fill( arr , -1 );
        System.out.println( f(n-1 , arr, dp) );
    }
}
