package lc_15_三数之和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 题解解法：
 * 标签：数组遍历
 * 首先对数组进行排序，排序后固定一个数 nums[i]，再使用左右指针指向 nums[i]后面数组的两端，数字分别为 nums[L] 和 nums[R]，计算三个数的和 sum 判断是否满足为 0，满足则添加进结果集
 * 因为数组已经排好序，如果 nums[i]大于 0，则三数之和必然无法等于 0，结束循环
 * 如果 nums[i] == nums[i-1]，则说明该数字重复，会导致结果重复，所以应该跳过
 * 当 sum == 0 时，nums[L]== nums[L+1] 则会导致结果重复，应该跳过，L++
 * 当 sum == 0 时，nums[R] == nums[R−1] 则会导致结果重复，应该跳过，R--
 * 时间复杂度：O(n^2)，n 为数组长度
 */
public class Solution {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList();
        int len = nums.length;
        if(nums == null || len < 3) return ans;
        Arrays.sort(nums); // 排序数组
        for (int i = 0; i < len ; i++) {
            if(nums[i] > 0) break; // 因为数组已经从小到大排好序，如果当前数字大于0，则三数之和一定大于0，所以结束循环
            if(i > 0 && nums[i] == nums[i-1]) continue; // 去重
            int left = i + 1;
            int right = len - 1;
            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == 0){
                    ans.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) left++; // 向后移动left,去重
                    while (left < right && nums[right] == nums[right - 1]) right--; // 向前移动right，去重
                    left++;
                    right--;
                }
                else if (sum < 0) left++;
                else if (sum > 0) right--;
            }
        }
        return ans;
    }

}
