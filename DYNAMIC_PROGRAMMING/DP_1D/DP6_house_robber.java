package STRIVER_SERIES.DYNAMIC_PROGRAMMING.DP_1D;

import java.util.Arrays;

public class DP6_house_robber {
    static int f( int i , int arr[] , int dp[] )
    {
        // base case
        if( i == 0 )    return arr[0];
        if( i<0 )       return 0;

        // memoization
        if( dp[i]!=-1 ) return dp[i];

        // concept
        int pick      = arr[i] + f( i-2 , arr , dp );
        int not_pick  =          f( i-1 , arr , dp );

        return dp[i] = Math.max( pick , not_pick );
    }
    static void house_robber( int n , int arr[] )
    {
        int a1[] = new int[n-1];
        int a2[] = new int[n-1];

        for (int i = 0; i < n; i++)
        {
            if( i!=0 ) a1[i-1] = arr[i];
            if( i!=n-1) a2[i] = arr[i];
        }

        int[] dp = new int[n];

        Arrays.fill( dp , -1 );
        long leaveFirstElement = f(a1.length-1 , a1 , dp );

        Arrays.fill( dp , -1 );
        long leaveLastElement = f(a2.length-1 , a2 , dp );

        // return max of the 2 cases
        System.out.println( Math.max(  leaveFirstElement , leaveLastElement ));
    }
    public static void main ( String[] args )
    {
        int[] arr = { 1,5,1,2,6 };
        int n = 5;
        house_robber( n , arr );
    }
}
