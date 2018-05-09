package com.zy.string;

/**
 * 请编写一个函数，其功能是将输入的字符串反转过来。
 * <br/><br/>
 * <a href='https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/5/strings/32/'>反转字符串</a>
 */
public class Problem1 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String str = "HelloWorld";
        String reverseString = solution.reverseString(str);
        System.out.println(reverseString);
    }
}

class Solution {
    public String reverseString(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        int length = str.length();
        char[] array = str.toCharArray();
        for (int i = 0; i < length; i++) {
            array[i] = str.charAt(length - 1 - i);
        }
        return new String(array);
    }

    public String reverseString2(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        int length = str.length();
        char[] array = str.toCharArray();
        for (int i = 0; i < length / 2; i++) {
            array[i] = str.charAt(length - 1 - i);
            array[length - 1 - i] = str.charAt(i);
        }
        return new String(array);
    }
}
