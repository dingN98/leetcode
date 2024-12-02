package cn.njust.leetcode.QiuZhao.XiaoHongShu0904;

public class Exam2 {

    public static int fun(int[] nums){
        int cnt = 0;
        int len = nums.length;
        // 首先判断乘积正负号  找到最大数下标和最小数下标
        int flag = 0;
        int zeroCnt = 0;
        int nearZero = Integer.MAX_VALUE;
        int indexNearZero = 0;
//        int indexMaxV = 0;
//        int indexMinV = 0;
        for(int i=0;i<len;i++){
//            indexMaxV = nums[indexMaxV]<nums[i]?i:indexMaxV;
//            indexMinV = nums[indexMinV]>nums[i]?i:indexMinV;
            if(nums[i]!=0){
                if(Math.abs(nums[i])<Math.abs(nearZero)){
                    nearZero = nums[i];
                    indexNearZero = i;
                }
            }
            if(nums[i]<0){
                flag++;
            }else if(nums[i]==0){
                zeroCnt++;
            }
        }
        // 如果乘积为正  将所有的0变为1即可
        if(flag%2==0){
            cnt += zeroCnt;
        }
        // 如果乘积为负
        if(flag%2==1){
            if(zeroCnt>0){
                // 一个变为-1，其他变为1
                cnt += zeroCnt;
            }else{
                // 将最接近0的数变为-1
                cnt += Math.abs(nearZero+1);
                nums[indexNearZero] = -1;
            }
        }
        // 将0变为1或者-1
        for(int i=0;i<len;i++){
            if(nums[i]==0){
                nums[i] = flag%2==0?1:-1;
                cnt++;
            }
        }
        // 判断最大值和最小值
        if(flag%2==0){
            //乘积是正数
//            if(nums[indexMaxV]>0){
//                int tmp = 0;
//                for(int i=0;i<len;i++){
//
//                }
//            }
        }

        return 0;
    }



    public static void main(String[] args) {

    }
}
