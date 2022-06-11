package grind75;

// https://leetcode.com/problems/add-binary/
class Solution {
    public String addBinary(String a, String b) {
        int ptr1 = a.length() - 1;
        int ptr2 = b.length() - 1;
        int carry = 0;

        StringBuilder sb = new StringBuilder();

        while (ptr1 >= 0 || ptr2 >= 0) {
            int n1 = ptr1 < 0 ? 0 : a.charAt(ptr1) - 48;
            int n2 = ptr2 < 0 ? 0 : b.charAt(ptr2) - 48;
            int sum = n1 + n2 + carry;
            carry = 0;

            if (sum > 1) {
                sum -= 2;
                carry = 1;
            }

            sb.insert(0, sum);

            ptr1--;
            ptr2--;
        }

        if (carry == 1) {
            sb.insert(0, 1);
        }

        return sb.toString();
    }
}