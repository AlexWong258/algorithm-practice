package intersectionOfTwoLinkedList;

public class Solution2 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lengthA = 0;
        int lengthB = 0;
        ListNode lastNodeA = null;
        ListNode lastNodeB = null;
        ListNode originalNodeA = headA;
        ListNode originalNodeB = headB;

        while (headA != null || headB != null){
            if (headA != null) {
                lengthA++;
                lastNodeA = headA;
                headA = headA.next;
            }

            if (headB != null) {
                lengthB++;
                lastNodeB = headB;
                headB = headB.next;
            }
        }

        if (lastNodeA != null && lastNodeA == lastNodeB) {
            ListNode longerNode = lengthA > lengthB ? originalNodeA : originalNodeB;
            ListNode otherNode = lengthA > lengthB ? originalNodeB : originalNodeA;
            int longerBy = lengthA > lengthB ? lengthA - lengthB : lengthB - lengthA;

            for (int i = 0; i < longerBy; i++) {
                longerNode = longerNode.next;
            }

            while (true) {
                if (longerNode == otherNode){
                    return longerNode;
                } else {
                    longerNode = longerNode.next;
                    otherNode = otherNode.next;
                }
            }
        } else {
            return null;
        }
    }
}
