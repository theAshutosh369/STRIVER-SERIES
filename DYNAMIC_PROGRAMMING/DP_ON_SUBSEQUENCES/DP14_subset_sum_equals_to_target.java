package STRIVER_SERIES.DYNAMIC_PROGRAMMING.DP_ON_SUBSEQUENCES;

import java.util.Arrays;

public class DP14_subset_sum_equals_to_target
{
    static boolean ans( int ind ,  int target , int dp[][] , int[] arr )
    {
        // base case
        if( ind <0 ) return false;
        if( ind==0 && arr[0]==target ) return true;
        if( target== 0 ) return true;

        // dp
        if( dp[ind][target] != -1 )
        {
            return dp[ind][target]==1 ;
        }

        boolean notTaken = ans( ind-1 , target , dp , arr );
        boolean taken = false;
        if( target>=arr[ind] )
        {
            taken = ans( ind-1 , target-arr[ind]  ,  dp , arr );
            dp[ind][target] = notTaken || taken ? 1: 0 ;
        }

        return notTaken || taken ;
    }
    public static void main ( String[] args )
    {

        int[] arr = {1,2,3,4};
        int target = 10;
        int n = arr.length;

        int[][] dp = new int[n+1][target+1];
        for (int[] i : dp )
        {
            Arrays.fill( i , -1 );
        }

        System.out.println("Target sum present ? : " + ans( n-1 , target , dp  , arr ));


    }
}
