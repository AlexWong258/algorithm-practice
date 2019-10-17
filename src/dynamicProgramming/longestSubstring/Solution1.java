package dynamicProgramming.longestSubstring;

import java.util.*;

/**
 * 至少有K个重复字符的最长子串：
 * 找到给定字符串（由小写字符组成）中的最长子串 T ， 要求 T 中的每一字符出现次数都不少于 k 。输出 T 的长度。
 * 效率较低
 */
public class Solution1 {
    public int longestSubstring(String s, int k) {
        char[] array = s.toCharArray();
        return max(array, 0, array.length - 1, k);
    }

    private int max(char[] array, int start, int end, int k) {
        //遍历一遍，如果没有次数小于k的字符，返回end - start
        //如果有，生成low high， return再做一次max

        int length = end - start + 1;
        if (length < k)
            return 0;

        Map<Character, Node> map = new HashMap<>();
        
        for (int i = start; i <= end; i++) {
            Node node = map.get(array[i]);
            if (node == null) {
                node = new Node();
                map.put(array[i], node);
                node.setCount(1);
                node.setIndexList(new ArrayList<>());
            } else {
                node.setCount(node.getCount() + 1);
            }
            node.getIndexList().add(i);
        }

        boolean hasInvalid = false;
        List<Integer> invalidIndexList = new ArrayList<>();
        for (Character c :
                map.keySet()) {
            Node node = map.get(c);
            if (node.getCount() < k) {
                hasInvalid = true;
                invalidIndexList.addAll(node.getIndexList());
            }
        }

        if (!hasInvalid) {
            return length;
        } else {
            invalidIndexList.add(start - 1);
            invalidIndexList.add(end + 1);
            Collections.sort(invalidIndexList);

            int max = 0;
            for (int i = 0; i < invalidIndexList.size() - 1; i++) {
                int temp = max(array, invalidIndexList.get(i) + 1, invalidIndexList.get(i + 1) - 1, k);
                max = max > temp ? max : temp;
            }

            return max;
        }
    }

    public static void main(String[] args) {
        String s = "aaabb";
        System.out.println(new Solution1().longestSubstring(s, 3));
    }
}
