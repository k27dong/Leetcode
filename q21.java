public class q21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode ref = head;
        
        while(l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                ref.next = new ListNode(l1.val);
                l1 = l1.next;
                ref = ref.next;
            }
            else {
                ref.next =  new ListNode(l2.val);
                l2 = l2.next;
                ref = ref.next;
            }
        }

        if (l1 == null) {
            ref.next = l2;
        }
        else {
            ref.next = l1;
        }
        
        return head.next;
    }
}