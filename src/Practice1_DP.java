//나누기2, 나누기3, 빼기 1    *나누기는 나누어 떨어질때만 사용 가능
//최소 연산 횟수?


public class Practice1_DP {

    public static int solution(int n){
        int[] dp = new int[n+1];

        for(int i=2; i<=n; i++){
            dp[i] = dp[i-1] + 1;

            if(i%2==0){
                dp[i] = Math.min(dp[i], dp[i/2] + 1);
            }

            if(i%3==0){
                dp[i] = Math.min(dp[i],dp[i/3]+1);
            }

        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(solution(2));   //1
        System.out.println(solution(4));   //2
        System.out.println(solution(9));   //2
        System.out.println(solution(10));  //3
    }
}
