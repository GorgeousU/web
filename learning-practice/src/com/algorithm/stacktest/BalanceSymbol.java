package com.algorithm.stacktest;

import java.util.Stack;

/**
给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
有效字符串需满足：
左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
每个右括号都有一个对应的相同类型的左括号。
 */
public class BalanceSymbol {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for ( char c : s.toCharArray() ) {
            if ( c == '(' || c == '{' || c == '[' ) {
                stack.push(c);
            } else {
                if ( !stack.isEmpty() ) {
                    if ( c == ')' ) {
                        if ( stack.pop() != '(' ) return false;
                    }
                    if ( c == '}' ) {
                        if ( stack.pop() != '{' ) return false;
                    }
                    if ( c == ']' ) {
                        if ( stack.pop() != '[' ) return false;
                    }
                } else return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "]";
        boolean b = isValid(s);
        System.out.println(b);
    }
}
