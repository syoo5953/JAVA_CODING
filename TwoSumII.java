import java.util.HashMap;
import java.util.Map;

public class TwoSumII {

    // 두 수의 합을 찾아 인덱스를 반환하는 메소드
    public static int[] twoSum(int[] nums, int target) {
        // 숫자를 기억하기 위한 해시맵
        Map<Integer, Integer> map = new HashMap<>();
        
        // 배열을 순회하면서 필요한 숫자를 찾기
        for (int i = 0; i < nums.length; i++) {
            // 필요한 숫자 계산
            int complement = target - nums[i];
            
            // 해시맵에 이미 있는지 확인
            if (map.containsKey(complement)) {
                // 이미 있다면, 현재 인덱스와 찾은 인덱스를 반환
                return new int[]{map.get(complement) + 1, i + 1}; // 1-based index
            }
            
            // 현재 숫자와 인덱스를 해시맵에 추가
            map.put(nums[i], i);
        }
        
        // 이 코드가 실행될 일은 없지만, 리턴이 필요함
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        // 입력 예시 배열
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        
        // 두 수의 합 인덱스 계산
        int[] result = twoSum(nums, target);
        
        // 결과 출력
        System.out.println("Indices: [" + result[0] + ", " + result[1] + "]");
    }
}
