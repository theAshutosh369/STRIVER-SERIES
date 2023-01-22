package STRIVER_SERIES.DYNAMIC_PROGRAMMING.DP_ON_STRINGS;

import java.util.Arrays;

public class DP27_longest_common_substring {


    public static void main ( String[] args ) {

        String s1 = "abcjklp";
        String s2 = "acjkp";

        int n = s1.length();
        int m = s2.length() ;

        int[][] dp = new int[n+1][m+1];


        int ans = 0 ;

        for (int i =1; i <n ; i++)
        {
            for (int j = 1; j <m; j++)
            {
                if( s1.charAt(i-1)==s2.charAt(j-1) )
                {
                    int cur = 1+ dp[i-1][j-1];
                    dp[i][j] = cur;
                    ans = Math.max( ans , cur );

                }
                else {
                    dp[i][j] =0 ;
                }
            }
        }

        System.out.println( ans );


    }
}
