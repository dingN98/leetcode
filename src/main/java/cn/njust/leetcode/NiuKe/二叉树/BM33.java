package cn.njust.leetcode.NiuKe.二叉树;

import cn.njust.leetcode.JZOffer.二叉树.TreeNode;

import java.lang.management.MonitorInfo;

public class BM33 {

    public TreeNode Mirror (TreeNode pRoot) {
        // write code here
        if(pRoot==null){
            return null;
        }
        TreeNode tmp = pRoot.left;
        pRoot.left = Mirror(pRoot.right);
        pRoot.right = Mirror(tmp);

        return pRoot;
    }

    public static void main(String[] args) {

    }
}
