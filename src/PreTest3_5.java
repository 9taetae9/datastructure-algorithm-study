public class PreTest3_5 {
    public static void main(String[] args) {
        int[][] A = {{1}, {2, 5}, {7, 10, 1}, {9, 4, 4, 5}};
        System.out.println("최소 대기 시간: " + findMinimumWaitingTime(A));
    }

    private static int findMinimumWaitingTime(int[][] A) {
        if (A == null || A.length == 0)
            return 0;

        int[] dp = new int[A[A.length - 1].length]; // 마지막 단계 배열 크기

        //각 단계 순회
        dp[0] = A[0][0];
        for (int i = 1; i < A.length; i++) {
            int[] tempDp = new int[A[i].length];
            for (int j = 0; j < A[i].length; j++) {
                if (j == 0) {
                    tempDp[j] = dp[j] + A[i][j];
                } else if (j == A[i].length - 1) {
                    tempDp[j] = dp[j - 1] + A[i][j];
                } else {
                    tempDp[j] = Math.min(dp[j - 1], dp[j]) + A[i][j];
                }
            }
            dp = tempDp;
        }
        int min = dp[0];
        for (int e : dp) {
            min = Math.min(min, e);
        }

        return min;
    }
}

/*
        dp[0]=A[0][0]즉,dp[0]=1(시작점)
        A의 두 번째 줄부터 마지막 줄까지 순회.
        첫 번째 순회(i=1,즉 A[1]={2,5})
        tempDp는 A[1]의 길이,즉 2로 초기화(tempDp=new int[2]).
        내부 반복문을 돌면서 tempDp를 채우기
        j=0일 때,tempDp[0]=dp[0]+A[1][0]즉,tempDp[0]=1+2=3.
        j=1일 때,tempDp[1]=dp[0]+A[1][1]즉,tempDp[1]=1+5=6.
        dp를 tempDp로 업데이트(dp=tempDp),이제 dp={3,6}.
        두 번째 순회(i=2,즉 A[2]={7,10,1})
        tempDp는 A[2]의 길이,즉 3으로 초기화(tempDp=new int[3]).
        내부 반복문을 돌면서 tempDp를 채우기
        j=0일 때,tempDp[0]=dp[0]+A[2][0]즉,tempDp[0]=3+7=10.
        j=1일 때,tempDp[1]=min(dp[0],dp[1])+A[2][1]즉,tempDp[1]=min(3,6)+10=13.
        j=2일 때,tempDp[2]=dp[1]+A[2][2]즉,tempDp[2]=6+1=7.
        dp를 tempDp로 업데이트(dp=tempDp),이제 dp={10,13,7}.
        세 번째 순회(i=3,즉 A[3]={9,4,4,5})
        tempDp는 A[3]의 길이,즉 4로 초기화(tempDp=new int[4]).
        내부 반복문을 돌면서 tempDp를 채우기
        j=0일 때,tempDp[0]=dp[0]+A[3][0]즉,tempDp[0]=10+9=19.
        j=1일 때,tempDp[1]=min(dp[0],dp[1])+A[3][1]즉,tempDp[1]=min(10,13)+4=14.
        j=2일 때,tempDp[2]=min(dp[1],dp[2])+A[3][2]즉,tempDp[2]=min(13,7)+4=11.
        j=3일 때,tempDp[3]=dp[2]+A[3][3]즉,tempDp[3]=7+5=12.
        dp를 tempDp로 업데이트(dp=tempDp), dp={19,14,11,12}.
        최종 결과
        최소 대기 시간을 찾기.dp={19,14,11,12}중 최소값은 11.
*/




