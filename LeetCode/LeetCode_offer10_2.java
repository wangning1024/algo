import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer 10- II. 青蛙跳台阶问题
 * 与斐波那契数列类似，n个台阶的方法数，取决于 n-1 和 n-2 的结果
 */
public class LeetCode_offer10_2 {

    // 简单递归解法（超时了）
    public int numWays(int n) {
        if (n == 0) {
            return 1;
        }
        return rec(n);
    }
    private int rec(int n) {
        if (n <= 2) {
            return n % 1000000007;
        }
        return rec(n - 1) + rec(n - 2);
    }


    // ====================================================
    // 改进一点的递归，还是超出时间限制
    public int numWays1(int n) {
        if (n == 0) {
            return 1;
        }
        Map<Integer, Integer> rMap = new HashMap<>();

        return rec1(n, rMap);
    }
    private int rec1(int n, Map<Integer, Integer> rMap) {
        if (n <= 2) {
            return n;
        }
        if (rMap.containsKey(n)) {
            return rMap.get(n) % 1000000007;
        }
        return rec1(n - 1, rMap) + rec1(n - 2, rMap);
    }

    /**
     *
     * @param n
     * @return
     */
    public int numWays2(int n) {
        if (n == 0) {
            return 1;
        }
        if (n <= 2) {
            return n;
        }
        int a = 1, b = 1, sum;
        for (int i = 0; i < n; i++) {
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }

        return a;
    }

    public static void main(String[] args) {
        LeetCode_offer10_2 test = new LeetCode_offer10_2();
        System.out.println(test.numWays1(20));

        // 365010934
    }

}
