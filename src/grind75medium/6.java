package grind75medium;

// link: https://leetcode.com/problems/k-closest-points-to-origin/
/**
 * This solution constructs the string row by row, finding the position thus value of each character to append.
 * Linear time.
 * 
 * An alternative solution would be to go thru the character one by one, append in List<StringBuilder>, then join at the end.
 */
class Solution {
    public String convert(String s, int numRows) {
        int period = 2 * numRows - 2;
        StringBuilder sb = new StringBuilder();

        // edge case: numRows = 1 -> period = 0
        if (numRows == 1) {
            return s;
        }


        // top bar k(2n-2);
        for (int i = 0; i < s.length(); i += period) {
            sb.append(s.charAt(i));
        }

        // mid bars
        for (int rowNum = 1; rowNum <= numRows - 2; rowNum++) {
            for (int periodPos = 0; periodPos < s.length(); periodPos += period) {
                int pos1 = periodPos + rowNum;
                int pos2 = periodPos + period - rowNum;
                if (pos2 < s.length()) {
                    sb.append(s.charAt(pos1));
                    sb.append(s.charAt(pos2));
                } else if (pos1 < s.length()) {
                    sb.append(s.charAt(pos1));
                }
            }
        }

        // bottom bar
        for (int i = numRows - 1; i < s.length(); i += period) {
            sb.append(s.charAt(i));
        }

        return sb.toString();
    }
}