package Arrays;

public class StockProfit {
    public static void main(String[] args) {
        
    }
}

class Solution {
    public int maxProfit(int[] prices) {
        int n= prices.length;
        int minPrice= Integer.MAX_VALUE;
        int maxPro= Integer.MIN_VALUE;

        for(int i=0; i<n; i++){
            if(prices[i]<minPrice) 
            minPrice= Math.min(prices[i], minPrice);

            maxPro= Math.max(maxPro, prices[i]-minPrice);
        }

        return maxPro;
    }
}
