package STRIVER_SERIES.DYNAMIC_PROGRAMMING.DP_ON_MCM;

import java.util.ArrayList;
import java.util.Arrays;

public class DP51_burst_balloons {

    static int ans( int i , int j , ArrayList<Integer> arr , int[][] dp )
    {

        if( i+1==j  ) return 0 ;

        int maxi = Integer.MIN_VALUE;
        if( dp[i][j] != -1 ) return dp[i][j];

        for (int k = i+1; k <j; k++)
        {
            int ans = arr.get(i)*arr.get(k)*arr.get(j)  + ans(i , k , arr , dp ) + ans( k , j , arr , dp );
            maxi = Math.max( maxi , ans );
        }

        return dp[i][j] = maxi ;
    }
    public static void main ( String[] args ) {
        int[] bln = { 3 , 1 , 5, 8 };
        int n= bln.length;

        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        for (int i = 0; i < n ; i++) {
            arr.add( bln[i]);
        }
        arr.add(1);

        int dp[][] = new int[n+2][n+2];
        for (int[] i : dp)
        {
            Arrays.fill( i , -1 );
        }

        System.out.println(" Max coins : " + ans( 0, n+1 , arr , dp ) );

    }
}
