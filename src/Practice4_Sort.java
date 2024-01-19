import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//기수 정렬
public class Practice4_Sort {
    public static void radixSort(int[] arr){
        ArrayList<Queue<Integer>> list = new ArrayList<>();
        for(int i=0; i<10; i++){
            list.add(new LinkedList<>());
        }

        int idx = 0;
        int div = 1;
        int maxLen = getMaxlen(arr);

        for(int i=0; i< maxLen; i++){
            for(int j=0; j<arr.length; j++){
                list.get((arr[j]/div)%10).offer(arr[j]);
            }

            for(int j=0; j<10; j++){
                Queue<Integer> queue = list.get(j);

                while(!queue.isEmpty()){
                    arr[idx++] = queue.poll();
                }
            }

            idx = 0;
            div *= 10;
        }

    }

    public static int getMaxlen(int[] arr){
        int maxLen = 0;
        for(int i = 0; i<arr.length; i++){
            int len = (int)Math.log10(arr[i])+1;
            if(maxLen < len){
                maxLen = len;
            }
        }

        return maxLen;
    }
    public static void main(String[] args) {
        //Test code
        int[] arr = {10, 32, 52, 27, 13, 44, 36, 98, 81};
        radixSort(arr);
        System.out.println("radix sort : " + Arrays.toString(arr));
    }
}
