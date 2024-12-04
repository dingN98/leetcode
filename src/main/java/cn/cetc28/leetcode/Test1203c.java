package cn.cetc28.leetcode;

import javax.swing.text.StyledEditorKit;

/**
 * @author dingnan98
 * @project leetcode
 * @date 2024/12/3 22:43
 * 014 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 */
public class Test1203c {

    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        Test1203c t = new Test1203c();
        System.out.println(t.longestCommonPrefix(strs));


    }

    public String longestCommonPrefix(String[] strs) {
        int len = strs.length;
        if(len==0){
            return "";
        }
        if(len==1){
            return strs[0];
        }
        int index = 0;
        int indexMax = Integer.MAX_VALUE;
        for(int i=0;i<len;i++){
            indexMax = Math.min(indexMax,strs[i].length()-1);
        }
        StringBuffer res = new StringBuffer();
        while (index<=indexMax){
            char ch = strs[0].charAt(index);
            for(int i=1;i<len;i++){
                if(strs[i].charAt(index)!=ch){
                    return res.toString();
                }
            }
            res.append(ch);
            index++;
        }
        return res.toString();
    }
}
