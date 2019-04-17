public class q83 {

    public ListNode deleteDuplicates(ListNode head) {
        /**
         * three pointers:
         * 1 - fast, moves through the whole list
         * 2 - slow, moves based on the status returned from 1
         * 3 - slower, moves behind 2, handle node linking
         */

        /**
         * 
         */


        if (head == null) {
            return null;
        }

        if (head.next == null) {
            return head;
        }

        ListNode ref = head;
        
        ListNode trail = new ListNode(0);
        ListNode point = trail;
        
        while (ref.next != null) {
            if (ref.next.val != ref.val) {
                // this value is valid
                ListNode temp = new ListNode(ref.val);
                point.next = temp;
                point = point.next;
            }
            ref = ref.next;
        }

        ListNode last = new ListNode(ref.val);
        point.next = last;
        
        return trail.next;
    }
}