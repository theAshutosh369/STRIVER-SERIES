package STRIVER_SERIES.DYNAMIC_PROGRAMMING.DP_ON_STRINGS;

import java.util.Arrays;

public class DP32_Distinct_subsequences {
    static int ans( String s1 , String s2 , int i , int j , int[][] dp )
    {
        if( j<0 ) return 1 ;
        if( i<0 ) return  0;
        if( dp[i][j]!=-1 ) return dp[i][j];

        if( s1.charAt(i)==s2.charAt(j) )
        {
            int leaveone = ans( s1, s2 , i-1 , j-1 , dp );
            int stay = ans( s1 , s2 , i-1 , j , dp );

            return dp[i][j] = leaveone+stay;

        }
        else {
            return dp[i][j] = ans(s1, s2 , i-1 , j , dp );
        }
    }
    public static void main ( String[] args ) {

        String s1 = "babgbag";
        String s2 = "bag";

        int n = s1.length();
        int m = s2.length();

        int dp[][] = new int[n][m];
        for( int[] i: dp )
        {
            Arrays.fill( i , -1 );
        }

        System.out.println(" Number of distinct subsequences : " + ans( s1 , s2 , n-1 , m-1 , dp ));
    }
}
