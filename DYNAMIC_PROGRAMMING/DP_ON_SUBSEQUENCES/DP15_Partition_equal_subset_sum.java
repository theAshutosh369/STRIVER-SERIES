package STRIVER_SERIES.DYNAMIC_PROGRAMMING.DP_ON_SUBSEQUENCES;

import java.util.Arrays;

public class DP15_Partition_equal_subset_sum {
    static boolean partition( int i , int k , int[][] dp , int[] arr )
    {
        if( i==0 && arr[0]==k ) return true;
        if( i<=0 ) return false;
        if( arr[i]==k ) return true;

        if( dp[i][k] != -1 ) return dp[i][k]==1 ;

        boolean nottaken = partition( i-1 , k , dp ,arr );
        boolean taken = false;
        if( k>=arr[i] )
        {
            taken = partition( i-1 , k-arr[i] , dp , arr );
            dp[i][k] = taken || nottaken ? 1 : 0;
        }

        return  taken || nottaken ;
    }

    public static void main ( String[] args )
    {
        int[] arr = { 2,3,3,3,10,4,5   };
        int n = arr.length;

        int totalsum = 0;
        for (int i = 0; i < n; i++) {
            totalsum  += arr[i];
        }

        if( totalsum%2==1 ) System.out.println("No partition is possible ! ");
        else {
            int k = totalsum/2;
            int[][] dp = new int[n+1][totalsum+1];
            for( int[] i : dp )
            {
                Arrays.fill( i , -1 );
            }

            System.out.println(  partition( n-1 , totalsum , dp , arr  )  );


            for (int i = 0; i < n+1; i++) {
                for (int j = 0; j < totalsum+1; j++) {
                    System.out.print( dp[i][j] + " ");
                }
                System.out.println( );
            }

        }



    }
}
