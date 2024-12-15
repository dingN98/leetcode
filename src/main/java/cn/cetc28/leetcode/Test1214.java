package cn.cetc28.leetcode;

/**
 * @author dingnan98
 * @project leetcode
 * @date 2024/12/14 15:26
 * 038 外观数列
 * 外观数列」是一个数位字符串序列，由递归公式定义：
 *
 * countAndSay(1) = "1"
 * countAndSay(n) 是 countAndSay(n-1) 的行程长度编码。
 *
行程长度编码（RLE）是一种字符串压缩方法，其工作原理是通过将连续相同字符（重复两次或更多次）替换为字符重复次数（运行长度）和字符的串联。
例如，要压缩字符串 "3322251" ，我们将 "33" 用 "23" 替换，将 "222" 用 "32" 替换，将 "5" 用 "15" 替换并将 "1" 用 "11" 替换。
因此压缩后字符串变为 "23321511"。

给定一个整数 n ，返回 外观数列 的第 n 个元素。
 */
public class Test1214 {

    public String countAndSay(int n) {
        String[] arr = new String[n+1];
        arr[1] = "1";
        for(int i=2;i<=n;i++){
            String str = arr[i-1];
            StringBuilder builder = new StringBuilder();
            Character ch = str.charAt(0);
            int len = 1;
            for (int j=1;j<str.length();j++){
                if(str.charAt(j)==ch){
                    len++;
                }else{
                    builder.append(len).append(ch);
                    ch = str.charAt(j);
                    len = 1;
                }
            }
            builder.append(len).append(ch);
            arr[i] = builder.toString();
        }
        return arr[n];
    }

    public static void main(String[] args) {
        Test1214 t = new Test1214();
        System.out.println(t.countAndSay(4));

    }
}
