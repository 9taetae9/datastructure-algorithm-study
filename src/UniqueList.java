import java.util.*;

public class UniqueList {

    public LinkedList<Integer> solution(int[] nums){
        Arrays.sort(nums);
        Set<Integer> set = new HashSet<>();

        for(int num : nums){
            set.add(num);
        }

        return new LinkedList<>(set);
    }

    public static void main(String[] args) {
        UniqueList uniqueList = new UniqueList();
        System.out.println(uniqueList.solution(new int[]{3, 1, 2, 3, 4, 2, 1, 5}));
    }
}