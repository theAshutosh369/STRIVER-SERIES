package STRIVER_SERIES.DYNAMIC_PROGRAMMING.DP_ON_STOCKS;

import java.util.Arrays;

public class DP38_buy_and_sell_stock_4 {
    static int ans( int i , int buy , int noOfSells , int n ,  int[] arr , int[][][] dp  )
    {
        if( i==n || noOfSells==0 ) return 0;

        if( dp[i][buy][noOfSells] != -1 ) return dp[i][buy][noOfSells];

        int profit = 0 ;
        if( buy == 0 )
        {
            int take = -arr[i] + ans( i+1 , 1 , noOfSells ,  n , arr , dp );
            int notake = ans( i+1 , 0 , noOfSells ,  n , arr , dp  );
            profit = Math.max ( take , notake );
        }
        else{
            int sell = arr[i] + ans( i+1 , 0 , noOfSells-1 ,  n ,  arr , dp );
            int nosell =  ans( i+1 , 1 , noOfSells ,  n , arr , dp  );
            profit = Math.max ( sell , nosell );
        }

        return dp[i][buy][noOfSells] = profit ;
    }

    public static void main ( String[] args ) {
        int arr[] = { 3,2,6,5,0,3 };
        int k = 2;
        int n = arr.length;
        int dp[][][] = new int[n][2][k+1] ;
        for( int[][] i : dp )
        {
            for( int[] j : i )
            {
                Arrays.fill( j , -1 );
            }
        }

        System.out.println( ans( 0 , 0 , k , n ,  arr , dp) );

    }
}
