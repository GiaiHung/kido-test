/* 
Bài 1: Merge hai mảng A và B đã sắp xếp tăng dần thành một mảng duy nhất vẫn được sắp xếp.
VD:Input:A=[1,3,5],B=[2,4,6]Output:[1,2,3,4,5,6]
** Nâng cao: Không sử dụng mảng trung gian, hợp nhất các phần tử của B vào A, giả sử mảng A có đủ không gian trống.
*/

import java.util.Arrays;

public class Bai1 {
    public static void main(String[] args) {
        int[] test1 = { 1, 2, 2, 3 };
        int[] test2 = { 1, 3, 3, 4, 5 };
        int[] testMerge = mergeSortedArrayBasic(test1, test2);
        // Output: [1, 1, 2, 2, 3, 3, 3, 4, 5]
        System.out.println("Output: " + Arrays.toString(testMerge));

        int[] test3 = { 2, 2, 5, 6, 0, 0, 0 };
        int[] test4 = { 1, 4, 7 };
        int[] testMergeAdvanced = mergeSortedArrayAdvanced(test3, test4);
        // Output advanced: [1, 2, 2, 4, 5, 6, 7]
        System.out.println("Output advanced: " + Arrays.toString(testMergeAdvanced));
    }

    private static int[] mergeSortedArrayBasic(int[] A, int[] B) {
        int aLength = A.length;
        int bLength = B.length;
        int[] result = new int[aLength + bLength];

        // i: A index, j: B index, k: result index
        int i = 0, j = 0, k = 0;

        // Compare A and B then orderly put into result
        while (i < aLength && j < bLength) {
            if (A[i] <= B[j]) {
                result[k++] = A[i++];
            } else {
                result[k++] = B[j++];
            }
        }

        // Append the rest of A elements
        while (i < aLength) {
            result[k++] = A[i++];
        }

        // Append the rest of B elements
        while (j < bLength) {
            result[k++] = B[j++];
        }

        return result;
    }

    private static int[] mergeSortedArrayAdvanced(int[] A, int[] B) {
        // Figure out how many existing elements in A
        int i = 0;
        while (A[i + 1] >= A[i]) {
            i++;
        }

        int j = B.length - 1;
        int k = A.length - 1;

        // Loop backward to find the large element from both array
        while (i >= 0 && j >= 0) {
            if (A[i] >= B[j]) {
                A[k--] = A[i--];
            } else {
                A[k--] = B[j--];
            }
        }

        // Insert the rest of B elements (if any)
        while (j >= 0) {
            A[k--] = B[j--];
        }

        return A;
    }
}
