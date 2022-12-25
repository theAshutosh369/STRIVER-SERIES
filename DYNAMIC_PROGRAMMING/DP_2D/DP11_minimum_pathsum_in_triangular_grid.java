package STRIVER_SERIES.DYNAMIC_PROGRAMMING.DP_2D;

import java.util.Arrays;

public class DP11_minimum_pathsum_in_triangular_grid
{
    static int minpath( int i , int j , int n , int[][] dp ,int arr[][])
    {
        
       if( i==n-1 ) return arr[i][j];
       if( dp[i][j] != -1 ) return dp[i][j];
        
        int down = arr[i][j] + minpath( i+1 , j , n , dp , arr );
        int down_right = arr[i][j] + minpath( i+1 , j+1 , n , dp , arr );
        

        return dp[i][j] = Math.min( down , down_right );
    }
    public static void main ( String[] args )
    {
        int arr[][] = {{1},
                       {2,3},
                       {3,6,7},
                       {8,9,6,10}};

        int n = arr.length;
        int m = arr[n-1].length;
        int dp[][] = new int[n][m];
        for( int[] i : dp)
        {
            Arrays.fill( i , - 1);
        }

        System.out.println( minpath( 0 , 0 , n, dp , arr ));

//
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                System.out.print( dp[i][j] + " ");
//            }
//            System.out.println();
//        }

    }
}
