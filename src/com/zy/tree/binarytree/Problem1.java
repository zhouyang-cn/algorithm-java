package com.zy.tree.binarytree;

import com.zy.tree.NodeUtils;
import com.zy.tree.TreeNode;

import java.util.LinkedList;

/**
 *  <a href='https://leetcode-cn.com/problems/delete-node-in-a-linked-list/description/'>二叉树的最大深度</a>
 */
public class Problem1 {
    public static void main(String[] args) {
        TreeNode treeNode = NodeUtils.stringToTreeNode("[3,9,20,null,null,15,7]");
        int maxDepth = new Solution().maxDepth2(treeNode);
        System.out.println("[3,9,20,null,null,15,7]的最大深度为：" + maxDepth);
    }
}

class Solution {
    /**
     * 采用递归遍历
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }

    /**
     * 采用层序遍历
     * @param root
     * @return
     */
    public int maxDepth2(TreeNode root){
        if(root == null)
            return 0;
        int level = 0;
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int curNum = 1; //num of nodes left in current level
        int nextNum = 0; //num of nodes in next level
        while(!queue.isEmpty())
        {
            TreeNode n = queue.poll();
            curNum--;
            if(n.left!=null)
            {
                queue.add(n.left);
                nextNum++;
            }
            if(n.right!=null)
            {
                queue.add(n.right);
                nextNum++;
            }
            if(curNum == 0)
            {
                curNum = nextNum;
                nextNum = 0;
                level++;
            }
        }
        return level;
    }

}
