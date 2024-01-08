public class PreTest3_5_1 {
    public static void main(String[] args) {
        int N = 278;
        int K = 3;
        System.out.println("가장 큰 숫자: " + insertAndGetMax(N, K));
    }

    private static int insertAndGetMax(int n, int k) {
        String number = Integer.toString(n);
        int max = n;
        boolean isNegative = n < 0;

        if(isNegative){
            number = number.substring(1);
        }

        for(int i=0; i<number.length(); i++){
            StringBuilder sb = new StringBuilder(number);
            sb.insert(i,k);

            int new_num = Integer.parseInt(sb.toString());
            if(isNegative){
                new_num = -new_num;
            }

            if(new_num > max){
                max = new_num;
            }
        }

        return max;
    }
}
