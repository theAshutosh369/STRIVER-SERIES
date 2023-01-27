package STRIVER_SERIES.DYNAMIC_PROGRAMMING.DP_2D;

import java.util.Arrays;

public class DP12_minimum_falling_path_in_grid {
    static int maxpath( int i , int j , int m , int[][] dp ,int arr[][])
    {
        // base condition
        if(  j<0 || j>=m ) return 0;
        if( i==0   ) return dp[i][j] = arr[0][j];


        if( dp[i][j] != -1 ) return dp[i][j];

        int up              = arr[i][j] + maxpath( i-1 , j , m , dp , arr );
        int left_diagonal   = arr[i][j] + maxpath( i-1 , j-1 , m , dp , arr );
        int right_diagonal  = arr[i][j] + maxpath( i-1 , j+1 , m , dp , arr );


        return dp[i][j] = Math.max( up , Math.max( left_diagonal , right_diagonal ));
    }

    static int minpath( int i , int j , int m , int[][] dp ,int arr[][])
    {
        // base condition
        if(  j<0 || j>=m ) return 1000000000;
        if( i==0   ) return dp[i][j] = arr[0][j];


        if( dp[i][j] != -1 ) return dp[i][j];

        int up              = arr[i][j] + minpath( i-1 , j , m , dp , arr );
        int left_diagonal   = arr[i][j] + minpath( i-1 , j-1 , m , dp , arr );
        int right_diagonal  = arr[i][j] + minpath( i-1 , j+1 , m , dp , arr );


        return dp[i][j] = Math.min( up , Math.min( left_diagonal , right_diagonal ));
    }
    public static void main ( String[] args ) {

        int arr[][] ={ {2,1,3} ,
                       {6,5,4} ,
                       {7,8,9} };

        int n = arr.length;
        int m = arr[0].length;
        int dp[][] = new int[n][m];
        for( int[] i : dp)
        {
            Arrays.fill( i , - 1);
        }

        int Max = Integer.MIN_VALUE ;
        int Min = Integer.MAX_VALUE ;
        for (int i = 0; i < m; i++) {
            Max  = Math.max( Max , maxpath( n-1 , i , m , dp ,arr ));
            Min  = Math.min( Min , minpath( n-1 , i , m , dp ,arr ));
        }
        
        System.out.println("Maximum path sum : " +  Max );
        System.out.println("Minimum path sum : " +  Min );

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print( dp[i][j] + " ");
            }
            System.out.println();
        }



    }
}
