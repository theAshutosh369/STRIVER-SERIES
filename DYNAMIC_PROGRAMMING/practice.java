package STRIVER_SERIES.DYNAMIC_PROGRAMMING;

import java.util.Arrays;

public class practice
{

    static int climbing_stairs( int n , int dp[] )
    {
        if( n<=2 ) return n ;
        if( dp[n] != -1 ) return dp[n];

        dp[n] = climbing_stairs(n-1 , dp ) + climbing_stairs(n-2 , dp );
        return dp[n];
    }

    static int fg( int n , int dp[] , int h[] )
    {
        if( n==0 ) return dp[n] = 0;
        if( n==1 ) return dp[n] = Math.abs( h[n]-h[n-1]);
        if( dp[n]!=-1) return dp[n];

        int one = fg( n-1 , dp , h) + Math.abs( h[n]-h[n-1]);
        int two = fg( n-2 , dp , h) + Math.abs( h[n]-h[n-2]);

        return dp[n] = Math.min( one , two );
    }

    static int fg_K( int n , int dp[] , int h[] , int k )
    {
        if( n==0 ) return dp[n] = 0;
        if( dp[n]!=-1) return dp[n];

        dp[n] = Integer.MAX_VALUE ;
        for (int i = 1; i<=k; i++)
        {
            if( n-i >=0 )
            {
                dp[n]= Math.min( dp[n] , fg_K( n-i , dp , h , k ) + Math.abs( h[n]- h[n-i ]) );
            }
        }

        return dp[n] ;
    }

    static int maxsum( int n , int dp[] , int arr[])
    {
        if( n==0 ) return dp[0] = arr[n];
        if( n<0 ) return 0 ;
        if( dp[n]!=-1 ) return dp[n];

        int pick = arr[n] + maxsum( n-2 , dp , arr );
        int notpick = maxsum( n-1 , dp , arr );

        return dp[n] = Math.max( pick , notpick );
    }
    public static void main ( String[] args )
    {

        int h[] = { 1,5,1,2,6 };
        int n = h.length;
        int dp[] = new int[n+1];
        Arrays.fill( dp , -1 );

        System.out.println(  maxsum( n-1 , dp , h ) );

    }
}
