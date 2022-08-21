package leetcode;

public class _121_BestTimeStocks {
    public static void main(String[] args) {
        int[] prices = {7,6,4,3,1};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int maxProfit = 0;

        for(int i: prices){
            min = Math.min(min,i);
            maxProfit = Math.max(i-min, maxProfit);
        }

        return maxProfit;
    }
}
