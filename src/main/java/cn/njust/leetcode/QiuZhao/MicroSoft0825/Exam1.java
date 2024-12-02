package cn.njust.leetcode.QiuZhao.MicroSoft0825;

public class Exam1 {

    public int diGui(int N){
        String nStr = N+"";
        char[] nArr = nStr.toCharArray();
        int len = nArr.length;
        for(int i=0;i<nArr.length;i++){
            if(nArr[i]=='5'){
                if((i+1)<len){
                    char ch = nArr[i+1];
                    if(ch>='5'){
                        // 删除这个5
                        String  res = nStr.substring(0,i)+nStr.substring(i+1,len);
                        return Integer.parseInt(res);
                    }else{
                        int tmp = diGui(Integer.parseInt(nStr.substring(i+1,len)));
                        if(tmp==-1){
                            // 后面的不满足条件 还是只能删除这个5
                            String  res = nStr.substring(0,i)+nStr.substring(i+1,len);
                            return Integer.parseInt(res);
                        }else{
                            String  res = nStr.substring(0,i+1)+tmp;
                            return Integer.parseInt(res);
                        }
                    }
                }else{
                    String  res = nStr.substring(0,i);
                    return Integer.parseInt(res);
                }
            }
        }
        return -1;
    }

    public int diGui2(int N){
        String nStr = N+"";
        char[] nArr = nStr.toCharArray();
        int len = nArr.length;
        for(int i=0;i<nArr.length;i++){
            if(nArr[i]=='5'){
                if((i+1)<len){
                    char ch = nArr[i+1];
                    if(ch<='5'){
                        // 删除这个5
                        String  res = nStr.substring(0,i)+nStr.substring(i+1,len);
                        return Integer.parseInt(res);
                    }else{
                        int tmp = diGui2(Integer.parseInt(nStr.substring(i+1,len)));
                        if(tmp==-1){
                            // 后面的不满足条件 还是只能删除这个5
                            String  res = nStr.substring(0,i)+nStr.substring(i+1,len);
                            return Integer.parseInt(res);
                        }else{
                            String  res = nStr.substring(0,i+1)+tmp;
                            return Integer.parseInt(res);
                        }
                    }
                }else{
                    String  res = nStr.substring(0,i);
                    return Integer.parseInt(res);
                }
            }
        }
        return -1;
    }


    public int solution(int N) {
        // write your code in Java 8 (Java SE 8)
        if(N>0){
            return diGui(N);
        }else{
            return -diGui2(-N);
        }
    }

    public static void main(String[] args) {
        int N = -515;
        int res = new Exam1().solution(N);
        System.out.println(res);

    }
}
