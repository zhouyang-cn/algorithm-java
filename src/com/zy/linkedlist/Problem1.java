package com.zy.linkedlist;

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
        // 删除链表[1,2,3,4]中节点值为3的节点
        ListNode node = NodeUtils.stringToListNode("[1,2,3,4]");
        new Solution().deleteNode(node, 3);
        String out = NodeUtils.listNodeToString(node);
        System.out.print(out);
    }


}
