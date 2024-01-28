import java.util.LinkedList;

public class MoveElements {
    private LinkedList<Integer> solution(int[] nums, int k){
        LinkedList<Integer> answer = new LinkedList<>();
        for(int i=0; i<nums.length; i++) answer.add(nums[i]);
        for(int i=0; i<k; i++){
            answer.add(answer.pollFirst());
        }
        return answer;
    }
    public static void main(String[] args) {
        MoveElements T = new MoveElements();
        System.out.println(T.solution(new int[]{3, 7, 1, 5, 9, 2, 8}, 3));
    }
}
