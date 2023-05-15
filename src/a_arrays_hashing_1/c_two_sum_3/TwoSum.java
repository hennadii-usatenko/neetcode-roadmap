package a_arrays_hashing_1.c_two_sum_3;

/**
 * <a href="https://leetcode.com/problems/two-sum/">1. Two Sum</a>
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * You can return the answer in any order.
 * Example 1:
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 * Example 2:
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 * Example 3:
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 */
public class TwoSum {

    public static void main(String[] args) throws Exception {
        var result1 = twoSum(new int[]{2,7,11,15}, 9);
        if (!java.util.Arrays.equals(result1, new int[]{0,1})) {
            throw new Exception("result1 is not valid");
        }
        var result2 = twoSum(new int[]{3,2,4}, 6);
        if (!java.util.Arrays.equals(result2, new int[]{1,2})) {
            throw new Exception("result2 is not valid");
        }
        var result3 = twoSum(new int[]{3,3}, 6);
        if (!java.util.Arrays.equals(result3, new int[]{0,1})) {
            throw new Exception("result3 is not valid");
        }
    }

    /**
     * <a href="https://leetcode.com/problems/two-sum/submissions/950717284/">submission</a>
     */
    private static int[] twoSum(int[] nums, int target) {
        java.util.Map<Integer, Integer> map = new java.util.HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (map.containsKey(num)) {
                return new int[]{map.get(num), i};
            }
            int targetDiff = target - num;
            if (!map.containsKey(targetDiff)) {
                map.put(targetDiff, i);
            }
        }
        return new int[]{};
    }
}
