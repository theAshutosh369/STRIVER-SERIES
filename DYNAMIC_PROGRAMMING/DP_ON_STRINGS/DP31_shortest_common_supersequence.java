package STRIVER_SERIES.DYNAMIC_PROGRAMMING.DP_ON_STRINGS;

import java.util.Arrays;

public class DP31_shortest_common_supersequence {

    public static void main ( String[] args ) {

        String s1 = "brute";
        String s2 = "groot";

        int n = s1.length();
        int m = s2.length() ;

        int dp[][] = new int[n+1][m+1];

        for (int i = 1; i <=n; i++) {
            for (int j = 1; j <= m; j++) {
                if( s1.charAt(i-1)==s2.charAt(j-1))
                {
                    dp[i][j] = 1+dp[i-1][j-1];
                }
                else dp[i][j] = Math.max(  dp[i-1][j] , dp[i][j-1] );
            }
        }



        int len = dp[n][m];
        int i = len -1  ;
        String answer = "";
        while( n>0 && m>0 )
        {
            if( s1.charAt(n-1)==s2.charAt(m-1))
            {
                answer+= s1.charAt(n-1);
                i--;
                n--;
                m--;
            }
            else if( dp[n-1][m] > dp[n][m-1] )
            {
                answer+= s1.charAt(n-1);
                n--;
            }
            else {
                answer+= s2.charAt(m-1);
                m--;
            }
        }

        while(n>0){
            answer += s1.charAt(n-1);
            n--;
        }
        while(m>0){
            answer += s2.charAt(m-1);
            m--;
        }

        String rev = "";
        for (int j =answer.length()-1; j>=0; j--) {
            rev+=answer.charAt(j);
        }

        System.out.println( rev );


    }
}
