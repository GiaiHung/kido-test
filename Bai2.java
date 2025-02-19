/* 
Bài 2: Cho 1 mảng prices, prices[i] là giá để mua vàng vào ngày thứ i. Mục tiêu đặt ra là tối đa hóa lợi nhuận có được bằng việc mua đáy bán đỉnh. Xác định lợi nhuận tối đa có được bằng việc chọn một ngày mua và một ngày bán trong tương lai.
VD:
   Input: prices = [7,1,5,3,6,4]
   Output: 5 (Mua ngày 2 (price = 1) và bán ngày 5 (price = 6), profit= 6 - 1 = 5)
- Nâng cao: Có thể chọn nhiều lần mua và bán. Tuy nhiên tại một thời điểm chỉ được phép giữ 1 đơn vị vàng (nghĩa là phải bán trước khi mua lần tiếp theo).
*/

public class Bai2 {
    public static void main(String[] args) {
        int[] test = new int[] { 7, 1, 5, 3, 6, 4 };
        int maxProfit = findMaxProfit(test);
        int maxProfitMultiple = findMaxProfitMultiple(test);
        System.out.println("Max profit: " + maxProfit);
        System.out.println("Max profit multiple: " + maxProfitMultiple);
    }

    private static int findMaxProfit(int[] prices) {
        // Check null
        if (prices == null || prices.length < 2) {
            return 0;
        }

        // Initialize value
        int min_price = Integer.MAX_VALUE;
        int max_profit = 0;

        // Loop for identifying cheapest price and maximum profit
        for (int price : prices) {
            if (price < min_price) {
                min_price = price;
            } else {
                max_profit = Math.max(max_profit, price - min_price);
            }
        }

        return max_profit;
    }

    private static int findMaxProfitMultiple(int[] prices) {
        int totalProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            // If first element, skip
            if (i != 0) {
                // Find any fluctuation and make profit
                if (prices[i] > prices[i - 1]) {
                    totalProfit += prices[i] - prices[i - 1];
                }
            }
        }
        return totalProfit;
    }
}
