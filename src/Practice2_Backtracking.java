import java.util.ArrayList;

public class Practice2_Backtracking {
    public static ArrayList<Integer> result;

    public static ArrayList<Integer> solution(int n){
        result = new ArrayList<>();

        int[] primeNum = {2,3,5,7};
        for(int i=0; i<primeNum.length; i++){
            backTracking(primeNum[i],1,n);
        }

        return result;
    }

    public static void backTracking(int prime, int len, int n){
        if(len>=n){
            result.add(prime);
            return;
        }

        for(int i=0; i<10; i++){
            if(i%2 != 0 || i!=5){
                int primeCandidate = prime * 10 +i;
                if(isPrime(primeCandidate)){
                    backTracking(primeCandidate,len+1,n);
                }
            }
        }
;    }

    public static boolean isPrime(int primeCandidate){
        for(int i=2; i<=Math.sqrt(primeCandidate); i++){
            if(primeCandidate%i==0) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(solution(3));
        System.out.println();
        System.out.println(solution(4));
    }
}
