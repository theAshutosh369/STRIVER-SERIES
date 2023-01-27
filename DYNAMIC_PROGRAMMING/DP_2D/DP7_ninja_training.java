package STRIVER_SERIES.DYNAMIC_PROGRAMMING.DP_2D;

import java.util.Arrays;

public class DP7_ninja_training
{
    static int f( int day , int last , int arr[][] , int dp[][])
    {
        if( day==0 )
        {
            int maxi = 0;
            for (int task = 0; task < 3; task++) {
                if( task!=last )
                {
                   maxi = Math.max( maxi , arr[day][task]) ;
                }
            }
            return dp[day][last] = maxi;
        }

        if( dp[day][last]!=-1 ) return dp[day][last ];

        int maxi = 0 ;
        for (int task = 0; task < 3; task++) {
            if( task!=last )
            {
                int points = arr[day][task] + f( day-1 , task , arr , dp );
                maxi = Math.max( maxi , points ) ;
            }
        }

        return dp[day][last] = maxi;


        // Time Complexity: O(N*4*3)
        //Reason: There are N*4 states and for every state, we are running a for loop iterating three times.
        //Space Complexity: O(N) + O(N*4)
        //Reason: We are using a recursion stack space(O(N)) and a 2D array (again O(N*4)). Therefore total space complexity will be O(N) + O(N) ≈ O(N)
    }

    static void tabulation(int n, int[][] arr) {


        int[][] dp = new int[n][4];
        dp[0][0] = Math.max(arr[0][1], arr[0][2]);
        dp[0][1] = Math.max(arr[0][0], arr[0][2]);
        dp[0][2] = Math.max(arr[0][0], arr[0][1]);
        dp[0][3] = Math.max(arr[0][0], Math.max(arr[0][1], arr[0][2]));

        for (int day = 1; day < n; day++) {
            for (int last = 0; last < 4; last++) {

                for (int task = 0; task <= 2; task++) {
                    if (task != last) {
                        int activity = arr[day][task] + dp[day - 1][task];
                        dp[day][last] = Math.max(dp[day][last], activity);
                    }
                }

            }
        }

        System.out.println( dp[n - 1][3] );

//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < 4; j++) {
//                System.out.print( dp[i][j] + " ");
//            }
//            System.out.println();
//        }
//


    }


    static void optimized( int arr[][] )
    {
        int n = arr[0].length;
        int[] prev = new int[n+1];

        prev[0] = Math.max( arr[0][1] , arr[0][2]);
        prev[1] = Math.max( arr[0][0] , arr[0][2]);
        prev[2] = Math.max( arr[0][1] , arr[0][0]);
        prev[3] = Math.max( arr[0][0] , Math.max( arr[0][1] , arr[0][2]) );

        for (int i = 1; i < n; i++)
        {
            int[] dp = new int[n+1];
            for (int j = 0; j < 4; j++)
            {
                for (int k = 0; k < 3; k++)
                {
                    if( k!=j )
                    {
                        dp[j] = Math.max( dp[j] , arr[i][k]+prev[k]);
                    }
                }
            }
            prev = dp;
        }

        System.out.println( prev[3] );

        // space complexity : O( 4 )
        // time complexity  : O( n*4*3 );
    }




    public static void main ( String[] args ) {

        int arr[][] = {{10,40,70},
                {20,50,80},
                {30,60,90}};
        int n = arr[0].length;

        int dp[][] = new int[n+1][n+1];

        for( int[] i : dp)
        {
            Arrays.fill( i , -1 );
        }


        // recursive solution
        System.out.println(  f( n-1 , 3 , arr , dp ) );

        // memoization / tabulation
        tabulation( n , arr );

        // space optimizated solution
        optimized( arr );

    }
}

// three solutions are there