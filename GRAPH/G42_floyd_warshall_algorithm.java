package STRIVER_SERIES.GRAPH;

public class G42_floyd_warshall_algorithm {

    public static void main ( String[] args ) {

        int mat[][] =  {{0,1,43},{1,0,6},{0,0,0}};

        //------------------------------------

        int n = mat.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <n; j++) {
                if( mat[i][j]==-1 ) mat[i][j] = 100000000;
                if( i==j ) mat[i][j] = 0;
            }
        }

        for (int via = 0; via < n; via++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j <n; j++) {

                    mat[i][j] = Math.min( mat[i][j] , mat[i][via]+mat[via][j] );

                }
            }
        }

        // conditon for negative cycle
        for (int i = 0; i < n; i++) {
            if( mat[i][i]<0 ) {
                System.out.println("NEGative cycle is present !! ");
                return;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <n; j++) {
                if( mat[i][j]==100000000 ) mat[i][j] = -1;
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }





    }
}
