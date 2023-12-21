//Palindrome 찾기
//Palindrome 이면 true, 아니면 false 반환

import java.util.ArrayDeque;
import java.util.Deque;

public class Practice5_Deque {
    public static boolean checkPalindrome(String str){
        Deque deque = new ArrayDeque();
        boolean isFront = true;
        boolean isPalindrome = true;

        for(String s : str.split("")){
            deque.add(s);
        }

        while(!deque.isEmpty()){
            String s1=(String) deque.poll();
            String s2=(String) deque.pollLast();

            if(s1 != null && s2 != null && !s1.equals(s2)){
                isPalindrome = false;
                break;
            }
        }

        return isPalindrome;
    }
//    public static boolean checkPalindrome(String str){
//        Deque deque = new ArrayDeque();
//
//        for(char c : str.toCharArray()){
//            deque.add(c);
//        }
//
//        while(!deque.isEmpty()){
//            char front;
//            char rear;
//            front = (char) deque.remove();
//            if(!deque.isEmpty()) {
//                rear = (char) deque.removeLast();
//                if(front!=rear) return false;
//            }
//        }
//        return true;
//    }

    public static void main(String[] args) {
        System.out.println(checkPalindrome("a"));
        System.out.println(checkPalindrome("aba"));
        System.out.println(checkPalindrome("abba"));
        System.out.println(checkPalindrome("abab"));
        System.out.println(checkPalindrome("abcba"));
        System.out.println(checkPalindrome("abccba"));
        System.out.println(checkPalindrome("madam"));
    }
}
