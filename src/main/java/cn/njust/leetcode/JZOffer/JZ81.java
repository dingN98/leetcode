package cn.njust.leetcode.JZOffer;

public class JZ81 {
    //输入一个长度为 n 整数数组，数组里面可能含有相同的元素，
    // 实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前面部分，所有的偶数位于数组的后面部分，对奇数和奇数，偶数和偶数之间的相对位置不做要求，
    // 但是时间复杂度和空间复杂度必须如下要求。
    //数据范围：0 \le n \le 500000≤n≤50000，数组中每个数的值 0 \le val \le 100000≤val≤10000
    //要求：时间复杂度 O(n)O(n)，空间复杂度 O(1)O(1)

    public int[] reOrderArrayTwo (int[] array) {
        // write code here
        int len = array.length;
        // idx 代表奇数后的第一个偶数  或者没有奇数时，第一个偶数
        int idx = 0;
        int flag = 0;
        for(int i=0;i<len;i++){
            int tmp = array[i];
            if(tmp%2==1){
                swap(array,i,idx);
                idx++;
            }else{
                if(flag==0){
                    idx = i;
                    flag = 1;
                }

            }
        }
        return array;
    }

    public void swap(int[] nums,int i,int j){
        int len = nums.length;
        if(i==j || i<0 || j<0 || i>=len || j>=len){
            return;
        }
        int tmp1 = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp1;
    }

    public static void main(String[] args) {
        int[] nums = {2,4,6,5,7};
        int[] res = new JZ81().reOrderArrayTwo(nums);
        for(int tmp:res){
            System.out.print(tmp+" ");
        }
    }
}
