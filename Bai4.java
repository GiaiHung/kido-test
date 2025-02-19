public class Bai4 {
    public static void main(String[] args) {
        String[] tests = { "radar", "hello" };
        for (String test : tests) {
            boolean palindromeCheck = isPalindrome(test);
            System.out.println(test + (palindromeCheck ? " is palindrome" : " is not palindrome"));
            int count = countPalindromes(test);
            System.out.println("Count substring palindrome " + test + ": " + count);
        }
    }

    private static boolean isPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return true;
        }

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    private static int countPalindromes(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            // Count substring palindrome (odd)
            count += expandAroundCenter(s, i, i);
            // Count substring palindrome (even)
            count += expandAroundCenter(s, i, i + 1);
        }
        return count;
    }

    private static int expandAroundCenter(String s, int left, int right) {
        int count = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }
        return count;
    }
}
