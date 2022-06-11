package grind75;

import java.util.Stack;

/*
 * Link: https://leetcode.com/problems/backspace-string-compare/
 * Explaination: 2 pointers
 * complexity: linear time, const space
 */
class Solution {
    private int nextCharLoc(String s, int curr) {
        int ptr = curr - 1;

        // reduce until is not hash
        // yyyyy(y#)(y#)(y#)(y#)
        while (ptr >= 0 && s.charAt(ptr) == '#') {
            int backCount = 0;

            // consecutive hash reduction
            // yy(yyyy####)
            while (ptr >= 0 && s.charAt(ptr) == '#') {
                backCount += 1;
                ptr--;
            }

            while (ptr >= 0 && backCount > 0) {
                backCount += s.charAt(ptr) == '#'
                        ? 1 // the backspace is not used!
                        : -1;
                ptr--;
            }
        }
        return ptr;
    }

    public boolean backspaceCompare(String s, String t) {
        int ptr1 = s.length();
        int ptr2 = t.length();

        while (true) {
            ptr1 = nextCharLoc(s, ptr1);
            ptr2 = nextCharLoc(t, ptr2);

            if (ptr1 < 0 && ptr2 < 0) {
                // done
                return true;
            }
            if (ptr1 < 0 || ptr2 < 0) {
                // only one of them is done
                return false;
            }
            if (s.charAt(ptr1) != t.charAt(ptr2)) {
                return false;
            }
        }
    }
}

/*
 * Explaination: trivial stack soln
 * complexity: linear time, space
 */
class _Solution {
    private Stack<Character> toStack(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '#') {
                if (!stack.empty()) {
                    stack.pop();
                }
            } else {
                stack.push(c);
            }
        }
        return stack;
    }

    public boolean backspaceCompare(String s, String t) {
        Stack<Character> s1 = toStack(s);
        Stack<Character> s2 = toStack(t);

        if (s1.size() != s2.size()) {
            return false;
        }

        for (int i = 0; i < s1.size(); i++) {
            if (s1.elementAt(i) != s2.elementAt(i)) {
                return false;
            }
        }

        return true;
    }
}