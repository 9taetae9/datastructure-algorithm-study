import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

//계수 정렬
public class Practice5_Sort {
    public static void countingSort(int[] arr){
        int max = Arrays.stream(arr).max().getAsInt();
        int[] cntArr = new int[max+1];

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

        HashMap<Integer, Integer> map = new HashMap<>(); //이상치 값에 의한 공간 낭비 최소화
        for(int item : arr){
            map.put(item, map.getOrDefault(item, 0) +1);
        }

        int idx2 = 0;
        ArrayList<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list);

        for(int i=0; i<list.size(); i++){
            int cnt = map.get(list.get(i));
            while(cnt>0){
                arr[idx2++] = list.get(i);
                cnt--;
            }
        }

    }
    public static void main(String[] args) {
        //Test code
        int[] arr = {10, 32, 52, 27, 13, 44, 36, 98, 81};
        countingSort(arr);
        System.out.println("counting sort : " + Arrays.toString(arr));


    }
}
