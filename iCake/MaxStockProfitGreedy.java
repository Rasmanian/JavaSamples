class MaxStockProfitGreedy {
    
    // O of N sq and space is O of 1 space 
    public static int getMaxProfit(int[] prices) {
        
        int maxProfit = 0;
        
        
        for (int i = prices.length - 1; i > 0; i--)
        {
            for (int j = i - 1; j >= 0; j--)
            {
                int profit = prices[i] - prices[j];
                if (profit > 0 && profit > maxProfit)
                {
                    maxProfit = profit;
                }
            }
        }
        return maxProfit;
    }
    
    
    // GREEDY APPRAOCH with O of N (1 loop) and O of 1 space 
    
    // Get greedy by assuming the first index as the MIN price. 
    // Find profits against the min price starting with the second index.
    // And if you encounter another min price thats smaller than this, set that as MIN price
    
    public static int getMaxProfitGreedy(int[] prices) {
        int minPrice = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++)
        {
            maxProfit = Math.max(prices[i] - minPrice, maxProfit);
            
            // check and reset Min Price
            minPrice = Math.min(minPrice, prices[i]);
        }
        
        return maxProfit;
        
    }
    
    
    public static void main(String[] args) {
        // run your function through some test cases here
        // remember: debugging is half the battle!
        String testInput = "test input";
        System.out.println(getMaxProfit(new int[]{10, 7, 5, 8, 11, 9}));
        System.out.println(getMaxProfitGreedy(new int[]{10, 7, 5, 8, 11, 9}));
        
    }
}