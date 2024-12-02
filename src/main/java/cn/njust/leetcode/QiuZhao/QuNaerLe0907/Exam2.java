package cn.njust.leetcode.QiuZhao.QuNaerLe0907;

public class Exam2 {

    public int Decrypt (int encryptedNumber, int decryption, int number) {
        // write code here
        int tmp1 = qpow(encryptedNumber,decryption,number);
        int res = (int)tmp1%number;
        return res;
    }

    public int qpow(int a,int b,int n){
        int res = 1;
        while(b>0){
            if((b&1)==1){
                res = qmul(res,a,n);
            }
            a = qmul(a,a,n);
            b /= 2;
        }
        return res;
    }

    public int qmul(int a,int b,int n){
        int res = 0;
        while(b>0){
            if((b&1)==1){
                res += a;
                res %= n;
            }
            a *= 2;
            a %= n;
            b /= 2;
        }
        return res;
    }

}
