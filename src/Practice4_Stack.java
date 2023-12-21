import java.util.Stack;

public class Practice4_Stack {
    public static void checkParenthesis(String str){
        Stack stack = new Stack();
        Boolean checkFlag = true;
        for(String s : str.split("")){
            if(s.equals("(")) stack.push("(");
            else{
                if(!stack.isEmpty()) stack.pop();
                else {
                    checkFlag = false;
                    break;
                }
            }
        }

        if(checkFlag && stack.isEmpty()) System.out.println("PASS");
        else System.out.println("FAIL");
    }

    public static void main(String[] args) {
        checkParenthesis("(");
        checkParenthesis(")");
        checkParenthesis("()");
        checkParenthesis("()()()");
        checkParenthesis("(())()");
        checkParenthesis("(((()))");
    }
}
