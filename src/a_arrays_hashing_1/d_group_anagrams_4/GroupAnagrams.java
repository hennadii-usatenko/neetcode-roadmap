package a_arrays_hashing_1.d_group_anagrams_4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/group-anagrams/">49. Group Anagrams</a>
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
 * typically using all the original letters exactly once.
 * Example 1:
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * Example 2:
 * Input: strs = [""]
 * Output: [[""]]
 * Example 3:
 * Input: strs = ["a"]
 * Output: [["a"]]
 */
public class GroupAnagrams {

    public static void main(String[] args) throws Exception {
        var result1 = groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"});
        if (!containsAll(result1, List.of(List.of("bat"), List.of("nat","tan"), List.of("ate","eat","tea")))) {
            throw new Exception("result1 is not valid");
        }
        var result2 = groupAnagrams(new String[]{""});
        if (!containsAll(result2, List.of(List.of("")))) {
            throw new Exception("result2 is not valid");
        }
        var result3 = groupAnagrams(new String[]{"a"});
        if (!containsAll(result3, List.of(List.of("a")))) {
            throw new Exception("result3 is not valid");
        }
    }

    /**
     * <a href="https://leetcode.com/problems/group-anagrams/submissions/951379487/">submission</a>
     */
    public static java.util.List<java.util.List<String>> groupAnagrams(String[] strs) {
        java.util.Map<String, java.util.List<Integer>> map = new HashMap<>();
        java.util.List<java.util.List<String>> result = new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
            var str = strs[i];
            var charArray = str.toCharArray();
            Arrays.sort(charArray);
            var sortedStr = new String(charArray);
            var indexes = map.get(sortedStr);
            if (indexes == null) {
                map.put(sortedStr, new ArrayList<>(List.of(i)));
            } else {
                indexes.add(i);
                map.put(sortedStr, indexes);
            }
        }
        map.values().stream()
                .map(lists -> lists.stream().map(index -> strs[index]).toList())
                .forEach(result::add);
        return result;
    }

    private static boolean containsAll(List<List<String>> list1, List<List<String>> list2) {
        return list1.stream().allMatch(l1 -> {
            return list2.stream().anyMatch(l2 -> l2.containsAll(l1));
        });
    }
}
