package intersectionOfTwoLinkedList;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> setA = new HashSet<ListNode>();
        Set<ListNode> setB = new HashSet<ListNode>();

        while (headA != null && headB != null) {
            if (setB.contains(headA)) {
                return headA;
            }
            setA.add(headA);
            headA = headA.next;

            if (setA.contains(headB)) {
                return headB;
            }
            setB.add(headB);
            headB = headB.next;
        }

        while (headA != null) {
            if (setB.contains(headA)) {
                return headA;
            }
            setA.add(headA);
            headA = headA.next;
        }

        while (headB != null) {
            if (setA.contains(headB)) {
                return headB;
            }
            setB.add(headB);
            headB = headB.next;
        }

        return null;
    }
}
