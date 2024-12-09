package cn.cetc28.leetcode;

import javax.lang.model.type.ErrorType;

/**
 * @author dingnan98
 * @project leetcode
 * @date 2024/12/6 22:42
 * 028 找出字符串中第一个匹配项的下标
 * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。如果 needle 不是 haystack 的一部分，则返回  -1 。
 *
 *
 */
public class Test1206b {

    public static void main(String[] args) {

    }

    public int strStr(String haystack, String needle) {
        // haystack = "sadbutsad", needle = "sad"
        int len1 = haystack.length();
        int len2 = needle.length();
        if(len1<len2){
            return -1;
        }
        for(int i=0;i<=len1-len2;i++){
            if(haystack.substring(i,i+len2).equals(needle)){
                return i;
            }
        }
        return -1;

    }
}
