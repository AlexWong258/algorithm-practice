import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 You may assume that each input would have exactly one solution, and you may not use the same element twice.
 Example:
 Given nums = [2, 7, 11, 15], target = 9,
 Because nums[0] + nums[1] = 2 + 7 = 9,
 return [0, 1].
 */
public class TwoSum {
    public static List<String> getNums(int[] num, int target) {
        List<String> result = new ArrayList<String>();

        if (num.length > 1) {
            Map<Integer, Integer> valueIndexMap = new HashMap<>();

            for (int i = 0; i < num.length; i++) {
                if (valueIndexMap.containsKey(target - num[i])) {
                    result.add(valueIndexMap.get(target - num[i]) + "," + i);
                }

                valueIndexMap.put(num[i], i);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] num = {2, 7, 11, 15};

        List<String> result = getNums(num, 9);

        System.out.println(result);
    }
}
