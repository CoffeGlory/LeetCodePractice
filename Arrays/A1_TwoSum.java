import java.util.*;

public class A1_TwoSum {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        A1_TwoSum solution = new A1_TwoSum();
        // int[] result = solution.twoSum(nums, target);
        int[] result = solution.twoSumHashMap(nums, target);
        System.out.println("Indices: " + result[0] + ", " + result[1]);
    }
    
    //brutal force solution
    // Time complexity: O(n^2)
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for(int i = 0; i < nums.length; i++){
            for(int j = nums.length - 1; j > i; j--){
                if(nums[i] + nums[j] == target){
                    System.out.println("i: " + i + ", j: " + j);
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return result;
    }

    // HashMap solution, solution provided by vs code auto-complete
    // Time complexity: O(n)       
    // Space complexity: O(n)
    public int[] twoSumHashMap(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        //after all the possible pairs are checked in the for loop above, throw an not found exception
        throw new IllegalArgumentException("No two sum solution");
    }
}
