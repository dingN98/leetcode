package cn.njust.leetcode.Huawei0920;

public class LK5 {

    // 5. 最长回文子串
    // 双指针 两边扩展
    public String longestPalindrome(String s) {

        char[] chs = s.toCharArray();
        int len = chs.length;
        int maxLen = 0;
        int maxLeft = 0;
        int maxRight = 0;
        for(int i=0;i<len;i++){
            int left = i;
            int right = i;
            while(left-1>=0 && chs[left]==chs[left-1]){
                left--;
            }
            while(right+1<len && chs[right]==chs[right+1]){
                right++;
            }
            while(left-1>=0 && right+1<len && chs[left-1]==chs[right+1]){
                left--;
                right++;
            }
            int tmpLen = right-left+1;
            if(tmpLen>maxLen){
                maxLeft = left;
                maxRight = right;
                maxLen = tmpLen;
            }
        }
        return s.substring(maxLeft,maxRight+1);

    }

    public static void main(String[] args) {

    }
}
