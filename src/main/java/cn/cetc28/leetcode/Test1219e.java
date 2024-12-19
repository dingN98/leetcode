package cn.cetc28.leetcode;

/**
 * @author dingnan98
 * @project leetcode
 * @date 2024/12/19 21:15
 */
public class Test1219e {

    public String addBinary(String a, String b) {
        int jinWei = 0;
        int yuShu = 0;
        int m = a.length();
        int n = b.length();
        int len = Math.max(m,n);
        int j=0,k = 0;
        StringBuilder res = new StringBuilder();
        for(int i=0;i<len;i++){
            j=k=0;
            if(i<m){
                j = a.charAt(m-i-1)-'0';
            }
            if(i<n){
                k = b.charAt(n-i-1)-'0';
            }
            yuShu = j+k+jinWei;
            jinWei = yuShu/2;
            yuShu = yuShu%2;
            res.append(yuShu);
        }
        if(jinWei>0){
            res.append(jinWei);
        }
        return res.reverse().toString();

    }

    public static void main(String[] args) {

        Test1219e t = new Test1219e();
        System.out.println(t.addBinary("11", "1"));

    }
}
