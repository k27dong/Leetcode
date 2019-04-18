import java.lang.Math;
public class q2 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode n = l1;
        ListNode m = l2;
        ListNode c = new ListNode(0);   // this is to be returned
        ListNode d = c;
        
        boolean b = false;
        
        while (n != null && m != null) {
            int sum;
            if (b) {
                sum = n.val + m.val + 1;
            }
            else {
                sum = n.val + m.val;
            }
            b = false;
            
            if (sum >= 10) {
                b = true;
                sum -= 10;
            }

            ListNode pointer = d;
            while (pointer.next != null) {
                pointer = pointer.next;
            }
            pointer.next = new ListNode(sum);
            
            n = n.next;
            m = m.next;
            d = d.next;
        }

        if (n == null && m != null) {
            fill(m, c, b);
        }
        else if (m == null && n != null) {
            fill(n, c, b);
        }
        else if (m == null && n == null) {
            // add an additional one in the very front if b is true
            if (b) {
                ListNode temp = c;
                while(temp.next != null) {
                    temp = temp.next;
                }
                temp.next = new ListNode(1);
            }
        }
        else {

        }

        return c.next;
    }

    public void fill(ListNode remain, ListNode c, boolean b) {
        ListNode temp = c;
        ListNode pointer = remain;
        while(temp.next != null) {
            temp = temp.next;
        }
        // ... -> temp -> null

        if (b) {
            while(pointer.next != null && pointer.val == 9) {
                pointer.val = 0;
                pointer = pointer.next;
            }
            // 9, 9, ... , 8
            if (pointer.next == null && pointer.val == 9) {
                // last element and it's 9
                pointer.val = 0;
                pointer.next = new ListNode(1);
            }
            else {
                // not 9
                pointer.val++;
            }
        }

        while(remain != null) {
            temp.next = new ListNode(remain.val);
            temp = temp.next;
            remain = remain.next;
        }
    }
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {   // failed attempt, number is too long to store
        String sum = Long.toString(getNum(l1) + getNum(l2));
        ListNode ans = new ListNode(Integer.parseInt(Character.toString(sum.charAt(sum.length()-1))));
        
        for (int i=sum.length() - 2; i >= 0; i--) {
            int now = Integer.parseInt(Character.toString(sum.charAt(i)));
            ListNode temp = ans;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new ListNode(now);
        }
        return ans;
    }
    
    public long getNum(ListNode n) {
        int m = 0;
        long ans = 0;
        do {
            ans += n.val * Math.pow(10, m);
            m++;
            n = n.next;
        }
        while (n != null);
        return ans;
    }

    
}