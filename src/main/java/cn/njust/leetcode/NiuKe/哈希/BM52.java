package cn.njust.leetcode.NiuKe.哈希;

import java.util.HashMap;

public class BM52 {

    // BM52 数组中只出现一次的两个数字
    public int[] FindNumsAppearOnce (int[] array) {
        // write code here
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            int num = array[i];
            if (map.containsKey(num)) {
                map.remove(num);
            } else {
                map.put(num, 1);
            }
        }
        int[] res = new int[2];
        int idx = 0;
        for(int tmp:map.keySet()){
            res[idx++] = tmp;
        }
        int minV = Math.min(res[0],res[1]);
        res[1] = Math.max(res[0],res[1]);
        res[0] = minV;
        return res;
    }


    public static void main(String[] args) {

    }
}
