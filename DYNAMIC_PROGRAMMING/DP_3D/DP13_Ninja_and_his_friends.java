package STRIVER_SERIES.DYNAMIC_PROGRAMMING.DP_3D;

import java.util.Arrays;

public class DP13_Ninja_and_his_friends {

    static int Ans( int i , int j1 , int j2 , int n , int m , int[][][] dp , int[][] arr )
    {
        // base case
        if( j1<0 || j2<0 || j1>=m || j2>=m ) return -1000000000;
        if( i==n-1 )
        {
            if( j1==j2) return arr[i][j1];
            else return arr[i][j1]+arr[i][j2];
        }

        //dp
        if( dp[i][j1][j2]!=-1 ) return dp[i][j1][j2];

        //logic
        int maxi = Integer.MIN_VALUE;

        for (int d1 = -1; d1 <= 1; d1++) {
            for (int d2 =-1; d2 <=1 ; d2++) {

                 int ans;
                 if( j1==j2 ) ans = arr[i][j1] + Ans( i+1 , j1+d1 , j2+d2 , n ,m , dp , arr );
                 else ans = arr[i][j1] + arr[i][j2] + Ans( i+1 , j1+d1 , j2+d2 , n ,m , dp , arr );

                 maxi = Math.max( maxi , ans );

            }
        }

        return dp[i][j1][j2] = maxi ;

    }
    public static void main ( String[] args ) {
        int arr[][] = {
                {2,3,1,2},
                {3,4,2,2},
                {5,6,3,5},
        };


        int n = arr.length;
        int m = arr[0].length;
        int dp[][][] = new int[n][m][m];
        for( int[][] i : dp)
        {
            for ( int[] j : i )
            {
                Arrays.fill( j , - 1);
            }
        }

        System.out.println( Ans( 0 , 0 , m-1 , n , m ,  dp , arr ) );



    }
}
