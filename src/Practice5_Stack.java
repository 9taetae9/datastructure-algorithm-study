import java.util.Stack;

public class Practice5_Stack {
    public static double calculate(String string){
        Stack<Double> stack = new Stack();

        for(String str : string.split(" ")){ //공백기준으로 스플릿
            if(str.equals("+")){
                stack.push(stack.pop() + stack.pop());
            }else if(str.equals("-")){
                stack.push(-stack.pop()+stack.pop());
            }else if(str.equals("*")){
                stack.push(stack.pop() * stack.pop());
            }else if(str.equals("/")){
                stack.push(1/stack.pop() * stack.pop());
            }else {//일반 숫자인 경우
                stack.push(Double.parseDouble(str));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        System.out.println(calculate("2 2 +")); // 2+2
        System.out.println(calculate("2 2 -")); // 2-2
        System.out.println(calculate("2 2 *")); // 2*2
        System.out.println(calculate("2 2 /")); // 2/2

        System.out.println(calculate("1 1 + 2 * 3 * 2 / 5 -")); // (1+1)*2*3/2-5=  6-5=1
        System.out.println(calculate("5 2 * 3 - 8 * 4 /"));  // (5 * 2 - 3) * 8 / 4 = 14
    }
}
