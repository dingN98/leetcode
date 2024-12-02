package cn.njust.leetcode.Huawei0920;

public class LK415 {

    // 字符串相加
    public String addStrings(String num1, String num2) {
        return fun(num1,num2,0);
    }

    public String fun(String num1,String num2,int jinWei){
        if(num1.length()==0 && num2.length()==0){
            return jinWei==0?"":"1";
        }
        if(num1.length()==0){
            return fun(jinWei+"",num2,0);
        }
        if(num2.length()==0){
            return fun(num1,jinWei+"",0);
        }

        int idx1 = num1.length()-1;
        int idx2 = num2.length()-1;
        StringBuilder res = new StringBuilder();
        while(idx1>=0 && idx2>=0){
            int n1 = Integer.parseInt(num1.charAt(idx1)+"");
            int n2 = Integer.parseInt(num2.charAt(idx2)+"");
            int sum = n1+n2+jinWei;
            jinWei = sum/10;
            res.append(sum%10);
            idx1--;
            idx2--;
        }
        return fun(num1.substring(0,idx1+1),num2.substring(0,idx2+1),jinWei)+res.reverse().toString();
    }

    public static void main(String[] args) {
        String num1 = "11";
        String num2 = "123";
        System.out.println(new LK415().addStrings(num1,num2));
    }
}
