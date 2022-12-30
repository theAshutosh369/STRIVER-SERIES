package STRIVER_SERIES.DYNAMIC_PROGRAMMING.DP_ON_SUBSEQUENCES;

import java.util.Arrays;

public class DP21_target_sum {
    static int subsetSum( int i , int k , int dp[][] , int[] arr )
    {
        if( i<0 ) return 0 ;
        if( i==0 && arr[0]==k ) return 1;
        if( k==0 ) return 1 ;

        if( dp[i][k]!=-1 ) return dp[i][k] ;

        int nottaken = subsetSum( i-1 , k , dp , arr );
        int taken = 0;
        if( arr[i]<=k ){
            taken = subsetSum( i-1 , k-arr[i] , dp , arr );
        }

        return dp[i][k] = taken + nottaken  ;

    }

    public static void main ( String[] args )
    {
        int arr[] = { 1 , 3 , 1 , 2 };
        int n = arr.length;
        int sum = 0 ;
        int target = 3;

        int zeroes = 0;
        for (int i = 0; i < n; i++) {
            sum = sum + arr[i];
            if( arr[i]==0 ) zeroes++;
        }

        int s1 = (sum + target) / 2;

        int dp[][] = new int[n+1][s1+1];
        for( int[] i : dp)
        {
            Arrays.fill( i , -1 );
        }

        System.out.println( (int)Math.pow(2,zeroes)* subsetSum( n-1, s1 , dp , arr ) );


    }
}
