class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c: s.toCharArray()){
            if(c == '(' || c == '[' || c == '{'){
                stack.push(c);
            }
            
            if( c == ')'){
                if (stack.isEmpty() || stack.pop() != '('){
                    return false;
                }
            }
            
            if( c == ']'){
                if (stack.isEmpty() || stack.pop() != '['){
                    return false;
                }
            }
            
            if( c == '}'){
                if(stack.isEmpty() || stack.pop() != '{'){
                    return false;
                }
            }
        }
        return stack.isEmpty();
        //如果只有左半边的时候，只有判断栈为空才可以
    }
}