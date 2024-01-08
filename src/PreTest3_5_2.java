import java.util.ArrayList;
import java.util.List;

public class PreTest3_5_2 {

    public static void main(String[] args) {
        int[] arr = {1000, 1000, 100};
        List<Integer> result = returnMoney(arr);
        System.out.println("반환 금액: " + result);
    }

    private static List<Integer> returnMoney(int[] arr) {
        int[] coin = {500,100,50,10};
        int[] money = {10000,5000,1000};

        int total = 0;
        boolean ismoney = false;

        List<Integer> list = new ArrayList<>();
        for(int m : arr){
            total += m;
            if(!ismoney && (m == money[0] || m == money[1] || m == money[2])){
                list.add(m);
                ismoney = true;
                total -= m;
            }
        }

        for(int i=0; i<coin.length; i++){
            if(total>=coin[i]){
                int cnt = total/coin[i];
                total%=coin[i];
                for(int j=0; j<cnt; j++){
                    list.add(coin[i]);
                }
            }
        }

        return list;
    }
}
