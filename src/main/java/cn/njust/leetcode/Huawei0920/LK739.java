package cn.njust.leetcode.Huawei0920;

public class LK739 {

    public int[] dailyTemperatures(int[] temperatures) {

        int len = temperatures.length;
        int[] res = new int[len];
        res[len-1] = 0;
        for(int i=len-2;i>=0;i--){
            int flag = 0;
            int idx = i+1;
            while (idx<len && temperatures[i]>=temperatures[idx]){
                if(res[idx]==0){
                    flag = 1;
                    break;
                }
                idx += res[idx];
            }
            if(idx>=len){
                flag = 1;
            }
            if(flag==0){
                res[i] = (idx-i);
            }else{
                res[i] = 0;
            }
        }
        return res;

    }

    public static void main(String[] args) {

        int[] temperatures = {73,74,75,71,69,72,76,73};
        int[] res = new LK739().dailyTemperatures(temperatures);
        for(int tmp:res){
            System.out.print(tmp+" ");
        }

    }
}
