import java.util.ArrayList;

public class Ex002 {
    /*
    Given an integer x, return true if x is a
palindrome, and false otherwise.

Example 1:
Input: x = 121
Output: true
Explanation: 121 reads as 121 from left to right and from right to left.

Example 2:
Input: x = -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.

Example 3:
Input: x = 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
     */
    public static void main(String[] args) {
        //int x = 123;
        //int x = -121;
        int x = 10;

        System.out.println(isPalindrome(x));
        //System.out.println(12 / 10);
        //123%10 = 3
        //123%100 = 23

    }

    public static boolean isPalindrome(int x) {

        if (x < 0)
            return false;

        else if (x > 9 && x < 100) {
            if (x % 10 == (int) x / 10) return true;
            else return false;
        }

        ArrayList<Integer> digits = new ArrayList<>();
        while (x > 0) {
            digits.add(x % 10);
            x /= 10;
        }

        int length = digits.size();
        for (int i = 0; i < length / 2; i++) {
            if (digits.get(i) != digits.get(length-1 - i))
                return false;
        }
        return true;
    }
}
