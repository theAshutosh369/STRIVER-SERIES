package STRIVER_SERIES.DYNAMIC_PROGRAMMING;

public class DP4_frog_jump_with_k_distances {
    static void frog_jump( int n , int[] height , int k )
    {
        int dp[] = new int[n];
        dp[0] = 0 ;

        for (int i = 1 ; i < n; i++) {
            int min_steps = Integer.MAX_VALUE;
            for (int j = 1; j <= k; j++) {
                if ( i>=j ){
                    int tmp = dp[i-j] + Math.abs( height[i] - height[i-j]);
                    min_steps = Math.min( tmp , min_steps );
                }
            }
            dp[i] = min_steps ;
        }

        System.out.println( dp[n-1] );


    }
    public static void main ( String[] args )
    {
        int n = 6;
        int h[] =  {30,10,60,10,60,50};
        int k = 2;

        frog_jump( n , h , k );
    }
}
