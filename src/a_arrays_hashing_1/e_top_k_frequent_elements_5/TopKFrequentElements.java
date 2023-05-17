package a_arrays_hashing_1.e_top_k_frequent_elements_5;

/**
 * <a href="https://leetcode.com/problems/top-k-frequent-elements/">347. Top K Frequent Elements</a>
 * Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
 * Example 1:
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 * Example 2:
 * Input: nums = [1], k = 1
 * Output: [1]
 */
public class TopKFrequentElements {

    public static void main(String[] args) throws Exception {
        var result1 = topKFrequent(new int[]{1,1,1,2,2,3}, 2);
        if (!java.util.Arrays.equals(result1, new int[]{1,2})) {
            throw new Exception("result1 is not valid");
        }
        var result2 = topKFrequent(new int[]{1}, 1);
        if (!java.util.Arrays.equals(result2, new int[]{1})) {
            throw new Exception("result2 is not valid");
        }
    }

    /**
     * <a href="https://leetcode.com/problems/top-k-frequent-elements/submissions/951975323/">submission</a>
     */
    public static int[] topKFrequent(int[] nums, int k) {
        java.util.Map<Integer, Integer> frequencyMap = new java.util.HashMap<>();
        for (int num : nums) {
            frequencyMap.merge(num, 1, Integer::sum);
        }
        return frequencyMap.entrySet().stream()
                .sorted(java.util.Collections.reverseOrder(java.util.Comparator.comparingInt(java.util.Map.Entry::getValue)))
                .limit(k)
                .mapToInt(java.util.Map.Entry::getKey)
                .toArray();
    }
}
