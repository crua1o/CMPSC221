public class test2 {
    public int maxProfit ( int[] prices){
        int sell = 0;
        int buy = Integer.MAX_VALUE;
        for (int price : prices) {
            if (price < buy) {
                buy = price;
            } else {
                sell = Math.max(sell, price - buy);
            }
        }
        return sell;
    }
}