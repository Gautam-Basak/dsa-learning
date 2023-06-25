package Arrays.Medium;

public class BestTimeToBuyAndSellStockForMaxProfit {
	
	public static int maxProfit(int[] prices) {
        //Variable to keeptrack of minimum price
        int minPrice = Integer.MAX_VALUE;
        
        //Variable to keep track of maximum profit seen so far.
        int profit = 0;
        for(int i = 0; i < prices.length; i++){
            minPrice = Math.min(minPrice, prices[i]);
            profit = Math.max(profit, (prices[i] - minPrice));
        }
        return profit;
    }

	public static void main(String[] args) {
		System.out.println(maxProfit(new int[]{4,7,1,8,2,9}));

	}

}
