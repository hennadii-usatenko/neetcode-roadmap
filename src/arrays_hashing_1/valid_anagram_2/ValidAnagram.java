package arrays_hashing_1.valid_anagram_2;

/**
 * <a href="https://leetcode.com/problems/valid-anagram/">242. Valid Anagram</a>
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
 * typically using all the original letters exactly once.
 * Example 1:
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 * Example 2:
 * Input: s = "rat", t = "car"
 * Output: false
 */
public class ValidAnagram {

    public static void main(String[] args) throws Exception {
        var result1 = isAnagram("anagram", "nagaram");
        if (!result1) {
            throw new Exception("result1 must be true");
        }
        var result2 = isAnagram("rat", "car");
        if (result2) {
            throw new Exception("result2 must be false");
        }
    }

    /**
     * <a href="https://leetcode.com/problems/valid-anagram/submissions/948869967/">submission</a>
     */
    public static boolean isAnagram(String s, String t) {
        if (s.length() == t.length()) {
            var sCharMap = getCharMap(s);
            var tCharMap = getCharMap(t);
            if (sCharMap.size() == tCharMap.size()) {
                return sCharMap.equals(tCharMap);
            }
        }
        return false;
    }

    private static java.util.Map<Character, Integer> getCharMap(String s) {
        java.util.Map<Character, Integer> charMap = new java.util.TreeMap<>();
        for (char c : s.toCharArray()) {
            var key = charMap.get(c);
            if (key == null) {
                charMap.put(c, 1);
            } else {
                charMap.put(c, ++key);
            }
        }
        return charMap;
    }
}
