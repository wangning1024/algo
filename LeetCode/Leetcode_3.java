import java.util.HashMap;
import java.util.Map;

/**
 * 无重复字符的最长子串
 * 解题思路：滑动窗口(队列)
 * 时间复杂度：O(n)
 *
 */
public class Leetcode_3 {

    public int lengthOfLongestSubstring1(String s) {
        String t = "abbcabdea";
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int end = 0, start = 0; end < n; end++) {
            char alpha = s.charAt(end);
            if (map.containsKey(alpha)) {
                //
                start = Math.max(map.get(alpha), start);
            }
            ans = Math.max(ans, end - start + 1);
            // 每一次都把新字母加入到map中
            map.put(s.charAt(end), end + 1);
        }
        return ans;
    }

    public int lengthOfLongestSubstring2(String s) {
        if (s.length() == 0) {
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        int r = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            r = Math.max(r, i - left + 1);
        }
        return r;
    }


}
