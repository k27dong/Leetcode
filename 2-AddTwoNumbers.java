/*
 * @lc app=leetcode id=2 lang=java
 *
 * [2] Add Two Numbers
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    int carry = 0;
    int sum_val = 0;
    ListNode root = new ListNode(0);
    ListNode pointer = root; // start iterate at root
    while (l1 != null || l2 != null || carry != 0) {
      int lval = l1 == null ? 0 : l1.val;
      int rval = l2 == null ? 0 : l2.val;
      sum_val = lval + rval + carry;
      carry = sum_val / 10;
      sum_val = sum_val % 10;
      ListNode new_node = new ListNode(sum_val);
      pointer.next = new_node;
      pointer = pointer.next;
      l1 = l1 == null ? l1 : l1.next;
      l2 = l2 == null ? l2 : l2.next;
    }
    return root.next;
  }
}
// @lc code=end

