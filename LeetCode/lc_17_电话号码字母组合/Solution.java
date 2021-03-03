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

        char[] chars = digits.toCharArray();
        for (char c : chars) {
            String[] strings = numAbc.get(c);
            for (String str : strings) {

            }
        }


        return null;

    }

}
