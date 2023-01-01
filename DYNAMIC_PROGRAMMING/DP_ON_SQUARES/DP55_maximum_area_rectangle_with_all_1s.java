package STRIVER_SERIES.DYNAMIC_PROGRAMMING.DP_ON_SQUARES;

import javax.lang.model.type.ArrayType;
import java.util.Arrays;
import java.util.Stack;

public class DP55_maximum_area_rectangle_with_all_1s {
    static int[] previous_smaller ( int[] arr )
    {
        int n  = arr.length;
        int ans[] = new int[n];
        Stack<Integer> s  = new Stack<>();

        for (int i = 0; i < n; i++) {
            while ( !s.isEmpty() && arr[s.peek()]>=arr[i] )
            {
                s.pop();
            }

            if( s.isEmpty() ) ans[i] = -1;
            else ans[i] = s.peek();

            s.add( i );
        }

        return ans;
    }
    static int[] next_smaller ( int[] arr )
    {
        int n  = arr.length;
        int ans[] = new int[n];
        Stack<Integer> s  = new Stack<>();

        for (int i = n-1; i>=0 ; i--) {
            while ( !s.isEmpty() && arr[s.peek()]>=arr[i] )
            {
                s.pop();
            }

            if( s.isEmpty() ) ans[i] = n;
            else ans[i] = s.peek();

            s.add( i );
        }

        return ans;
    }

    public static void main ( String[] args ) {

        int mat[][] = {
                {1,0,1,0,0},
                {1,0,1,1,1},
                {1,1,1,1,1},
                {1,0,0,1,0}
        };

        int n = mat.length;
        int m = mat[0].length;
        int max = Integer.MIN_VALUE ;
        int[] arr = new int[m] ;
        Arrays.fill(arr , 0 );

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < m; j++) {
                if( mat[i][j]==1 ) arr[j] = arr[j]+1 ;
                else arr[j]=0 ;
            }

            int[] prev = previous_smaller( arr );
            int[] next = next_smaller( arr );

            for (int j = 0; j < n; j++) {
                int area = ( next[j]-prev[j]-1 ) * arr[j];
                max = Math.max( max , area );
            }

        }

        System.out.println( max );




    }
}
