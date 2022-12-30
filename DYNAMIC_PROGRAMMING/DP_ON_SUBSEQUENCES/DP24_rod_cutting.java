package STRIVER_SERIES.DYNAMIC_PROGRAMMING.DP_ON_SUBSEQUENCES;

import java.util.Arrays;

public class DP24_rod_cutting {

    static int ans( int i , int n , int[][] dp , int arr[])
    {
        if( i==0 ){
            return n*arr[0];
        }

        if( dp[i][n]!=-1 ) return dp[i][n];

        int nottaken = ans( i-1 , n , dp , arr );

        int taken = Integer.MIN_VALUE;
        int rodlength = i+1 ;
        if( n>=rodlength )
        {
            taken = arr[i] + ans( i-1 , n-rodlength , dp , arr );
        }

        return dp[i][n] = Math.max( taken , nottaken );
    }


    public static void main ( String[] args ) {

        // recursive solution me gdbd hai to tabulation hi dekhlo accurate solution hai
        int arr[] = {2,5,7,8,10};
        int n = arr.length ;

        int dp[][] = new int[n+1][n+1];
        for( int[] i : dp )
        {
            Arrays.fill( i , -1 );
        }

        System.out.println( ans( n-1 , n , dp , arr ));


        // tabualtion
        int dpp[] = new int[n+1];
        for( int i = 1 ; i<n+1 ; i++ )
        {
            for( int j=0 ; j<i ; j++ )
            {
                dpp[i] = Math.max( dpp[i] , arr[j] + dpp[i-j-1]);
            }
        }
        System.out.println( dpp[n] );
        
        // han evdhch chhota solution ahe tabulation madhe :)



    }
}
