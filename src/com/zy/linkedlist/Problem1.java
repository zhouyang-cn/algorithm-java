package com.zy.linkedlist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 请编写一个函数，使其可以删除某个链表中给定的（非末尾的）节点，您将只被给予要求被删除的节点。
 * 比如：假设该链表为 1 -> 2 -> 3 -> 4  ，给定您的为该链表中值为 3 的第三个节点，那么在调用了您的函数之后，该链表则应变成 1 -> 2 -> 4 。
 * <br/><br/>
 * <a href='https://leetcode-cn.com/problems/delete-node-in-a-linked-list/description/'>删除链表中的节点</a>
 */
class Solution {
    public void deleteNode(ListNode node, int n) {
        if (node == null || node.next == null) {
            // 要删除的节点为null或者下个节点为null（即当前节点为最后一个节点），不符合题目规则，直接return
            return;
        }
        while (node != null) {
            if (node.val == n) {
                ListNode nextNode = node.next;
                node.val = nextNode.val;
                node.next = nextNode.next;
            }
            node = node.next;
        }
    }
}

public class Problem1 {

    public static void main(String[] args) {
        // 测试数据
        // line1输入： [1,2,3,4]
        // line2输入：3
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        try {
            while ((line = in.readLine()) != null) {
                ListNode node = stringToListNode(line);
                line = in.readLine();
                int n = Integer.parseInt(line);

                new Solution().deleteNode(node, n);
                String out = listNodeToString(node);

                System.out.print(out);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for (int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static ListNode stringToListNode(String input) {
        // Generate array from the input
        int[] nodeValues = stringToIntegerArray(input);

        // Now convert that list into linked list
        ListNode dummyRoot = new ListNode(0);
        ListNode ptr = dummyRoot;
        for (int item : nodeValues) {
            ptr.next = new ListNode(item);
            ptr = ptr.next;
        }
        return dummyRoot.next;
    }

    public static String listNodeToString(ListNode node) {
        if (node == null) {
            return "[]";
        }

        String result = "";
        while (node != null) {
            result += Integer.toString(node.val) + ", ";
            node = node.next;
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
