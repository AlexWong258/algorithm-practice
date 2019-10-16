package lengthOfLongestSubstring;

import java.util.*;

public class Solution1 {
    public static int lengthOfLongestSubstring(String s) {
        int longest = 0;
        char[] array =  s.toCharArray();
        LinkedHashSet<Character> set = new LinkedHashSet<>();

        for (int i = 0; i < array.length; i++) {
            Character c = array[i];

            if (!set.contains(c)) {
                set.add(c);
            } else {
                longest = longest > set.size() ? longest : set.size();
                deleteAllBeforeTheChar(set, c);
                set.add(c);
            }
        }

        longest = longest > set.size() ? longest : set.size();
        return longest;
    }

    public static void deleteAllBeforeTheChar(LinkedHashSet<Character> set, Character c) {
        Set<Character> set1 = new HashSet<>();
        for (Character cha :
                set) {
            set1.add(cha);
            if (cha.equals(c))
                break;
        }

        set.removeAll(set1);
    }
}
