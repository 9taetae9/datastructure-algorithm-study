import java.util.HashMap;

public class findSum {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6,7,8,9,10};

        for(int e : findSum(nums, 10)){
            System.out.print(e+" ");
        }
    }

    public static int[] findSum(int[] nums, int target){
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            int diff = target - nums[i];
            if(map.containsKey(diff)){
                int j = map.get(diff); //value of index
                if(j != i)
                    return new int[] {j,i};
            }
            map.put(nums[i],i);
        }
        return new int[]{-1};
    }
}
