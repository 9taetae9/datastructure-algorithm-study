public class Practice3_Backtracking {
    final static int numOfProblems = 10;
    static int cnt;

    public static void solution(int[] sols){
        if(sols==null || sols.length != numOfProblems){
            return;
        }

        cnt = 0;
        int[] submit = new int[numOfProblems];
        backTracking(sols, submit, 0,0);
        System.out.println(cnt);
    }

    public static void backTracking(int[] sols, int[] submit, int correctCnt, int idx){
        if(numOfProblems - idx + correctCnt < 5){
            return;
        }

        if(idx == numOfProblems){
            if(correctCnt >= 5){
                cnt+=1;
            }
        }else{
            int twoInRow=0;
            if(idx >= 2){
                if(submit[idx-1] == submit[idx-2]){
                    twoInRow = submit[idx - 1];
                }
            }


            for(int i=1; i<=5; i++){
                if(i==twoInRow){
                    continue;
                }

                submit[idx] = i;
                if(sols[idx] == i){
                    backTracking(sols, submit,correctCnt+1, idx+1);
                }else{
                    backTracking(sols,submit,correctCnt,idx+1);
                }
                submit[idx]=0;
            }
        }
    }
    public static void main(String[] args) {
        int[] sols ={1,2,3,4,5,1,2,3,4,5};
        solution(sols);
    }
}
