package lc_17_电话号码字母组合;

import java.util.*;


public class Solution {
    public List<String> letterCombinations(String digits) {

        Map<String, String[]> numAbc = new HashMap<>();
        String[] l2 = {"a", "b", "c"};
        String[] l3 = {"d", "e", "f"};
        String[] l4 = {"g", "h", "i"};
        String[] l5 = {"j", "k", "l"};
        String[] l6 = {"m", "n", "o"};
        String[] l7 = {"p", "q", "r", "s"};
        String[] l8 = {"t", "u", "v"};
        String[] l9 = {"w", "x", "y", "z"};
        numAbc.put("2", l2);
        numAbc.put("3", l3);
        numAbc.put("4", l4);
        numAbc.put("5", l5);
        numAbc.put("6", l6);
        numAbc.put("7", l7);
        numAbc.put("8", l8);
        numAbc.put("9", l9);
        List<String> re = new ArrayList<>();

        if (digits == null || digits.length() == 0) {
            return re;
        }

        solution(digits, 0, new StringBuilder(), re, numAbc);

//        String[] strings = numAbc.get(String.valueOf(chars[0]));
//        List<String> re = new ArrayList<>();
//        for (String str : strings) {
//            String[] strings1 = numAbc.get(String.valueOf(chars[1]));
//            for (String str1 : strings1) {
//                String[] strings2 = numAbc.get(String.valueOf(chars[2]));
//                for (String str2 : strings2) {
//                    re.add(str + str1 + str2);
//                }
//            }
//        }
        for (String s : re) {
            System.out.println(s);
        }
        return null;

    }

    private void solution(String digits, int index, StringBuilder str, List<String> r, Map<String, String[]> numAbc) {
        if (index >= digits.length()) {
            r.add(str.toString());
            return;
        }
        String[] strings = numAbc.get(digits.substring(index, index + 1));
        for (int i = 0; i < strings.length; i++) {
            str.append(strings[i]);
            solution(digits, index + 1, str, r, numAbc);
            // 递归结束后，需要把值充值会递归前的模样
            str.deleteCharAt(str.length() - 1);
        }
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        solution.letterCombinations("57893");
    }


}
