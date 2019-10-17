package lengthOfLongestSubstring;

import java.util.HashMap;
import java.util.Map;

public class Solution2 {
    public static int lengthOfLongestSubstring(String s) {
        int longest = 0;
        int currentLength = 0;
        char[] array =  s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        int lastRepeatIndex = -1;

        for (int i = 0; i < array.length; i++) {
            Character c = array[i];

            if (!map.containsKey(c) || (map.containsKey(c) && map.get(c) <= lastRepeatIndex)) {
                map.put(c, i);
                currentLength++;
            } else {
                longest = longest > currentLength ? longest : currentLength;
                lastRepeatIndex = map.get(c);
                currentLength = i - map.get(c);
                map.put(c, i);
            }
        }

        longest = longest > currentLength ? longest : currentLength;
        return longest;
    }
}
