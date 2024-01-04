//정수형 n과 m이 주어졌을 때,
//1부터 n까지의 정수 중에서 중복 없이 m개를 고른 수열을 출력하시오
//

import java.util.Arrays;

public class Practice1_Backtracking {
    public static boolean[] visited;
    public static int[] out;
    public static void solution(int n, int m){
        visited = new boolean[n];
        out = new int[m];
        permutation(n,m,0);
    }

    public static void permutation(int n, int m, int depth){
        if(depth==m){
            System.out.println(Arrays.toString(out));
            return;
        }

        for(int i=0; i<n; i++){
            if(!visited[i]){
                visited[i]=true; //방문 체크
                out[depth]=i+1; //숫자 대입
                permutation(n,m,depth+1); //depth+1로 하나 더 뽑은 상황으로 업데이트
                visited[i]=false; //방문 해제
            }
        }
    }

    public static void main(String[] args) {
        solution(3,2);
        System.out.println();
        solution(4,3);

    }
}
