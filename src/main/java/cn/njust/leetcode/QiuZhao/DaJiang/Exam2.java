package cn.njust.leetcode.QiuZhao.DaJiang;

public class Exam2 {

    public int longestWPI(int[] hours) {
        int res = 0;
        int tmp = 0;
        int left = -1;
        int right = -1;
        for(int i=0;i<hours.length;i++){
            if(hours[i]>8){
                tmp++;
                if(left==-1){
                    left = i;
                    continue;
                }
                right = i;
            }else{
                res = Math.max(res,tmp);
                tmp = 0;
            }
        }
        return res;
    }

    public static void main(String[] args) {

        int[] hours = {9,9,6,0,6,6,9};
        int res = new Exam2().longestWPI(hours);
        System.out.println(res);

    }
}
