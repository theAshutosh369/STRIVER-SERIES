package STRIVER_SERIES.DYNAMIC_PROGRAMMING.DP_ON_STOCKS;

import java.util.Arrays;

public class DP37_buy_and_sells_stock_3
{
    static int ans( int i , int buy , int noOfSells , int n ,  int[] arr , int[][][] dp  )
    {
        if( i==n || noOfSells==2 ) return 0;

        if( dp[i][buy][noOfSells] != -1 ) return dp[i][buy][noOfSells];

        int profit = 0 ;
        if( buy == 0 )
        {
            int take = -arr[i] + ans( i+1 , 1 , noOfSells ,  n , arr , dp );
            int notake = ans( i+1 , 0 , noOfSells ,  n , arr , dp  );
            profit = Math.max ( take , notake );
        }
        else{
            int sell = arr[i] + ans( i+1 , 0 , noOfSells+1 ,  n ,  arr , dp );
            int nosell =  ans( i+1 , 1 , noOfSells ,  n , arr , dp  );
            profit = Math.max ( sell , nosell );
        }

        return dp[i][buy][noOfSells] = profit ;
    }

    public static void main ( String[] args ) {

        int arr[] = { 3,3,5,0,0,3,1,4 };
        int n = arr.length;
        int dp[][][] = new int[n][2][2] ;
        for( int[][] i : dp )
        {
            for( int[] j : i )
            {
                Arrays.fill( j , -1 );
            }
        }

        System.out.println(  ans( 0 , 0 , 0 , n ,  arr , dp) );

    }
}
