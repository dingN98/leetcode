package cn.njust.leetcode.QiuZhao.MeiDi0826;

public class Exam2 {

    public int runCircuit(int[] gas,int[] cost){
        int len = gas.length;
        for(int i=0;i<len;i++){
            int oil = 0;
            for(int j=0;j<len;j++){
                int k = (i+j)%len;
                oil += gas[k];
                oil -= cost[k];
                if(oil<0){
                    break;
                }
            }
            if(oil>=0){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] gas = {3,3,1};
        int[] cost = {3,2,2};
//        int[] gas = {1,2,3,4,5};
//        int[] cost = {3,4,5,1,2};
        int res =  new Exam2().runCircuit(gas,cost);
        System.out.println(res);
    }
}
