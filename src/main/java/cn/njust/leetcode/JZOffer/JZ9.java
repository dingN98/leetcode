package cn.njust.leetcode.JZOffer;

import java.util.Stack;

public class JZ9 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public static void main(String[] args) {
        JZ9 o =new JZ9();
        o.push(1);
        o.push(2);
        System.out.println(o.pop());
        System.out.println(o.pop());
    }
}
