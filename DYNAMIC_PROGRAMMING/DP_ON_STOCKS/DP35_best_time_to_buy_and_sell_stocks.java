package STRIVER_SERIES.DYNAMIC_PROGRAMMING.DP_ON_STOCKS;

public class DP35_best_time_to_buy_and_sell_stocks {

    public static void main ( String[] args ) {

        int price[] = { 7,1,5,3,6,4 };
        int n= price.length ;

        int mini = price[0];
        int maxprofit = 0 ;
        for (int i = 1; i < n; i++) {
            int cost = price[i] - mini ;
            maxprofit = Math.max( maxprofit , cost );
            mini = Math.min( price[i] , mini );
        }

        System.out.println( maxprofit );


    }
}














































