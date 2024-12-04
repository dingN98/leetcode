package cn.cetc28.leetcode;

/**
 * @author dingnan98
 * @project leetcode
 * @date 2024/12/3 20:28
 * 008 字符串转换整数
 * 请你来实现一个 myAtoi(string s) 函数，使其能将字符串转换成一个 32 位有符号整数。
 */
public class Test1203 {

    public static void main(String[] args) {

        Test1203 t = new Test1203();
//        String s = "-123  456";
        String s = "-21474836482";
        int res = t.myAtoi(s);
        System.out.println(res);
        // 2147483647
        //-2147483648
//        System.out.println(Math.pow(2,31)-1);
//        System.out.println(-Math.pow(2,31));

    }

    // 这道题边界比较多，包括：（1）整数最大值边界（2）正负符号，空格边界
    // 时间复杂度 O(N) 空间复杂度O(1)
    public int myAtoi(String s) {
        char[] arr = s.toCharArray();
        int len = s.length();
        int fuHao = 1;
        boolean fuHaoFlag = false;
        int res = 0;
        for(int i=0;i<len;i++){
            char ch = s.charAt(i);
            if(ch==' '){
                if(!fuHaoFlag){
                    continue;
                }else{
                    return fuHao*res;
                }
            }
            if((ch=='-'|| ch=='+')&&!fuHaoFlag){
                if(ch=='-'){
                    fuHao = -1;
                }
                fuHaoFlag = true;
            }else if(ch>='0' && ch<='9'){
                // 0-1  结果应该是 0
                fuHaoFlag = true;
                int tmp = Integer.parseInt(ch+"");
                // 处理越界
                // 2147483647
                // -2147483648
                if(res>214748364){
                    if(fuHao>0){
                        return 2147483647;
                    }else{
                        return -2147483648;
                    }
                }else if(res==214748364){
                    if(fuHao>0){
                        if(tmp>=7){
                            return 2147483647;
                        }
                    }else{
                        if(tmp>=8){
                            return -2147483648;
                        }
                    }
                }
                res = res*10+tmp;

            }else{
                break;
            }

        }
        return fuHao*res;

    }
}
