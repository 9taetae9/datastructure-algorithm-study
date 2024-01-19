//nums 배열에 3가지 색으로 구분된느 데이터들이 들어 있다.
//0은 흰색, 1은 파랑, 2는 빨강이라고 할때,
//주어진 nums 배열에서 흰색부터 빨강 순으로 인접하게 정렬시킨 후 출력하는 코드를 작성하시오.

import java.util.Arrays;

//예시)
//입력: [0,1,2,0,1,2]
//출력: [0,0,1,1,2,2]
public class Practice7_Sort {
    //계수 정렬 <= 색의 종류 제한적, stability와 무관
    public static void solution(int[] arr){
        if(arr == null || arr.length == 0){
            return;
        }

        int[] cntArr = new int[3];
        for(int i=0; i<arr.length; i++){
            cntArr[arr[i]]++;
        }

        int idx = 0;
        for(int i=0; i<cntArr.length; i++){
            while(cntArr[i]>0){
                arr[idx++] = i;
                cntArr[i]--;
            }
        }
    }
    public static void main(String[] args) {
        //test case
        int[] arr = {0,1,2,0,1,2};
        solution(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println();

        arr = new int[]{2,0,1};
        solution(arr);
        System.out.println(Arrays.toString(arr));
    }
}
