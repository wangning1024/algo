import java.util.ArrayList;
import java.util.List;

/**
 * Z 字形变换
 * 根据每个字母在哪一行上找规律，如果是3行，则字母行数的变化规律为： 1 2 3 2 1 2 3 2 1 2 3 ……
 * 将在相同行的字母放在同一个list中，有3行，则有三个list。主要点在于要控制转折点
 * 将3个list拼接，得到最后的结果
 */
public class Leetcode_6 {

    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        char[] chars = s.toCharArray();
        List<StringBuilder> result = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            // 定义与行数相同个list
            result.add(new StringBuilder());
        }
        int i = 0; // 表示是存放结果的第几个list
        boolean isAdd = true; // 是否是按照递增的顺序添加
        for (char c : chars) {
            result.get(i).append(c);
            if (isAdd) {
                // 递增添加，i增大
                i++;
                if (i + 1 == numRows) {
                    // 如果i到了最大，则需要反向添加
                    isAdd = false;
                }
            } else {
                // 递减添加，i减小
                i--;
                if (i == 0) {
                    // 如果i到了最小，则需要反向添加
                    isAdd = true;
                }
            }
        }
        StringBuilder r = new StringBuilder();
        for (StringBuilder b : result) {
            r.append(b);
        }
        return r.toString();
    }

    // 题解中的简洁写法
    public String convert1(String s, int numRows) {
        if(numRows < 2) return s;
        List<StringBuilder> rows = new ArrayList<StringBuilder>();
        for(int i = 0; i < numRows; i++) rows.add(new StringBuilder());
        int i = 0, flag = -1;
        for(char c : s.toCharArray()) {
            rows.get(i).append(c);
            if(i == 0 || i == numRows -1) flag = - flag;
            i += flag;
        }
        StringBuilder res = new StringBuilder();
        for(StringBuilder row : rows) res.append(row);
        return res.toString();
    }

    public static void main(String[] args) {
        Leetcode_6 test = new Leetcode_6();

        String t = "PAYPALISHIRING";
        String r = test.convert(t, 3);
        System.out.println(r);
    }
}
