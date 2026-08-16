class Solution {
    public int maxProfit(int[] prices) {
        int amt=0;
        for(int i=0; i<prices.length; i++){
            for(int j=i+1; j<prices.length; j++){
                if(prices[j]>prices[i]){
                    amt = Math.max(amt, prices[j] - prices[i]);
                }

            }
        }
        return amt;
}}