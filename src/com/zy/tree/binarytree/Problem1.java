package com.zy.tree.binarytree;

import com.zy.tree.NodeUtils;
import com.zy.tree.TreeNode;

/**
 *  <a href='https://leetcode-cn.com/problems/delete-node-in-a-linked-list/description/'>二叉树的最大深度</a>
 */
public class Problem1 {
    public static void main(String[] args) {
        TreeNode treeNode = NodeUtils.stringToTreeNode("[3,9,20,null,null,15,7]");
        int maxDepth = new Solution().maxDepth(treeNode);
        System.out.println("[3,9,20,null,null,15,7]的最大深度为：" + maxDepth);
    }
}

class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }
}
