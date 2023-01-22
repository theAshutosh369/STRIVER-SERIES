package STRIVER_SERIES.DYNAMIC_PROGRAMMING.DP_ON_STRINGS;

import java.util.Arrays;

public class DP26_print_lcs {

    static int lcs( String s1 , String s2 , int n , int m , int[][] dp )
    {
        if( n<0 || m<0 ) return 0 ;

        if( dp[n][m] != -1 ) return dp[n][m];

        if( s1.charAt(n)!=s2.charAt(m) )
        {
            return dp[n][m] = Math.max( lcs(s1 , s2 , n , m-1 , dp ) , lcs( s1 , s2 , n-1 , m , dp ));
        }
        else {
            return dp[n][m] = 1+ lcs( s1 ,s2 , n-1 , m-1 , dp );
        }

    }

    public static void main ( String[] args ) {

        String s1 = "abcde";
        String s2 = "bdgek";

        int n = s1.length();
        int m = s2.length() ;

        int dp[][] = new int[n][m];
        for (int[] i : dp) {
            Arrays.fill( i , -1 );
        }

        int ans = lcs( s1 , s2 , n-1 , m-1 , dp );

        System.out.println( "Longest common subsequences : " + ans );


        // printing logic
        int i =0 ;
        Character[] ch = new Character[ans];
        while (n>0 && m>0)
        {
            if( s1.charAt(n-1)==s2.charAt(m-1))
            {
                ch[i] = s1.charAt(n-1);
                i++;
                n--;
                m--;
            }
            else if( s1.charAt(n-1) > s2.charAt(m-1) ) {
                n--;
            }
            else m--;
        }

        String answer = "";

        for(  int j = ans-1; j >=0  ; j--  ) {
            answer = answer + ch[j];
        }

        System.out.println( answer);



    }
}
