class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;          // found a new potential buy point
            } else if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice; // better sell profit found
            }
        }

        return maxProfit;
    }
}