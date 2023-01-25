package STRIVER_SERIES.DYNAMIC_PROGRAMMING.DP_1D;

import java.util.Arrays;

public class DP3_frog_jump {
    static void frog_jump( int n , int[] height )
    {
        int prev = 0;
        int prev2 = 0 ;
        for (int i = 1; i < n; i++)
        {
            int fs = prev + Math.abs( height[i] - height[i-1] );
            int ss = Integer.MAX_VALUE;
            if( i>1 ) ss = prev2 + Math.abs( height[i] - height[i-2]);

            int curi = Math.min( fs , ss );
            prev2 = prev ;
            prev = curi ;
        }

        System.out.println( prev );
    }

    static int f( int i , int[] arr , int[] dp )
    {
        if( i==0 ) return 0;
        if( i==1 ) return Math.abs( arr[i]-arr[i-1]);
        if( dp[i]!=-1 ) return dp[i];

        return dp[i] = Math.min( Math.abs(arr[i]-arr[i-1])+f(i-1 ,arr , dp ) ,  Math.abs(arr[i]-arr[i-2])+f(i-2 ,arr , dp  ) );

    }
    public static void main ( String[] args ) 
    {
        int n = 6;
        int h[] =  {30,10,60,10,60,50};

        frog_jump( n , h );

        int[] dp = new int[n];
        Arrays.fill( dp , -1 );
        System.out.println( f(n-1 , h , dp ));
    }
}
