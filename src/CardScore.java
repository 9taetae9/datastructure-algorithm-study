import java.util.Arrays;

public class CardScore {

    private int solution(int[] nums, int k) {
        //int t = Arrays.stream(nums).reduce(0, (a,b)->(a+b));
        int total = Arrays.stream(nums).reduce(0, Integer::sum);
        int m = nums.length - k;
        int window = 0;
        for (int i = 0; i < m; i++) window += nums[i];
        int mins = window;
        for (int i = m; i < nums.length; i++) {
            window += nums[i] - nums[i - m];
            mins = Math.min(mins, window);
        }

        return total - mins;
    }

    public static void main(String[] args) {
        CardScore T = new CardScore();
        int[] arr = new int[]{2, 3, 7, 1, 2, 1, 5};

        System.out.println(T.solution(arr, 4));
    }
}




//    static int[] nums = {1,30,3,5,6,7};
//    static int k = 3;
//    public static void main(String[] args) {
//       CardScore.cardscore(nums, k);
//    }
//
//    public static void cardscore(int[] nums, int k){
//        int total = 0;
//
//        for(int num : nums){
//            total += num;
//        }
//
//        int windowSum = 0;
//
//        for(int i=0; i< nums.length-k; i++){
//            windowSum+=nums[i];
//        }
//
//        int minSum = windowSum;
//        for(int i=nums.length-k; i<nums.length; i++){
//            windowSum += nums[i] - nums[i - (nums.length -k)];
//            minSum=Math.min(minSum, windowSum);
//        }
//
//        System.out.println(total-minSum);
//    }
//}



/* 카드 점수
N개의 카드가 일렬로 놓여져 있습니다. 각 카드에는 숫자가 적혀 있습니다.
현수는 카드가 일렬로 놓여진 줄의 양 끝 즉 왼쪽 맨 끝카드와 오른쪽 맨 끝 카드 둘 중 하나를 가져갈 수 있습니다.
현수는 양 끝에서 가져가는 방식으로 k개의 카드를 가져갈 수 있습니다. 그리고 가져간 카드에 적혀진 숫자의 총합이 현수가 얻는 점수입니다.
일려로 놓여진 각 카드의 숫자가 매개변수 nums에 주어지고, 현수가 가져갈 수 있는 카드의 개수 k가 주어지면 현수가 얻을 수 있는 최대점수를 반환하는 프로그램을 작성하시오.
*/