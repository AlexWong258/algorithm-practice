package LRUCache;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    private Map<Integer,ListNode> map;
    private ListNode head;
    private ListNode tail;
    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<Integer, ListNode>();
        head = null;
        tail = null;
    }

    public int get(int key) {
        ListNode node = map.get(key);
        if (node == null) {
            return -1;
        } else {
            swapNode2Head(node);
            return node.getValue();
        }
    }

    public void put(int key, int value) {
        ListNode node;
        if (map.containsKey(key)) {
            node = map.get(key);
            node.setValue(value);

            swapNode2Head(node);
        } else {
            node = new ListNode();
            map.put(key, node);
            node.setKey(key);
            node.setValue(value);

            putNodeInFirst(node);
            deleteIfOverCapacity();
        }
    }

    private void deleteIfOverCapacity() {
        if (map.size() > capacity) {
            map.remove(tail.getKey());
            tail = tail.getPrev();
            tail.setNext(null);
        }
    }

    private void putNodeInFirst(ListNode node) {
        if (head == null) {
            head = node;
            tail = node;
        } else {
            node.setNext(head);
            head.setPrev(node);
            head = node;
        }
    }

    private void swapNode2Head(ListNode node) {
        if (node == head)
            return;

        node.getPrev().setNext(node.getNext());
        if (node != tail) {
            node.getNext().setPrev(node.getPrev());
        } else {
            tail = node.getPrev();
        }

        node.setPrev(null);
        node.setNext(head);
        head.setPrev(node);
        head = node;
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);
        System.out.println(cache.get(2));
        cache.put(4, 4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }
}
