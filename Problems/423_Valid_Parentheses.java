public class Solution {

    public boolean isValidParentheses(String s) {
        
        Stack<Character> stack = new Stack<Character>();
        for(Character c: s.toCharArray()) {
            // String.valueOf => convert other types tp String
            // Judge whether the character is a kind of left parentheses
            if("({[".contains(String.valueOf(c))) {
                stack.push(c);
            } else {
                if(!stack.isEmpty() && isPaired(stack.peek(), c)) {
                    stack.pop();
                } else {
                    // return false if the incoming character does not match the character at the top of the stack
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    private boolean isPaired(char a, char b) {
        if( (a == '{' && b == '}') || (a == '[' && b == ']') || (a == '(' && b == ')')) {
            return true;
        } else {
            return false;
        }
    }
}
