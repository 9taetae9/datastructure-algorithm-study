//수열 arr이 주어졌을 때,
//부분 수열 중 증가하는 부분이 가장 긴 길이를 출력하는 프로그램을 작성하시오.
//
public class Practice2_DP {
    public static int solution(int[] arr){
        int n = arr.length;
        int[]dp = new int[n+1];

        int result = 0;
        for(int i=1; i<=n; i++){
            dp[i]=1;
            for(int j=1; j<i; j++){
                if(arr[j-1]<arr[i-1]){ //위의 반복문 시작을 1로 했기 때문에 실제 인덱스로는 -1 해야됨
                    dp[i]=Math.max(dp[i],dp[j]+1); //이전 dp원소 돌면서 max+1 로 업데이트
                }
            }
            result = Math.max(result, dp[i]);
        }

        return result;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{10,20,30,10,50,10};
        System.out.println(solution(arr));
    }
}
