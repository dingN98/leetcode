package cn.cetc28.leetcode;

import javax.lang.model.type.ErrorType;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author dingnan98
 * @project leetcode
 * @date 2024/12/4 20:18
 * 017 电话号码的字母组合
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 */
public class Test1204a {


    public static void main(String[] args) {
        Test1204a t = new Test1204a();
        System.out.println(t.letterCombinations("23"));

    }
    public static HashMap<Character,String> map = new HashMap<>();

    public List<String> letterCombinations(String digits) {
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        List<String> res = new ArrayList<>();
        fun(digits,0,"",res);
        return res;
    }

    /**
     * 广度优先遍历
     * @param digits 数字序列
     * @param depth 递归深度
     * @param path 路径
     * @param res 结果
     */
    public void fun(String digits,int depth,String path,List<String> res){

        int len = digits.length();
        if(depth>=len){
            if(!"".equals(path)){
                res.add(path);
            }
            return;
        }
        String ziMu = map.get(digits.charAt(depth));
        for(int j=0;j<ziMu.length();j++){
            fun(digits,depth+1,path+ziMu.charAt(j),res);
        }
    }
}
