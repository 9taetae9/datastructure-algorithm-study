import java.util.Arrays;

public class MinEnergyPathFinder {

    public int solution(int N, int[][] arr) {
        int[][] dp = new int[N][N];
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        dp[0][0] = 0; // 시작점의 에너지 소비량은 0
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < 4; k++) {
                    int nextX = i + dx[k];
                    int nextY = j + dy[k];

                    if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < N) {
                        int energy = Math.abs(arr[i][j] - arr[nextX][nextY]);
                        dp[nextX][nextY] = Math.min(dp[nextX][nextY], dp[i][j] + energy);
                    }
                }
            }
        }

        return dp[N - 1][N - 1];
    }

    public static void main(String[] args) {
        MinEnergyPathFinder finder = new MinEnergyPathFinder();
        int N = 3;
        int[][] arr = {
                {1, 2, 3},
                {4, 8, 2},
                {1, 5, 3}
        };
        System.out.println("Minimum energy path cost: " + finder.solution(N, arr));
    }
}