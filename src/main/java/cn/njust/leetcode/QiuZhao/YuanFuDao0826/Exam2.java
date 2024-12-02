package cn.njust.leetcode.QiuZhao.YuanFuDao0826;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Exam2 {

    public ArrayList<Integer> fun(int n){
        ArrayList<Integer> res = new ArrayList<>();
        int i = 2;
        while (i<Math.sqrt(n)+1){
            //判断是否是质数
            if (i*i>n){
                res.add(n);
                break;
            }
            if (n%i == 0){
                res.add(i);
                n=n/i;
                i=2;
                continue;
            }
            i++;
        }
        return res;
    }

    public int solution(int n,int[] nums){
        int len = nums.length;
        ArrayList<Integer> primes = fun(n);
//        System.out.println(primes);
        int min = Integer.MAX_VALUE;
        for(int k=0;k<len;k++){
            boolean[] visited = new boolean[primes.size()];
            int left = -1;
            int right = 0;
            int cnt = 0;
            int flag = 0;
            for(int i=k;i<len && flag==0;i++){
                for(int j=0;j<primes.size();j++){
                    if(visited[j]){
                        continue;
                    }
                    int num1 = nums[i];
                    int num2 = primes.get(j);
                    if(num1==num2){
                        cnt++;
//                        System.out.println("j="+j+"    cnt="+cnt);
                        visited[j] = true;
                        if(left==-1){
                            left = i;
                        }
                        if(cnt == primes.size()){
                            right = i;
                            int tmp = right-left+1;
//                            System.out.println(tmp+"  ["+left+","+right+"]"+"   size="+cnt);
                            min = Math.min(min,tmp);
                            flag = 1;
                        }
                        break;
                    }
                }
            }
        }
        return min==Integer.MAX_VALUE?-1:min;

    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int turns = scanner.nextInt();
        for(int t=0;t<turns;t++){
            int n = scanner.nextInt();
            int len = scanner.nextInt();
            int[] nums = new int[len];
            for(int m=0;m<len;m++){
                nums[m] = scanner.nextInt();
            }
            int res = new Exam2().solution(n,nums);
            System.out.println(res);
        }

//        int n = 20;
//        int[] nums = {1,2,3,2,6,5,2,1};
//

    }
}
