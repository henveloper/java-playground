package grind75;

import java.util.Stack;

// https://leetcode.com/problems/valid-parentheses/
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[][] symbols = new char[][] {
                { '(', ')' },
                { '[', ']' },
                { '{', '}' },
        };

        for (char ch : s.toCharArray()) {
            for (char[] pairs : symbols) {
                if (ch == pairs[1]) {
                    if (stack.isEmpty()) {
                        return false;
                    }

                    char top = stack.pop();
                    if (top != pairs[0]) {
                        return false;
                    }
                }
                
                if (ch == pairs[0]) {
                    stack.add(ch);
                }
            }
        }

        return stack.isEmpty();
    }
}