package STRIVER_SERIES.DYNAMIC_PROGRAMMING;

import java.util.Arrays;

public class DP6_house_robber {
    static int f( int i , int arr[] , int dp[] )
    {
        if( i == 0 )    return arr[0];
        if( i<0 )       return 0;
        if( dp[i]!=-1 ) return dp[i];

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
        long one = f(a1.length-1 , a1 , dp );

        Arrays.fill( dp , -1 );
        long two = f(a2.length-1 , a2 , dp );

        System.out.println( Math.max(  one ,two ));
    }
    public static void main ( String[] args )
    {
        int[] arr = { 1,5,1,2,6 };
        int n = 5;
        house_robber( n , arr );
    }
}
