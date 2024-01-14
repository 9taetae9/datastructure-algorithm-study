import java.util.Scanner;

//이것이 코딩테스트다 - 259p
public class FutureCity {
    public static int floydwarshall(int N, int M, int[][] v, int X, int K){
        int[][] dp = new int[N+1][N+1];
        final int INF = 1000000000;
        for(int i=1; i<N+1; i++){
            for(int j=1; j<N+1; j++){
                if(i!=j){
                    dp[i][j] = INF;
                }
            }
        }

        for(int i=1; i<N+1; i++){
            for(int j=1; j<N+1; j++){
                if(v[i][j] != 0){
                    dp[i][j] = 1;
                }
            }
        }

        for(int n=1; n<N+1; n++) {
            for (int i = 1; i < N + 1; i++) {
                if(i==n) continue;
                for (int j = 1; j < N + 1; j++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][n]+dp[n][j]);
                }
            }
        }

        if( dp[1][K] + dp[K][X] >= INF)
            return -1;

        return dp[1][K] + dp[K][X];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 회사 수
        int M = sc.nextInt(); // 경로 수

        int[][] v = new int[N+1][N+1];
        for(int i=0; i<M; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            v[a][b] = 1;
            v[b][a] = 1;
        }

        int X = sc.nextInt();
        int K = sc.nextInt();

        System.out.println(floydwarshall(N,M,v,X,K));
    }
}
