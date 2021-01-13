/**
 *
 */
class LeetCodeTest {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;
            while (j < nums.length) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                } else {
                    j++;
                }
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {

    }
}