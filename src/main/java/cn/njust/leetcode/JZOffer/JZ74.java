package cn.njust.leetcode.JZOffer;

import java.util.*;

public class JZ74 {

    // 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
    // 但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
    // 没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。
    // 现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列?
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        // 滑动窗口+双指针
        // 从 [1,2] 开始  俩指针只能右移
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        for(int left = 1,right=2;left<right;){
            // 计算区间和
            int tmp = (left+right)*(right-left+1)/2;
            if(tmp==sum){
                ArrayList<Integer> tmp2 = new ArrayList<>();
                for(int i=left;i<=right;i++){
                    tmp2.add(i);
                }
                res.add(tmp2);
                left++;
            }else if(tmp<sum){
                right++;
            }else{
                left++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> res = new JZ74().FindContinuousSequence(9);
        System.out.println(res);

    }
}
