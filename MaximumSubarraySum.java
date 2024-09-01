public class MaximumSubarraySum {

    public static int maxSubArray01(int[] nums) {
        // 여기에 로직을 구현하세요
        int sum = nums[0];
        int maxSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum = Math.max(nums[i], sum + nums[i]);
            maxSum = Math.max(maxSum, sum);
        }
        return sum; // 결과값 반환 (로직 구현 후 수정)
    }

    // 최대 연속 부분 배열의 합과 시작/끝 인덱스를 구하는 메소드
    public static int[] maxSubArray(int[] nums) {
        int maxSum = nums[0]; // 최대 합을 저장하는 변수
        int currentSum = nums[0]; // 현재 부분 배열의 합
        int fromIdx = 0; // 최대 합을 가지는 부분 배열의 시작 인덱스
        int toIdx = 0; // 최대 합을 가지는 부분 배열의 끝 인덱스
        int tempStart = 0; // 현재 부분 배열의 임시 시작 인덱스

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > currentSum + nums[i]) {
                currentSum = nums[i];
                tempStart = i; // 새로 시작하는 부분 배열의 시작점 설정
            } else {
                currentSum += nums[i];
            }

            if (currentSum > maxSum) {
                maxSum = currentSum;
                fromIdx = tempStart; // 실제 최대 부분 배열의 시작점 갱신
                toIdx = i; // 끝 인덱스 갱신
            }
        }

        return new int[] { maxSum, fromIdx, toIdx };
    }

    public static void main(String[] args) {
        // 입력 예시 배열
        int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };

        // 최대 연속 부분 배열의 합과 인덱스 계산
        int[] result = maxSubArray(nums);

        // 결과 출력
        System.out.println("Maximum Subarray Sum: " + result[0]);
        System.out.println("From Index: " + result[1]);
        System.out.println("To Index: " + result[2]);
    }
}
