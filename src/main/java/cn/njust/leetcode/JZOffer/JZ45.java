package cn.njust.leetcode.JZOffer;

import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;

public class JZ45 {

    String minV = "MAX";

    public String PrintMinNumber(int [] numbers) {
        if(numbers.length==0){
            return "";
        }


        // numbers 数组 转 String数组



        int len = numbers.length;

        boolean[] visited = new boolean[len];

        String[] nums = new String[len];

        for(int i=0;i< len;i++){
            nums[i] = numbers[i]+"";
        }

        // dfs
        search(nums,0,"",visited);
        return minV;

    }

    public void search(String[] nums,int k,String path,boolean[] visited){

        if(k==nums.length){
            // 比较大小
            if(minV.equals("MAX")){
                minV = path;
                return;
            }
            if(path.length() < minV.length()){
                minV = path;
            }else if(path.length()==minV.length()){
                minV = minV.compareTo(path)>0?path:minV;
            }
        }

        for(int i=0;i<nums.length;i++){
            if(!visited[i]){
                visited[i] = true;
                search(nums,k+1,path+nums[i],visited);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
//        int[] numbers = {1,2,3};
//        int[] numbers = {3,32,321};
        int[] numbers = {};
        String res = new JZ45().PrintMinNumber(numbers);
        System.out.println(res);
    }
}
