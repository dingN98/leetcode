package cn.njust.leetcode.Huawei0920;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LK554 {

    public int leastBricks(List<List<Integer>> wall) {

        HashMap<Integer,Integer> map = new HashMap<>();
        int maxLen = 0;
        for(int i=0;i<wall.size();i++){
            List<Integer> line = wall.get(i);
            int sumTmp = 0;
            for(int j=0;j<line.size()-1;j++){
                sumTmp+=line.get(j);
                if(map.containsKey(sumTmp)){
                    map.put(sumTmp,map.get(sumTmp)+1);
                }else{
                    map.put(sumTmp,1);
                }
                maxLen = Math.max(maxLen,map.get(sumTmp));
            }
        }
        return wall.size()-maxLen;
    }





}
