package dynamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class Rob {
    // from wangdachui
    public int rob(int[] nums) {
        return max(nums, 0);
    }

    private Map<Integer, Integer> map = new HashMap<>();

    private int max(int[] nums, int startIndex) {
        int endIndex = nums.length - 1;
        int distance = endIndex - startIndex;

        if (distance >= 0) {
            int a = nums[startIndex] + getMax(nums, startIndex + 2);
            int b = getMax(nums, startIndex + 1);
            return a > b ? a : b;
        } else {
            return 0;
        }
    }

    private int getMax(int[] nums, int index) {
        if (map.containsKey(index)) {
            return map.get(index);
        } else {
            int max = max(nums, index);
            map.put(index, max);
            return max;
        }
    }

    public static void main(String[] args) {
        int[] nums = {114,117,207,117,235,82,90,67,143,146,53,108,200,91,80,223,58,170,110,236,81,90,222,160,165,195,187,199,114,235,197,187,69,129,64,214,228,78,188,67,205,94,205,169,241,202,144,240};

        System.out.println(new Rob().rob(nums));
    }
}
