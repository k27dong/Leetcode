/*
 * @lc app=leetcode id=83 lang=java
 *
 * [83] Remove Duplicates from Sorted List
 *
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/description/
 *
 * algorithms
 * Easy (42.35%)
 * Likes:    795
 * Dislikes: 82
 * Total Accepted:    336.6K
 * Total Submissions: 786.5K
 * Testcase Example:  '[1,1,2]'
 *
 * Given a sorted linked list, delete all duplicates such that each element
 * appear only once.
 * 
 * Example 1:
 * 
 * 
 * Input: 1->1->2
 * Output: 1->2
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: 1->1->2->3->3
 * Output: 1->2->3
 * 
 * 
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        /**
         * if there's only one node left, return ture
         * else check if head is equal to head.next, if true then move the head to head.next
         */
        if (head == null || head.next == null) {
            return head;
        }

        head.next = deleteDuplicates(head.next);

        if (head.val == head.next.val) {
            head = head.next;
        }

        return head;
    }
}

