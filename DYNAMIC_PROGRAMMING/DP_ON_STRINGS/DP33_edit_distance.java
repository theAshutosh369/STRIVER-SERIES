package STRIVER_SERIES.DYNAMIC_PROGRAMMING.DP_ON_STRINGS;

import java.util.Arrays;

public class DP33_edit_distance {

    static int ans( String s1 , String s2 , int i , int j , int[][] dp )
    {
        if( i<0 ) return j+1 ;
        if( j<0 ) return  i+1;
        if( dp[i][j]!=-1 ) return dp[i][j];

        if( s1.charAt(i)==s2.charAt(j) )
        {
            return dp[i][j] = ans( s1, s2 , i-1 , j-1 , dp );
        }
        else {
            int insert = ans( s1, s2 , i , j-1 , dp );
            int delete = ans( s1, s2 , i-1 , j , dp );
            int replace = ans( s1, s2 , i-1 , j-1 , dp );
            return dp[i][j] = 1 + Math.min( insert , Math.min( delete , replace ));
        }
    }
    public static void main ( String[] args ) {

        String s1 = "horse";
        String s2 = "ros";

        int n = s1.length();
        int m = s2.length();

        int dp[][] = new int[n][m];
        for( int[] i: dp )
        {
            Arrays.fill( i , -1 );
        }

        System.out.println("Minimum no. of operations requered to convert the s1 to s2 : " + ans( s1, s2 , n-1 , m-1 , dp )) ;


    }
}
