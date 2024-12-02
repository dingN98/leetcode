package cn.njust.leetcode.NiuKe.栈和队列;

import java.util.Stack;

public class BM43 {

    // BM43 包含min函数的栈
    // 看题解  使用两个栈 另一个用来存储较小值

    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    public void push(int node) {
        s1.push(node);
        if(s2.isEmpty()){
            s2.push(node);
        }else{
            if(node<=s2.peek()){
                s2.push(node);
            }
        }

    }

    public void pop() {
        if(s1.pop().equals(s2.peek())){
            s2.pop();
        }

    }

    public int top() {
        return s1.peek();

    }

    public int min() {
        return s2.peek();

    }

    public static void main(String[] args) {

    }
}
