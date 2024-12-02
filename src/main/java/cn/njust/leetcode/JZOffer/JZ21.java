package cn.njust.leetcode.JZOffer;

public class JZ21 {

    // 输入一个长度为 n 整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前面部分，所有的偶数位于数组的后面部分，
    // 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
    public int[] reOrderArray (int[] array) {
        // write code here
        int len = array.length;
        int idx = 0;
        int flag = 0;

        for(int i=0;i<len;i++){
            int tmp = array[i];
            if(tmp%2==1){
                // 是奇数 需要和前面的第一个偶数交换位置
                swap(array,i,idx);
                // 偶数和偶数交换位置 确保顺序
                for(int j=idx+1;j<i;j++){
                    swap(array,i,j);
                }
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
        if(i<0 || j<0 || i>=len || j>=len || i==j){
            return;
        }
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] array = {2,4,6,5,7};
        int[] res = new JZ21().reOrderArray(array);
        for(int tmp:res){
            System.out.print(tmp+" ");
        }

    }
}
