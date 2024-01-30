import java.util.Arrays;

class Solution{

    public int solution(int N, int[][] trust){
        boolean[] give = new boolean[N+1];
        int[] trusted = new int[N+1];

        for(int[] pair : trust){
            give[pair[0]]= true;
            trusted[pair[1]]++;
        }


        for(int i=1; i<=N; i++){
            if(!give[i] && trusted[i]==N-1){
                return i;
            }
        }

        return -1;
    }
//    public int solution(int N, int[][] trust){
//        if(trust.length == 0){
//            return -1;
//        }
//
//        for(int i=1; i<=N; i++){
//            int finalI = i;
//            if(Arrays.stream(trust) //finalI는 첫 원소로 등장하면 안됨
//                    .noneMatch(x->x[0]==finalI) &&
//            Arrays.stream(trust)
//                    .filter(x->x[1] == finalI)
//                    .count() == N-1){
//                return finalI;
//            }
//        }
//
//        return -1;
//    }
}
public class JudgeNumber {
    public static void main(String[] args) {
        int N=3;
        int[][] trust = {{1,3},{2,3}};
        System.out.println(new Solution().solution(N,trust));
    }
}
