package reverseList;

public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode previous = null;
        ListNode current = head;
        ListNode next = null;
        if (current != null) {
            next = current.next;
        }

        while (current != null) {
            current.next = previous;

            ListNode originCurrent = current;
            current = next;
            previous = originCurrent;
            if (current != null) {
                next = current.next;
            }
        }
        return previous;
    }
}
