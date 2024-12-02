package cn.njust.leetcode.QiuZhao.MeiDi0911;

import java.util.Map;

public class Exam1 {

    public int maxPointsNum (Point[] points) {
        // write code here
        int len = points.length;
        if(len<=2){
            return len;
        }
        int res = 1;
        for(int i=0;i<len;i++){
            for(int j=i+1;j<len;j++){
                int cur = 2;
                for( int k=j+1;k<len;k++){
                    Point p1 = points[i];
                    Point p2 = points[j];
                    Point p3 = points[k];
                    int k1 = (p2.y-p1.y)*(p3.x-p2.x);
                    int k2 = (p3.y-p2.y)*(p2.x-p1.x);
                    if(k1==k2){
                        cur++;
                    }
                }
                res = Math.max(res,cur);
            }
        }
        return res;
    }

    public static void main(String[] args) {



    }
}
