package STRIVER_SERIES.DYNAMIC_PROGRAMMING.DP_ON_SUBSEQUENCES;

import java.util.Arrays;

public class DP17_count_subsets_with_sum_equal_to_k {

    static int ans( int i , int k , int[] arr , int[][] dp )
    {
        if( i<0) return 0;
        if( i==0 && arr[0]==k ) return 1;
        if( k==0 ) return 1;

        if( dp[i][k]!=-1 ) return dp[i][k] ;

        int nottaken = ans( i-1 , k , arr , dp );
        int taken=0  ;
        if( k>=arr[i] ){
            taken = ans( i-1 , k-arr[i] , arr , dp);
            dp[i][k] = taken + nottaken ;
        }

        return dp[i][k] = taken + nottaken;
    }

    public static void main ( String[] args ) {

        int[] arr = {1,2,3,4};
        int target = 3;
        int n = arr.length;

        int[][] dp = new int[n+1][target+1];
        for (int[] i : dp )
        {
            Arrays.fill( i , -1 );
        }

        System.out.println("no of subsets with sum equal to k : " + ans( n-1 , target , arr  , dp ));


    }
}
