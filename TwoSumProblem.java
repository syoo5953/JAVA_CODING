import java.util.HashMap;

public class TwoSumProblem {

    public int[] twoSum(int[] nums, int target) {
        // 숫자와 그 인덱스를 저장할 HashMap을 생성합니다.
        HashMap<Integer, Integer> map = new HashMap<>();
        
        // 배열을 순회하며 필요한 숫자를 찾습니다.
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            System.out.println(complement); 
            // 만약 목표값을 만들기 위한 수가 HashMap에 존재한다면
            if (map.containsKey(complement)) {
                // 해당 수의 인덱스와 현재 인덱스를 반환합니다.
                return new int[] { map.get(complement), i };
            }
            
            // 현재 숫자와 그 인덱스를 HashMap에 추가합니다.
            map.put(nums[i], i);
        }
        
        // 만약 답이 없다면 빈 배열을 반환합니다 (문제 조건에서는 답이 항상 존재합니다).
        return new int[0];
    }

    public static void main(String[] args) {
        TwoSumProblem solution = new TwoSumProblem();

        // 예제 1
        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;
        int[] result1 = solution.twoSum(nums1, target1);
        System.out.println("Output: [" + result1[0] + ", " + result1[1] + "]");

        // 예제 2
        int[] nums2 = {3, 2, 4};
        int target2 = 6;
        int[] result2 = solution.twoSum(nums2, target2);
        System.out.println("Output: [" + result2[0] + ", " + result2[1] + "]");

        // 예제 3
        int[] nums3 = {3, 3};
        int target3 = 6;
        int[] result3 = solution.twoSum(nums3, target3);
        System.out.println("Output: [" + result3[0] + ", " + result3[1] + "]");
    }
}
