import java.util.Arrays;

//쉘 정렬
public class Practice6_Sort {
    public static void shellSort(int[] arr){
        int gap = arr.length/2;

        for(int g = gap; g>0; g/=2){
            for(int i=g; i<arr.length; i++){
                int tmp = arr[i];

                int j=0;
                for(j=i-g; j>=0; j-=g){
                    if(arr[j]>tmp){
                        arr[j+g] = arr[j];
                    }else {
                        break;
                    }
                }
                arr[j+g] = tmp;
            }
        }
    }
    public static void main(String[] args) {
        //test case
        int[] arr = {10, 32, 52, 27, 13, 44, 36, 98, 81};
        shellSort(arr);
        System.out.println("shell sort : " + Arrays.toString(arr));
    }
}
