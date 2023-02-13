package STRIVER_SERIES.GRAPH;

public class G7_number_of_provinces {


    static void dfs( int i , int[] vis , int[][] arr )
    {
        vis[i] = 1;

        for( int j = 0 ; j<arr[0].length ; j++ )
        {
            if( arr[i][j] == 1 && vis[j]==0 )
            {
                dfs( j , vis , arr );
            }
        }

    }

    public static void main ( String[] args ) {


        int arr[][] = {{1,0,0},{0,1,0},{0,0,1}};
        int n = arr.length;
        int vis[] = new int[n ];
        int ans = 0 ;

        for( int i = 0 ; i<n ; i++  )
        {
            if( vis[i]==0 ){
                ans++;
                dfs( i , vis , arr );
            }
        }

        System.out.println( ans );


    }
}
