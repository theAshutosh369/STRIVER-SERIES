package STRIVER_SERIES.DYNAMIC_PROGRAMMING;

public class DP3_frog_jump {
    static void frog_jump( int n , int[] height )
    {
        int prev = 0;
        int prev2 = 0 ;
        for (int i = 1; i < n; i++)
        {
            int fs = prev + Math.abs( height[i] - height[i-1] );
            int ss = Integer.MAX_VALUE;
            if( i>1 ) ss = prev2 + Math.abs( height[i] - height[i-2]);

            int curi = Math.min( fs , ss );
            prev2 = prev ;
            prev = curi ;
        }

        System.out.println( prev );
    }
    public static void main ( String[] args ) 
    {
        int n = 6;
        int h[] =  {30,10,60,10,60,50};

        frog_jump( n , h );
    }
}
