/**
 * 斐波那契数列
 */
public class LeetCode_509 {

    public int fib(int n) {
        // 0 1 1 2 3 5 8
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        int i = 3;
        int bbNum = 0;
        int bNum = 1;
        while (i <= n) {
            int temp = bNum;
            bNum = bbNum + bNum;
            bbNum = temp;
            i++;
        }
        return bbNum + bNum;
    }

    public int t(int n) {
        // 0 1 1 2 3 5 8
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        int i = 3;
        int bbNum = 0;
        int bNum = 1;
        int result = 0;
        while (i <= n + 1) {
            result = bbNum + bNum;
            bbNum = bNum;
            bNum = result;
            i++;
        }
        return result;
    }

    public static void main(String[] args) {
        LeetCode_509 test = new LeetCode_509();
//        int t = test.fib(4);
        int t = test.t(11);
        System.out.println(t);
    }

}
