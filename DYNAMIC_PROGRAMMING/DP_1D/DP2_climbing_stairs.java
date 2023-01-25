package STRIVER_SERIES.DYNAMIC_PROGRAMMING.DP_1D;

public class DP2_climbing_stairs {
    static int climbStairs( int n )
    {
        if( n<=2 ) return  n ;

        int arr[] = new int[n+1];
        arr[0] = 0 ;
        arr[1] = 1 ;
        arr[2] = 2 ;
        for (int i = 3; i <=n ; i++) {
            arr[i] = arr[i-1] + arr[i-2];
        }
        return arr[n];
    }

    static int rec( int n)
    {
        if( n==0 ) return 0 ;
        if( n==1 ) return 1 ;
        if( n==2 ) return 2 ;

        return rec( n-1)+rec(n-2);
    }
    public static void main ( String[] args ) {

        System.out.println( climbStairs( 8 ) );
        System.out.println( rec( 8 ));
    }
}
