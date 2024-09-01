public class 최대수익 {
    
    public int maxProfit(int k, int[] prices) {
        if (prices.length == 0 || k == 0) return 0;
        
        int[] buy = new int[k + 1];
        int[] sell = new int[k + 1];
        
        // 초기화: buy 배열은 매우 큰 값을 넣어둠
        for (int i = 0; i <= k; i++) {
            buy[i] = Integer.MIN_VALUE;
        }
        
        // 가격 배열 순회
        for (int price : prices) {
            for (int t = 1; t <= k; t++) {
                // t번째 거래에서 주식을 매수했을 때의 최소 비용
                buy[t] = Math.max(buy[t], sell[t - 1] - price);
                // t번째 거래에서 주식을 매도했을 때의 최대 이익
                sell[t] = Math.max(sell[t], buy[t] + price);
                System.out.println("Buy[t] = " + buy[t] + " // Sell[t] = " + sell[t]);
            }

            System.out.println();
        }
        
        return sell[k];
    }

    public static void main(String[] args) {
        최대수익 solution = new 최대수익();

        // 예제 1
        int[] prices1 = {3, 2, 6, 5, 0, 3};
        int k1 = 2;
        System.out.println("Max Profit: " + solution.maxProfit(k1, prices1)); // 출력: 7

      
    }
}
