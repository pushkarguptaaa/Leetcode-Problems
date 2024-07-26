package StacksandQueues;

import java.util.Stack;

public class ValidParenthesis {
    public static void main(String[] args) {
        
    }
}

class Solution {
    public boolean isValid(String s) {
        Stack<Character> st= new Stack<>();

        for(Character ch: s.toCharArray()){
            if(ch=='(' || ch=='{' || ch=='[') st.add(ch);
            else if(st.isEmpty()) return false;
            else if(ch==')' && st.pop()=='(' || ch=='}' && st.pop()=='{' || ch==']' && st.pop()=='[') continue;
            else return false;
        }
        return st.isEmpty();
    }
}
