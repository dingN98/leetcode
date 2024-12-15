package cn.cetc28.leetcode;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author dingnan98
 * @project leetcode
 * @date 2024/12/15 14:31
 * 049 字母异位词分组
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 *
 * 字母异位词 是由重新排列源单词的所有字母得到的一个新单词。
 *
 *
 *
 * 示例 1:
 *
 * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 */
public class Test1215d {

    public static void main(String[] args) {

        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        Test1215d t = new Test1215d();
        System.out.println(t.groupAnagrams(strs));

    }

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<HashMap<Character, Integer>,List<String>> map = new HashMap<>();
        for(int i=0;i<strs.length;i++){
            String str = strs[i];
            HashMap<Character,Integer> map2 = new HashMap<>();
            for(int j=0;j<str.length();j++){
                Character ch = str.charAt(j);
                if(map2.containsKey(ch)){
                    map2.put(ch,map2.get(ch)+1);
                }else{
                    map2.put(ch,1);
                }
            }
            if(map.containsKey(map2)){
                map.get(map2).add(str);
            }else{
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(map2,list);
            }
        }
//        System.out.println(map);
        return new ArrayList<>(map.values());

    }
}
