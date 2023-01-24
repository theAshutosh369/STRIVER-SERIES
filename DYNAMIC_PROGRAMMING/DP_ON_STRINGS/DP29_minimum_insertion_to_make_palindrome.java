package STRIVER_SERIES.DYNAMIC_PROGRAMMING.DP_ON_STRINGS;

import java.util.Arrays;

public class DP29_minimum_insertion_to_make_palindrome {


    static int lcs( String s1 , String s2 , int n , int m , int dp[][] )
    {
        if( n<0 || m<0 ) return 0 ;

        if( dp[n][m]!=-1 ) return dp[n][m];

        if( s1.charAt(n)!=s2.charAt(m) )
        {
            return dp[n][m] = Math.max( lcs(s1,s2,n,m-1,dp) , lcs(s1,s2,n-1,m,dp));
        }
        else{
            return dp[n][m] = 1 + lcs( s1, s2 , n-1 , m-1 , dp );
        }
    }
    public static void main ( String[] args ) {

        String s1 = "abcaa";
        int n = s1.length();

        String s2 = "";
        for (int i = n-1 ; i>=0; i--) {
            s2+= s1.charAt(i);
        }

        int dp[][] = new int[n][n];
        for( int[] i : dp )
        {
            Arrays.fill( i , -1 );
        }

        int lcs = lcs( s1, s2 , n-1 , n-1 , dp );

        System.out.println( n-lcs );

    }
}
