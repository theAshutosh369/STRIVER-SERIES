package STRIVER_SERIES.DYNAMIC_PROGRAMMING.DP_ON_MCM;

import java.util.Arrays;

public class DP50_minimum_cost_to_cut_stick {

    static int cost( int i ,int j , int[] cuts , int[][] dp )
    {
        if( i>j ) return 0 ;
        if( dp[i][j]!=-1 ) return dp[i][j];

        int mini = Integer.MAX_VALUE;
        for (int k = i; k <= j ; k++) {
            int ans = cuts[j+1] - cuts[i-1] + cost( i , k-1 , cuts , dp ) + cost( k+1 , j , cuts , dp  );
            mini = Math.min( mini , ans );
        }

        return dp[i][j] = mini ;
    }
    public static void main ( String[] args ) {

        int[] cuts = {3,5,1,4};
        int len_of_stick = 7 ;
        int cuts_len = cuts.length;

        int[] new_cuts = new int[cuts_len+2 ];
        for (int i = 1; i < cuts_len+1; i++) {
            new_cuts[i] = cuts[i-1];
        }
        new_cuts[cuts_len+1] = len_of_stick;

        Arrays.sort( new_cuts );



        int dp[][] = new int[cuts_len+1][cuts_len+1];
        for (int[] i : dp)
        {
            Arrays.fill( i , -1 );
        }
        System.out.println("Minimum cost : " + cost( 1 , cuts_len , new_cuts , dp ));

    }
}
