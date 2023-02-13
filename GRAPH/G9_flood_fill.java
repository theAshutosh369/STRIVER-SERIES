package STRIVER_SERIES.GRAPH;

import java.util.LinkedList;
import java.util.Queue;

public class G9_flood_fill {


    static void dfs( int i , int j , int srccolor , int color , int n , int m , int[][] arr )
    {
        if(i<0 || i>=n || j<0 || j>=m ) return;
        if( arr[i][j]!=srccolor || arr[i][j] ==color ) return;

        arr[i][j] = color;

        dfs( i-1 , j , srccolor , color , n , m , arr  );
        dfs( i+1 , j , srccolor , color , n , m , arr  );
        dfs( i , j-1 , srccolor , color , n , m , arr  );
        dfs( i , j+1 , srccolor , color , n , m , arr  );

    }

    public static void main ( String[] args ) {

        int[][] image = {{0,0,0},{0,0,0}};
        int sr = 1 , sc = 0 , color = 2 ;
        int srccolor = image[sr][sc];

        int n = image.length ;
        int m = image[0].length ;
//        int vis[][] = new int[n][m];

        dfs( sr , sc , srccolor ,  color ,  n , m , image  );

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print( image[i][j] + " ");
            }
            System.out.println();
        }



    }
}
