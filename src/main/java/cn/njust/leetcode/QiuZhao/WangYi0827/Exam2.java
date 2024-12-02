package cn.njust.leetcode.QiuZhao.WangYi0827;

public class Exam2 {

    public int fun(int[][] nums){
        int len = nums.length;
        boolean[] good = new boolean[len];
        // 判断矩形是否有效
        for(int i=0;i<len;i++){
//            int flag = 0;
            for(int j=i+1;j<len;j++){
                if(cross(nums,i,j)){
//                    flag = 1;
                    good[i] = true;
                    good[j] = true;
                    break;
                }
            }
//            if(flag==1){
//                good[i] = true;
//                good[] = true;
//                System.out.println("第"+i+"个矩形是好的");
//            }
        }
        // 计算面积
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxX = 0;
        int maxY = 0;
        for(int i=0;i<len;i++){
            if(good[i]){
                int[] c1 = nums[i];
                int x01 = c1[0];
                int y01 = c1[1];
                int x02 = c1[2];
                int y02 = c1[3];
                minX = Math.min(minX,Math.min(x01,x02));
                minY = Math.min(minY,Math.min(y01,y02));
                maxX = Math.max(maxX,Math.max(x01,x02));
                maxY = Math.max(maxY,Math.max(y01,y02));
            }
        }
        int res = 0;
        System.out.println(minX+","+minY+"  "+maxX+","+maxY);
        for(int i=minX;i<maxX;i++){
            for(int j=minY;j<maxY;j++){
                if(inR(i,j,nums)){
                    System.out.println(i+","+j+"  在");
                    res++;
                }
            }
        }
        return res;
    }

    public boolean inR(int x,int y,int[][] nums){
        for(int i=0;i<nums.length;i++){
            int[] c1 = nums[i];
            int x01 = c1[0];
            int y01 = c1[1];
            int x02 = c1[2];
            int y02 = c1[3];
            if(x>=x01 && y>=y01 && x<x02 && y<y02){
                return true;
            }
        }
        return false;
    }

    public boolean cross(int[][] nums,int i,int j){
        int[] c1 = nums[i];
        int[] c2 = nums[j];
        int x01 = c1[0];
        int y01 = c1[1];
        int x02 = c1[2];
        int y02 = c1[3];

        int x11 = c2[0];
        int y11 = c2[1];
        int x12 = c2[2];
        int y12 = c2[3];

        int zx = Math.abs(x01 + x02 -x11 - x12);
        int x  = Math.abs(x01 - x02) + Math.abs(x11 - x12);
        int zy = Math.abs(y01 + y02 - y11 - y12);
        int y  = Math.abs(y01 - y02) + Math.abs(y11 - y12);
        if(zx < x && zy < y)
            return true;
        else
            return false;

    }

    public static void main(String[] args) {
        int[][] nums = {{0,0,2,2},{1,1,4,3},{2,4,4,7},{2,5,3,6}};
//        int[][] nums = {{0,0,2,2},{1,1,4,3}};
//        int[][] nums = {{0,0,1,1},{1,1,2,2},{1,0,2,1}};
        int res = new Exam2().fun(nums);
        System.out.println(res);




    }
}
