package cn.njust.leetcode.NiuKe.字符串;

public class BM86 {

    // BM86 大数加法
    public String solve (String s, String t) {
        // write code here
        return bigSum(s,t,0);
    }

    public String bigSum(String a,String b,int jinWei){
        if(a.length()==0 && b.length()==0){
            if(jinWei==1){
                return "1";
            }else{
                return "";
            }
        }
        if(a.length()==0){
            return bigSum(jinWei+"",b,0);
        }
        if(b.length()==0){
            return bigSum(a,jinWei+"",0);
        }
        int idxA = a.length()-1;
        int idxB = b.length()-1;
        StringBuilder res = new StringBuilder();
        while(idxA>=0 && idxB>=0){
            char tmp1 = a.charAt(idxA);
            char tmp2 = b.charAt(idxB);
            int tmp3 = Integer.parseInt(tmp1+"")+Integer.parseInt(tmp2+"")+jinWei;
            jinWei = tmp3/10;
            tmp3 = tmp3%10;
            res.insert(0,tmp3);
            idxA--;
            idxB--;
        }
        return bigSum(a.substring(0,idxA+1),b.substring(0,idxB+1),jinWei)+res.toString();
    }

    public static void main(String[] args) {

//        String a = "123456789";
//        String b = "23456780";
        String a = "1877";
        String b = "";
        String res = new BM86().solve(a,b);
        System.out.println(res);


    }
}
