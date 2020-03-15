/*
 * @lc app=leetcode id=23 lang=java
 *
 * [23] Merge k Sorted Lists
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
  public ListNode mergeKLists(ListNode[] lists) {
    if (lists.length == 0) return null;
    if (lists.length == 1) return lists[0];
    if (lists.length == 2) {
      return mergeLists(lists[0], lists[1]);
    }

    int mid = lists.length / 2;
    ListNode[] l = new ListNode[mid];
    for (int i = 0; i < mid; i++) {
      l[i] = lists[i];
    }
    ListNode[] r = new ListNode[lists.length - mid];
    for (int j = mid; j < lists.length; j++) {
      r[j - mid] = lists[j];
    }

    return mergeLists(mergeKLists(l), mergeKLists(r));
  }

  public ListNode mergeLists(ListNode l1, ListNode l2) {
    if (l1 == null) return l2;
    if (l2 == null) return l1;
    ListNode ans = new ListNode(0);
    ListNode cur = ans;
    while (l1 != null && l2 != null) {
      if (l1.val < l2.val) {
        cur.next = l1;
        l1 = l1.next;
      }
      else {
        cur.next = l2;
        l2 = l2.next;
      }
      cur = cur.next;
    }
    cur.next = l1 == null ? l2 : l1;
    return ans.next;
  }
}
// @lc code=end

