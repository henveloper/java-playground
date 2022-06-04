package grind75;

// https://leetcode.com/problems/min-stack/
class MinStack {
    public Node head;

    class Node {
        public int val;
        public int min;
        public Node prev;

        public Node(int val, int min, Node prev) {
            this.val = val;
            this.min = min;
            this.prev = prev;
        }
    }

    public MinStack() {
        head = null;
    }

    public void push(int val) {
        if (head == null) {
            head = new Node(val, val, null);
        } else {
            head = new Node(val, Math.min(val, head.min), head);
        }
    }

    public void pop() {
        head = head.prev;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */