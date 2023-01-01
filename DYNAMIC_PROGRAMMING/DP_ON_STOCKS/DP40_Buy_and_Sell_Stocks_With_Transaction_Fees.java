package STRIVER_SERIES.DYNAMIC_PROGRAMMING.DP_ON_STOCKS;

import java.util.Arrays;

public class DP40_Buy_and_Sell_Stocks_With_Transaction_Fees {

    static int ans( int i , int buy , int fee , int n ,  int[] arr , int[][] dp  )
    {
        if( i==n ) return 0;

        if( dp[i][buy] != -1 ) return dp[i][buy];

        int profit = 0 ;
        if( buy == 0 )
        {
            int take = -arr[i] + ans( i+1 , 1 , fee , n , arr , dp );
            int notake =  ans( i+1 , 0 , fee , n , arr , dp  );
            profit = Math.max ( take , notake );
        }
        else{
            int sell = arr[i] - fee  + ans( i+1 , 0 , fee , n ,  arr , dp );
            int nosell =   ans( i+1 , 1 , fee,  n , arr , dp  );
            profit = Math.max ( sell , nosell ) ;
        }

        return dp[i][buy] = profit ;
    }
    public static void main ( String[] args ) {

        int arr[] = {1,3,2,8,4,9};
        int fee = 2;
        int n = arr.length;
        int dp[][] = new int[n][2] ;
        for( int[] i : dp )
        {
            Arrays.fill( i , -1 );
        }

        System.out.println(  ans( 0 , 0 , fee , n ,  arr , dp)  );
    }
}
