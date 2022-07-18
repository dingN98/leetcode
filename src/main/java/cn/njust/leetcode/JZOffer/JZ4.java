package cn.njust.leetcode.JZOffer;


public class JZ4 {
    public boolean Find(int target, int [][] array) {
        int rows = array.length;
        int cols = array[0].length;

        // 下面这三行会报越界  不知为何
//        if(target<array[0][0] || target>array[rows-1][cols-1]){
//            return false;
//        }

        // 从左下角开始 ， 比它大的话  右移  ；反之  上移
        for(int i=rows-1,j=0;i>=0&&j<cols;){
            int tmp = array[i][j];

            if(target==tmp){
//                System.out.println("("+i+","+j+")");
                return true;
            }
            if(target>tmp){
                j++;
            }else{
                i--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] nums = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};

        boolean res = new JZ4().Find(9,nums);
        System.out.println(res);

    }
}
