package grind75;

import java.util.Stack;

// https://leetcode.com/problems/implement-queue-using-stacks/
class MyQueue {
    Stack<Integer> in;
    Stack<Integer> out;

    public MyQueue() {
        in = new Stack<>();
        out = new Stack<>();
    }

    public void push(int x) {
        in.push(x);
    }

    private void transfer() {
        while (!in.empty()) {
            out.add(in.pop());
        }
    }

    public int pop() {
        if (out.empty()) {
            transfer();
        }
        return out.pop();
    }

    public int peek() {
        if (out.empty()) {
            transfer();
        }
        return out.peek();
    }

    public boolean empty() {
        if (out.empty()) {
            transfer();
        }
        return out.empty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */