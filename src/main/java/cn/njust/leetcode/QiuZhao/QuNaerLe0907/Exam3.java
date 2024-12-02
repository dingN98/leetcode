package cn.njust.leetcode.QiuZhao.QuNaerLe0907;

import java.util.HashMap;
import java.util.Map;

public class Exam3 {

    public String showDown (String inHand) {
        // write code here
        Map<Character,Integer> map1 = new HashMap<>();
        map1.put('S',0);
        map1.put('H',1);
        map1.put('C',2);
        map1.put('D',3);
        Map<String,Integer> map2 = new HashMap<>();
        map2.put("J",10);
        map2.put("Q",11);
        map2.put("K",12);
        map2.put("A",0);

        int[][] hd_count = new int[4][13];
        int[] h_count = new int[4];
        int[] d_count = new int[13];

        String[] inHandList = inHand.split(" ");
        for(int n=0;n<inHandList.length;n++){
            String s = inHandList[n];
            int i = map1.get(s.charAt(0));
            String dian = s.substring(1);
            Integer j = map2.get(dian);
            if(j==null){
                j = Integer.valueOf(dian)-1;
            }
            hd_count[i][j] ++;
            h_count[i]++;
            d_count[j]++;
        }
        //
        for(int i=0;i<4;i++){
            int j=9;
            for(;j<13;j++){
                if(hd_count[i][j]==0){
                    break;
                }
                if(j==12 && hd_count[i][0]>0){
                    return "HuangJiaTongHuaShun";
                }
            }
        }
        //
        for(int i=0;i<4;i++){
            int count = 0;
            for(int j=0;j<13;j++){
                if(hd_count[i][j]>0){
                    count++;
                }else{
                    if(count>=5){
                        return "TongHuaShun";
                    }else{
                        count = 0;
                    }
                }
            }
        }

        Map<Integer,Integer> cmap = new HashMap<>();
        for(int i=0;i<13;i++){
            int count = cmap.getOrDefault(d_count[i],0);
            cmap.put(d_count[i],count+1);
        }
        //
        if(cmap.containsKey(4)){
            return "SiTao";
        }
        //HuLu
        if(cmap.containsKey(3)&&cmap.containsKey(2)){
            return "HuLu";
        }
        //
        for(int i=0;i<4;i++){
            if(h_count[i]>=5){
                return "TongHua";
            }
        }
        //
        int count = 0;
        for(int i=0;i<13;i++){
            if(d_count[i]>0){
                count++;
            }else{
                if(count>=5){
                    return "ShunZi";
                }else{
                    count = 0;
                }
            }
        }
        //
        if(cmap.containsKey(3)){
            return "SanTiao";
        }
        //
        if(cmap.get(2)>=2){
            return "LiangDui";
        }
        //
        if(cmap.get(2)==1){
            return "YiDui";
        }
        return "GaoPai";


    }

    public static void main(String[] args) {
        String inHand = "SA SK SQ SJ S10 H10 C9";
        String res = new Exam3().showDown(inHand);
        System.out.println(res);
    }
}
