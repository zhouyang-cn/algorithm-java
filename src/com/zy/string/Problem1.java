package com.zy.string;

/**
 * 请编写一个函数，其功能是将输入的字符串反转过来。
 * <br/><br/>
 * <a href='https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/5/strings/32/'>反转字符串</a>
 */
public class Problem1 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String str = "hello world";
        String reverseString = solution.reverseString(str);
        System.out.println(reverseString);
    }
}

class Solution {
    public String reverseString(String s) {
        if (s == null) {
            return "";
        }
        StringBuilder builder = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            builder.append(s.charAt(i));
        }
        return builder.toString();
    }
}
