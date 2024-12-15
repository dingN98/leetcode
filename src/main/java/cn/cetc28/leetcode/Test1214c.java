package cn.cetc28.leetcode;

/**
 * @author dingnan98
 * @project leetcode
 * @date 2024/12/14 18:27
 * 043 字符串相乘
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 *
 * 注意：不能使用任何内置的 BigInteger 库或直接将输入转换为整数。
 *
 *
 *
 * 示例 1:
 *
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * 示例 2:
 *
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 */
public class Test1214c {

    public String multiply(String num1, String num2) {
        String res = "0";
        int zeroNum = 0;
        for(int i=num1.length()-1;i>=0;i--){
            StringBuilder tmpRes = new StringBuilder();
            int jinWei = 0;
            int yuShu = 0;
            int n1 = Integer.parseInt(num1.charAt(i)+"");
            for(int j=num2.length()-1;j>=0;j--){
                int n2 = Integer.parseInt(num2.charAt(j)+"");
                int n3 = n1*n2+jinWei;
                yuShu = n3%10;
                jinWei = n3/10;
                tmpRes.append(yuShu);
            }
            if(jinWei>0){
                tmpRes.append(jinWei);
            }
            tmpRes.reverse();
            for(int k=0;k<zeroNum;k++){
                tmpRes.append(0);
            }
            zeroNum++;
            res = add2(res,tmpRes.toString());
        }
        return res;
    }

    public String add2(String num1,String num2){
        int jinWei = 0;
        int yuShu = 0;
        StringBuilder res = new StringBuilder();
        int n1,n2,n3;
        for(int i=1;i<=num1.length()|| i<=num2.length();i++){
            if(i<=num1.length()){
                n1 = Integer.parseInt(num1.charAt(num1.length()-i)+"");
            }else{
                n1 = 0;
            }
            if(i<=num2.length()){
                n2 = Integer.parseInt(num2.charAt(num2.length()-i)+"");
            }else{
                n2 = 0;
            }
            n3 = n1+n2+jinWei;
            yuShu = n3%10;
            jinWei = n3/10;
            res.append(yuShu);
        }
        if(jinWei>0){
            res.append(jinWei);
        }
        String res2 = res.reverse().toString();
        StringBuilder res3 = new StringBuilder();
        // 去除多余的0
        int flag = 0;
        for(int i=0;i<res2.length();i++){
            if(res2.charAt(i)!='0' || flag==1){
                res3.append(res2.charAt(i));
                flag = 1;
            }
        }
        if(res3.length()==0){
            res3.append(0);
        }
//        System.out.println(num1+"+"+num2+"="+res2);
        return res3.toString();
    }

    public static void main(String[] args) {

        Test1214c t = new Test1214c();
        System.out.println(t.multiply("123", "0"));

    }
}
