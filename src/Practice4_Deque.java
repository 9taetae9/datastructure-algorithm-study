//데이터 재정렬
//D_0->1->...->n 순의 데이터를
//D_0->n->1->n-1->...순으로 재정렬하시오.

//ex) 1 2 3 4 5
//output 1 5 2 4 3

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.stream.IntStream;

public class Practice4_Deque {
    public static void reorderData(int[] arr){
        Deque deque = new ArrayDeque();
        ArrayList result = new ArrayList();

        IntStream.of(arr).forEach(x->deque.add(x));
        System.out.println(deque);

        while(!deque.isEmpty()){
            result.add(deque.removeFirst());
            if(!deque.isEmpty())
                result.add(deque.removeLast());
        }

        System.out.println("== 정렬 전 ==");
        printData(arr);

        System.out.println("== 정렬 후 ==");
        printData(result.stream().mapToInt(x->(int)x).toArray()); //stream을 변환후 int로 변환해서 배열로 바꾸기

    }

    public static void printData(int[] arr){
        for(int i=0; i<arr.length-1; i++){
            System.out.print(arr[i]+" -> ");
        }
        System.out.println(arr[arr.length-1]);
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        reorderData(arr);

        int[] arr2 ={1,2,3,4,5,6,7};
        reorderData(arr2);
    }
}
