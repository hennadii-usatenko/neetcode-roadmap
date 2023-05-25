package a_arrays_hashing_1.f_product_of_frray_except_self_6;

/**
 * <a href="https://leetcode.com/problems/product-of-array-except-self/">238. Product of Array Except Self</a>
 * Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 * You must write an algorithm that runs in O(n) time and without using the division operation.
 * Example 1:
 * Input: nums = [1,2,3,4]
 * Output: [24,12,8,6]
 * Example 2:
 * Input: nums = [-1,1,0,-3,3]
 * Output: [0,0,9,0,0]
 */
public class ProductOfArrayExceptSelf {

    public static void main(String[] args) throws Exception {
        var result1 = productExceptSelf(new int[]{1,2,3,4});
        if (!java.util.Arrays.equals(result1, new int[]{24,12,8,6})) {
            throw new Exception("result1 is not valid");
        }
        var result2 = productExceptSelf(new int[]{-1,1,0,-3,3});
        if (!java.util.Arrays.equals(result2, new int[]{0,0,9,0,0})) {
            throw new Exception("result2 is not valid");
        }
    }

    /**
     * <a href="https://leetcode.com/problems/product-of-array-except-self/submissions/956989690/">submission</a>
     */
    public static int[] productExceptSelf(int[] nums) {
        int[] leftProduct = new int[nums.length];
        int[] rightProduct = new int[nums.length];
        int[] product = new int[nums.length];
        leftProduct[0] = 1;
        rightProduct[nums.length - 1] = 1;
        for (int i = nums.length - 1; i > 0; i--) {
            rightProduct[i - 1] = rightProduct[i] * nums[i];
        }
        for (int i = 0; i < nums.length - 1; i++) {
            leftProduct[i + 1] = leftProduct[i] * nums[i];
            product[i + 1] = leftProduct[i + 1] * rightProduct[i + 1];
        }
        product[0] = leftProduct[0] * rightProduct[0];
        return product;
    }

}
