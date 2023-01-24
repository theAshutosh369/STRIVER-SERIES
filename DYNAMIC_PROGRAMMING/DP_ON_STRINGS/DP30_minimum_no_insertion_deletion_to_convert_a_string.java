package STRIVER_SERIES.DYNAMIC_PROGRAMMING.DP_ON_STRINGS;

import java.util.Arrays;

public class DP30_minimum_no_insertion_deletion_to_convert_a_string {

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

        String s1 = "abcd";
        String s2 = "anc";

        int n = s1.length();
        int m = s2.length();

        int dp[][] = new int[n][m];
        for( int[] i : dp )
        {
            Arrays.fill( i , -1 );
        }

        int lcs = lcs( s1, s2 , n-1 , m-1 , dp );

        System.out.println("Minimum number of characters requered to delete and insert to string to convet it to s2 : " + (n-lcs+m-lcs)  );


    }

}
