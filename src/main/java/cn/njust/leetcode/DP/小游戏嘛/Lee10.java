package cn.njust.leetcode.DP.小游戏嘛;

public class Lee10 {

    public boolean isMatch(String s, String p) {

        System.out.println("匹配 "+s+"  "+p);

        if(s.equals(p) || p.equals(".*") || s.length()==1 && p.equals(".")){
            return true;
        }
        int len1 = s.length();
        int len2 = p.length();

        char[] sL = s.toCharArray();
        char[] pL = p.toCharArray();

        int i=0;
        int j=0;

        while(i<len1 && j<len2){

            if(sL[i]==pL[j] || pL[j]=='.'){
                if((j+1)<len2 && pL[j+1]=='*'){
                    // 匹配0个或多个  最大值用变量K表示
                    // 情况 1
                    // aab
                    // a*aab    a*ab     a*b
                    // 情况 2
                    // aaabbbb
                    // aa.*bb

                    int K = 0;
                    if(pL[j]=='.'){
                        K = len1-i;
                    }else{
                        for(int k=i;k<len1;k++){
                            if(sL[k]==sL[i]){
                                K++;
                            }
                        }
                    }

                    boolean res = false;
                    for(int k=0;k<=K;k++){
                        res = res || isMatch(s.substring(i+k),p.substring(j+2));
                    }
                    return res;
                }else{
                    i++;
                    j++;
                }
            }else{
                if((j+1)<len2 && pL[j+1]=='*'){
                    // 匹配0个
                    // aab
                    // b*aab
                    j+=2;
                }else{
                    return false;
                }
            }
//            i++;
//            j++;
        }
        return i == len1 && j == len2;

    }


    public static void main(String[] args) {
//        String s = "aaabbbb";
//        String p = "a*abb*";
//        String s = "aaabbbb";
//        String p = "aa.*bb";
//        String s = "mississippi";
//        String p = "mis*is*ip*.";
        String s = "aaba";
        String p = "ab*a*c*a*";
        // "mississippi"
        //"mis*is*ip*."
        boolean res = new Lee10().isMatch(s,p);
        System.out.println(res);
    }


}
