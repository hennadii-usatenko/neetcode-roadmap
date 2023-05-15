package a_arrays_hashing_1.a_contains_duplicate_1;

/**
 * <a href="https://leetcode.com/problems/contains-duplicate/">217. Contains Duplicate</a>
 * Given an integer array nums, return true if any value appears at least twice in the array,
 * and return false if every element is distinct.
 * Example 1:
 * Input: nums = [1,2,3,1]
 * Output: true
 * Example 2:
 * Input: nums = [1,2,3,4]
 * Output: false
 * Example 3:
 * Input: nums = [1,1,1,3,3,4,3,2,4,2]
 * Output: true
 */
public class ContainsDuplicate {

    public static void main(String[] args) throws Exception {
        var result1 = containsDuplicate(new int[]{1,2,3,1});
        if (!result1) {
            throw new Exception("result1 must be true");
        }
        var result2 = containsDuplicate(new int[]{1,2,3,4});
        if (result2) {
            throw new Exception("result2 must be false");
        }
        var result3 = containsDuplicate(new int[]{1,1,1,3,3,4,3,2,4,2});
        if (!result3) {
            throw new Exception("result3 must be true");
        }
    }

    /**
     * <a href="https://leetcode.com/problems/contains-duplicate/submissions/948395586/">submission</a>
     */
    private static boolean containsDuplicate(int[] nums) {
        java.util.Set<Integer> set = new java.util.HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) return true;
        }
        return false;
    }
}
