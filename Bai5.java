public class Bai5 {
    public static void main(String[] args) {
        int[] test = { 1, 0, 2 };
        int candiesRequired = minCandies(test);
        System.out.println("Minimum cadies required: " + candiesRequired);
    }

    public static int minCandies(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];

        // Mỗi bé nhận ít nhất một viên kẹo
        for (int i = 0; i < n; i++) {
            candies[i] = 1;
        }

        // Duyệt từ trái sang phải
        // Duyệt từ phải sang trái (làm tương tự)
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                if (ratings[i] > ratings[i + 1]) {
                    candies[i]++;
                }
            } else {
                if (ratings[i] > ratings[i - 1]) {
                    candies[i]++;
                }
            }
        }

        // Tính tổng số kẹo cần phát
        int totalCandies = 0;
        for (int candy : candies) {
            totalCandies += candy;
        }

        return totalCandies;
    }
}
