package cn.njust.leetcode.Huawei0920;

public class Exam1 {
    public static void main(String[] args) {
        int[][] nums = {{1,2,2,1},{3,1,2},{1,3,2},{2,4},{3,1,2},{1,3,1,1}};
        int res = new Exam1().fun(nums);
        System.out.println(res);
    }
    public int fun(int[][] nums){
        int d = 0;
        for(int i=0;i<nums[0].length;i++){
            d += nums[0][i];
        }
        int[][] nums2 = new int[nums.length][d];
        for(int i=0;i<nums.length;i++){
            int idx = 0;
            for(int j=0;j<nums[i].length;j++){
                int tmp = nums[i][j];
                for(int k=0;k<tmp;k++){
                    idx+=k;
                    nums2[i][idx] = tmp;
                }
            }
        }
        int maxLen = 0;
        for(int i=0;i< nums2.length-1;i++){
            int tmpLen = 0;
            for(int j=0;j<nums2.length;j++){
                if(nums2[j][i]!=nums2[j][i+1]){
                    tmpLen++;
                }
            }
            maxLen = Math.max(maxLen,tmpLen);
        }
        return maxLen;
    }
}
