/**
 * 求解最长回文字符串
 */
public class Leetcode_5 {

    /**
     * 暴力算法
     * 时间复杂度：O(N^3)，这里 N是字符串的长度，枚举字符串的左边界、右边界，然后继续验证子串是否是回文子串，这三种操作都与 NN 相关；

     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }
        char[] chars = s.toCharArray();
        int maxLen = 0;
        int begin = 0;
        for (int i = 0; i < chars.length - 1; i++) {
            for (int j = i + 1; j < chars.length; j++) {
                if (j - i + 1 > maxLen && this.validPalindromic(chars, i, j)) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
            
        }
        String result = s.substring(begin, begin + maxLen);

        if(result.length()  == 0) {
            return s.substring(0, 1);
        }

        return result;
    }

    // 判断是否为回文字符串
    private Boolean validPalindromic(char[] s, int start, int end) {
        while (start < end) {
            if (s[start] != s[end]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        String test = "abbca";
        Leetcode_5 t = new Leetcode_5();
        if (t.validPalindromic(test.toCharArray(), 0, test.length() - 1)) {
            System.out.println("是");
        } else {
            System.out.println("否");
        }
    }
}
