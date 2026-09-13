class Solution {
    public int maxProfit(int[] arr) {
         // 1. Guard Clauses: Handle edge cases safely.
       // If the array doesn't exist (null) or has no elements,
       // no transactions can ever be made, so the profit is 0.
       if (arr == null || arr.length == 0) {
           return 0;
       }


       // 2. Initialize tracking variables.
       // Set minPrice to the largest possible integer value so that
       // the very first stock price we see will automatically be smaller.
       int minPrice = Integer.MAX_VALUE;
       int maxProfit = 0;


       // 3. One Pass: Walk through the price history from left to right.
       for (int i = 0; i < arr.length; i++) {
           int currentPrice = arr[i];


           if (currentPrice < minPrice) {
               // Scenario A: Found a new valley!
               // We update our lowest buy price for any FUTURE sales.
               minPrice = currentPrice;
           }
           else if (currentPrice - minPrice > maxProfit) {
               // Scenario B: We found a potential sale point.
               // If selling today yields a higher return than our
               // historical record, update the maximum profit.
               maxProfit = currentPrice - minPrice;
           }
       }


       // 4. Return the overall highest profit discovered.
       return maxProfit;


    }
}
