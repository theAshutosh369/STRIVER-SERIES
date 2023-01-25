package STRIVER_SERIES.DYNAMIC_PROGRAMMING.DP_1D;

import java.util.Scanner;

public class DP1_fibonacci_series
{
    public static void main ( String[] args )
    {
        Scanner s = new Scanner(System.in );
        int n =s.nextInt();
        int dp[] = new int[n+1];

        int prev1 = 1 , prev2 = 0 , cur= 0 ;
        for (int i = 2; i <= n ; i++)
        {
            cur = prev1 + prev2 ;
            prev2 = prev1;
            prev1 = cur ;
        }

        System.out.println( cur );
    }
}
