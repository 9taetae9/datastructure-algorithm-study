//요세푸스 문제
//N과 K가 주어졌을 때 (N,K) 요세푸스 순열을 구하시오.
//N과 K는 N>=K를 만족하는 양의 정수이다.
//1부터 N번까지 N명이 순서대로 원을 이루어 모여 있다.
//이 모임에서 원을 따라 순서대로 K번째 사람을 제외한다.
//모든 사람이 제외될 때까지 반복하며 이때, 제외되는 순서가 요세푸스 순열이다.


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.IntStream;

public class Practice4_Queue {
    public static ArrayList getJosephusPermutation(int N, int K){
        Queue queue = new LinkedList();
        IntStream.range(1,N+1).forEach(x->queue.add(x));

        ArrayList result = new ArrayList();

        int cnt=0;

        while(!queue.isEmpty()){
            int data = (int)queue.remove();
            cnt += 1;

            if(cnt % K == 0){
                result.add(data);
            }else{
                queue.add(data);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(getJosephusPermutation(5,2));
    }
}
