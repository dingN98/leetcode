package cn.njust.leetcode.NiuKe.栈和队列;

import java.util.Stack;

public class BM42 {

    // 用两个栈实现队列 简单题

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);

    }

    public int pop() {
        // 只有在stack2为空的时候  pop的时间复杂度大一点  其余都是O(1)
        if(!stack2.isEmpty()){
            return stack2.pop();
        }
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        return stack2.pop();
    }
}
