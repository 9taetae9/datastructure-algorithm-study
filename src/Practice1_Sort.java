import java.util.Arrays;

//합병정렬
public class Practice1_Sort {

    public static void mergeSort(int[] arr, int[] tmp, int left, int right){
        if(left<right){
            int mid = (left + right)/2;
            mergeSort(arr, tmp, left, mid);
            mergeSort(arr, tmp, mid+1, right);
            merge(arr, tmp, left, right, mid);
        }
    }

    public static void merge(int[] arr, int[] tmp, int left, int right, int mid){
        int p = left;
        int q = mid + 1;
        int idx = p;

        while(p <= mid || q<=right){
            if(p<=mid && q <=right){
                if(arr[p] <= arr[q]){
                    tmp[idx++] = arr[p++];
                }else{
                    tmp[idx++] = arr[q++];
                }
            }else if (p<=mid){ //오른쪽 그룸 이미 다 넣은 상황
                tmp[idx++] = arr[p++];
            }else {
                tmp[idx++] = arr[q++];
            }
        }

        for(int i=left; i<=right; i++){
            arr[i] = tmp[i];
        }
    }
    public static void main(String[] args) {
        //Test code
        int[] arr = {3,5,2,7,1,4,6};
        int[] tmp = new int[arr.length];
        mergeSort(arr, tmp, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
