package com.zy.array;

/**
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * <br/><br/>
 * <a href='https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/21/'>从排序数组中删除重复项</a>
 */
public class Problem1 {
    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int len = new Solution().removeDuplicates(nums);
        String out = integerArrayToString(nums, len);
        System.out.print(out);
    }

    public static String integerArrayToString(int[] nums, int length) {
        if (length == 0) {
            return "[]";
        }

        String result = "";
        for (int index = 0; index < length; index++) {
            int number = nums[index];
            result += Integer.toString(number) + ", ";
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }
}

class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null) {
            return 0;
        }
        if (nums.length <= 1) {
            return nums.length;
        }
        // 新数组的下标
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[index] != nums[i]) {
                // 数组第i个元素和新数组第index不相等时，需要将下标为i的元素值放到新数组index+1位置
                nums[++index] = nums[i];
            }
        }
        // 循环结束计算出新数组最后一个元素的下标index；so数组的长度为index+1
        return index + 1;
    }
}
