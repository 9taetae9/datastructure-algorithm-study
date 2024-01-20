import java.math.BigInteger;
import java.util.Arrays;

public class DP_CountWays {
    BigInteger countWays(int n){
        BigInteger[] memo = new BigInteger[n+1];
        Arrays.fill(memo, BigInteger.valueOf(-1));
        return countWays(n, memo);
    }

    BigInteger countWays(int n, BigInteger[] memo){
        if(n<0){
            return BigInteger.ZERO;
        }else if(n==0){
            return BigInteger.ONE;
        }else if(!memo[n].equals(BigInteger.valueOf(-1))){
            return memo[n];
        }else{
            memo[n] = countWays(n-1, memo).add(countWays(n-2,memo)).add(countWays(n-3,memo));

            return memo[n];
        }
    }
    public static void main(String[] args) {
        //test case
        DP_CountWays obj = new DP_CountWays();
        System.out.println(obj.countWays(3));
        System.out.println(obj.countWays(1000));
    }
}