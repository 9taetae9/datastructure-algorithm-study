import java.util.Arrays;

public class Practice3_Sort {

    public static void quickSort(int[] arr, int left, int right){
        if(left >= right){
            return;
        }

        int pivot = partition(arr,left,right);

        quickSort(arr,left, pivot-1);
        quickSort(arr,pivot+1, right);
    }

    public static int partition(int[] arr, int left, int right){
        //pivot 설정
        int pivot = arr[left];
        int i = left+1;
        int j = right;

        while(i<=j){
            while(i <= j && arr[i] <= pivot){ //pivot 보다 큰 값이 나올 때까지 진행
                i++;
            }

            while(i <= j && arr[j] > pivot){ //pivot 보다 작은 값이 나올 때까지 진행
                j--;
            }

            if(i<j)
                swap(arr,i,j); //작은 값과 큰 값 교환

        }

        swap(arr, left, j); //pivot 값과 j교환
        return j;
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void main(String[] args) {
        //test case
        int[] arr = {100,3,5,2,7,1,4,6,5,5};
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
