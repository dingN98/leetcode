package cn.cetc28.leetcode;

import jdk.internal.org.objectweb.asm.tree.IincInsnNode;

import javax.crypto.Cipher;
import javax.swing.text.StyledEditorKit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author dingnan98
 * @project leetcode
 * @date 2024/12/8 10:49
 * 030 串联所有单词的子串
 * 给定一个字符串 s 和一个字符串数组 words。 words 中所有字符串 长度相同。
 *
 *  s 中的 串联子串 是指一个包含  words 中所有字符串以任意顺序排列连接起来的子串。
 */
public class Test1208a {

    public static void main(String[] args) {

        Test1208a t = new Test1208a();
        String[] words = {"aa","aa"};
        String s = "aaaaaaaaaaaaaa";
        List<Integer> res = t.findSubstring2(s, words);
        System.out.println(res);

    }

    // s = "barfoothefoobarman", words = ["foo","bar"]
    // 方法二 看题解 滑动窗口
    public List<Integer> findSubstring2(String s, String[] words){
        List<Integer> res = new ArrayList<>();
        int lenSum = 0;
        for(int i=0;i<words.length;i++){
            lenSum+=words[i].length();
        }
        if(s.length()<lenSum){
            return new ArrayList<>();
        }
        int wordSize = words[0].length();
        int left = 0;
        int right = 0;
        HashMap<String,Integer> map = new HashMap<>();
        while(left<s.length()){
            for(int i=0;i<words.length;i++){
                map.put(words[i],0);
            }
            for(int i=0;i<words.length;i++){
                map.put(words[i],map.get(words[i])+1);
            }
//            System.out.println(map);
            right = left;
            boolean isWord = false;
            while (right<=s.length()-wordSize){
                String str = s.substring(right,right+wordSize);
                if(!map.containsKey(str)){
                    break;
                }else{
                    isWord = true;
                    map.put(str,map.get(str)-1);
                    right+=wordSize;
                    // 看所有的word是否都访问过
                    boolean isAllVisited = true;
                    for(int i=0;i<words.length;i++){
                        if(map.get(words[i])!=0){
                            isAllVisited = false;
                        }
                    }
                    if(isAllVisited){
                        res.add(left);
                        break;
                    }
                }
            }
            if(isWord){
                if((left+1)<s.length()&&s.charAt(left)==s.charAt(left+1)){
                    left++;
                }else{
                    left+=wordSize;
                }
            }else{
                left++;
            }
        }
        return res;
    }


    // 方法一  搜索+匹配，会超时
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        int lenSum = 0;
        for(int i=0;i<words.length;i++){
            lenSum+=words[i].length();
        }
        if(s.length()<lenSum){
            return new ArrayList<>();
        }

        boolean[] visited = new boolean[words.length];
        List<String> wList = new ArrayList<>();
        fun(words,visited,"",wList);
        System.out.println(wList);

        int len = wList.size();
        for(int i=0;i<len;i++){
            int index = s.indexOf(wList.get(i));
            if(index!=-1){
                res.add(index);
            }
        }
        return res;
    }

    public void fun(String[] words,boolean[] visited,String path,List<String> res){
        int len = words.length;
        boolean flag = true;
        for(int i=0;i<len;i++){
            if(!visited[i]){
                flag = false;
                visited[i] = true;
                fun(words,visited,path+words[i],res);
                visited[i] = false;
            }
        }
        if(flag && !res.contains(path)){
            res.add(path);
        }
    }

}
