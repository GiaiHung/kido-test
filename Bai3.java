import java.util.Arrays;

public class Bai3 {
    public static void main(String[] args) {
        int[] test = { 1, 2, 3, 4, 6 };
        int[] twoSumResult = twoSum(test, 6);
        int[] threeSumResult = threeSum(test, 9);
        System.out.println("Two sum: " + Arrays.toString(twoSumResult));
        System.out.println("Three sum: " + Arrays.toString(threeSumResult));
    }

    public static int[] twoSum(int[] arr, int k) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum == k) {
                return new int[] { arr[left], arr[right] };
            } else if (sum < k) {
                left++;
            } else {
                right--;
            }
        }
        return new int[0]; // Not found
    }

    private static int[] threeSum(int[] arr, int k) {
        int n = arr.length;
        if (n < 3)
            return new int[0];

        for (int i = 0; i < n - 2; i++) {
            int left = i + 1;
            int right = n - 1;
            while (left < right) {
                int currentSum = arr[i] + arr[left] + arr[right];
                if (currentSum == k) {
                    return new int[] { arr[i], arr[left], arr[right] };
                } else if (currentSum < k) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return new int[0]; // Not found
    }
}
