package grind75;

import java.util.HashMap;
import java.util.Map;

/*
 * Link: https://leetcode.com/problems/roman-to-integer/submissions/
 * Explaination: trivial
 * Optimality: trivial
 */
class Solution {
    public int inverseValue(char prev, char curr) {
        if (prev == 'I' && (curr == 'V' || curr == 'X')) {
            return -2; // void previous currValue and deduction
        }
        if (prev == 'X' && (curr == 'L' || curr == 'C')) {
            return -20;
        }
        if (prev == 'C' && (curr == 'D' || curr == 'M')) {
            return -200;
        }

        return 0;
    }

    public int romanToInt(String s) {

        Map<Character, Integer> charValueMap = new HashMap<>();
        charValueMap.put('I', 1);
        charValueMap.put('V', 5);
        charValueMap.put('X', 10);
        charValueMap.put('L', 50);
        charValueMap.put('C', 100);
        charValueMap.put('D', 500);
        charValueMap.put('M', 1000);

        int sum = 0;
        char prev = '\0';
        for (char curr : s.toCharArray()) {
            sum += charValueMap.get(curr);
            sum += inverseValue(prev, curr);
            prev = curr;
        }
        return sum;
    }
}