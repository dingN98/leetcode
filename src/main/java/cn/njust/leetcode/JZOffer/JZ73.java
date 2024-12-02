package cn.njust.leetcode.JZOffer;

public class JZ73 {

    // 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。
    // 同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。例如，“nowcoder. a am I”。
    // 后来才意识到，这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a nowcoder.”。Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
    public String ReverseSentence(String str) {

        String[] list = str.split(" ");
        StringBuilder res = new StringBuilder();
        int len = list.length;
        for(int i=len-1;i>0;i--){
            res.append(list[i]+" ");
        }
        res.append(list[0]);
        return res.toString();
    }


    public static void main(String[] args) {

    }
}
