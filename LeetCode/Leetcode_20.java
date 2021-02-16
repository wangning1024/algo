import java.util.HashMap;

public class Leetcode_20 {
    public boolean isValid(String s) {
        if (s.length() < 2) {
            return false;
        }
        HashMap<String, String> equalMap = new HashMap<>();
        equalMap.put(")", "(");
        equalMap.put("}", "{");
        equalMap.put("]", "[");
        String[] sr = new String[s.length()];
        sr[0] = s.substring(0, 1);
        int i = 1;
        int j = 1;
        while (j < s.length()) {
            String temp = s.substring(j, j + 1);
            if (i - 1 >= 0 && equalMap.containsKey(temp) && equalMap.get(temp).equals(sr[i - 1])) {
                i--;
            } else {
                sr[i] = temp;
                i++;
            }
            j++;
        }
        return i == 0;
    }

    public static void main(String[] args) {
        Leetcode_20 test = new Leetcode_20();

        System.out.println(test.isValid("{}}{"));


    }
}
