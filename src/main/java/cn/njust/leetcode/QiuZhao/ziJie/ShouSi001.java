package cn.njust.leetcode.QiuZhao.ziJie;

public class ShouSi001 {

    /**
     * 标题
     * 小于n的最大数
     *
     * 题目描述
     * 给定一个数 n，如 23121；给定一组数字 A 如 {2,4,9}，求由 A 中元素组成的、小于 n 的最大数，如小于 23121 的最大数为 22999。
     */

    public static void main(String[] args) {

        int n = 23121;
        int[] nums = {2,3,4,9};
        String nStr = n+"";
        int flag = 0;
        for(int i=0;i<nStr.length();i++){
            int num = Integer.parseInt(nStr.charAt(i)+"");
            int num2 = 0;
            if(flag==1){
                System.out.print(9);
                continue;
            }
            for(int j=0;j<nums.length;j++){
                if(nums[j]<=num){
                    num2 = nums[j];
                    if(nums[j]<num){
                        flag=1;
                    }else{
                        // 必须有比下一位小的数
                        if((i+1)<nStr.length()){
                            int num3 = Integer.parseInt(nStr.charAt(i+1)+"");
                            int flag2 = 0;
                            for(int k=0;k<nums.length;k++){
                                if(nums[k]<num3){
                                    flag2=1;
                                    break;
                                }
                            }
                            if(flag2==0){
                                flag=1;
                                continue;
                            }else{
                                flag=0;
                                continue;
                            }
                        }
                        flag=0;
                    }
                }else{
                    break;
                }
            }
            System.out.print(num2);

        }

    }
}
