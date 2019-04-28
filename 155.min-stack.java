/*
 * @lc app=leetcode id=155 lang=java
 *
 * [155] Min Stack
 */
class MinStack {

    class Node {
        // doubly linked node
        int val;
        Node prev, next;

        public Node(int v) {
            val = v;
        }

        public void add(int v) {
            Node next = new Node(v);
            set_next(next);
            next.set_prev(this);
        }

        public void set_next(Node n) {
            next = n;
        }

        public void set_prev(Node n) {
            prev = n;
        }

        public int get_element() {
            return val;
        }

        public Node get_next() {
            return next;
        }

        public Node get_prev() {
            return prev;
        }
    }
    
    int size;
    Node head;
    Node ref;  // this node points to the newest node

    /** initialize your data structure here. */
    public MinStack() {
        head = new Node(Integer.MAX_VALUE);
        size = 0;
        ref = head;
    }

    public boolean isEmpty() {
        return size == 0;
    }
    
    public void push(int x) {
        ref.add(x);
        ref = ref.get_next();
        size++;
    }
    
    public void pop() {
        if (!isEmpty()) {
            ref = ref.get_prev();
            size --;
        }
    }
    
    public int top() {
        if (!isEmpty()) {
            return ref.get_element();
        }
        return 0;
    }
    
    public int getMin() {
        // 遍历整个node list，贪心取最小
        int ans = ref.get_element();
        Node temp = ref;
        for (int i = 0; i < size; i++) {
            ans = Math.min(ans, temp.get_element());
            temp = temp.get_prev();
        }
        return ans;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */


