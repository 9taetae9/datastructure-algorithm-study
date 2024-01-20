//문자열 배열 strs가 주어졌을 때, anagram인 문자열끼리 묶어서 출력하라.
//anagram은 철자 순서를 바꾸면 같아지는 문자를 의미한다.
//예를 들어, strs = ["eat", "tea", "tan", "ate", "nat", "bat"] 일 때,
//출력은 ["ate", "eat", "tea"], ["nat", "tan"], ["bat"] 이다.

import java.util.ArrayList;
import java.util.HashMap;

public class Practice8_Sort {

    public static ArrayList<ArrayList<String>> solution(String[] strs){
        if(strs == null || strs.length == 0){
            return new ArrayList<>();
        }

        HashMap<String, ArrayList<String>> map = new HashMap<>();
        for(String s : strs){
            char[] cArr = s.toCharArray();
            sort(cArr);
            String key = String.valueOf(cArr);

            if(!map.containsKey(key)){
                map.put(key, new ArrayList<>());
            }

            map.get(key).add(s);
        }

        return new ArrayList<>(map.values());
    }

    public static void sort(char[] arr){
        for(int i=1; i<arr.length; i++){
            for(int j=i; j>0; j--){
                if(arr[j] < arr[j-1]){
                    char tmp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = tmp;
                }
            }
        }
    }



    public static void main(String[] args) {
        //test case
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(solution(strs));

    }
}
