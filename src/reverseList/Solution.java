package reverseList;

public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode previous = null;
        ListNode current = head;

        while (current != null) {
            ListNode next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode();
        node1.setVal(1);

        ListNode node2 = new ListNode();
        node2.setVal(2);

        ListNode node3 = new ListNode();
        node3.setVal(3);

        ListNode node4 = new ListNode();
        node4.setVal(4);

        ListNode node5 = new ListNode();
        node5.setVal(5);

        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);

        print(node1);
        ListNode newNode = new Solution().reverseList(node1);
        print(newNode);
    }

    public static void print(ListNode node) {
        while (node != null) {
            System.out.println(node.getVal());
            node = node.next;
        }
    }
}
