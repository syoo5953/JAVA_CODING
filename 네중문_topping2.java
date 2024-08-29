import java.util.ArrayList;
import java.util.List;

public class 네중문_topping2 {

    public static int solution(int n, int m, int[][] preferences) {
        int maxSatisfied = 0;

        // 모든 가능한 조합을 저장할 리스트
        List<int[]> allCombinations = generateAllCombinations(m);

        // 첫 번째 피자 반쪽의 모든 조합을 탐색
        for (int[] half1 : allCombinations) {
            // 두 번째 피자 반쪽의 모든 조합을 탐색
            for (int[] half2 : allCombinations) {
                int satisfiedCount = 0;

                // 각 사람에 대해 만족도를 계산
                for (int i = 0; i < n; i++) {
                    boolean firstHalfSatisfies = true;
                    boolean secondHalfSatisfies = true;

                    // 첫 번째 피자 반쪽이 현재 사람을 만족시키는지 확인
                    for (int j = 0; j < m; j++) {
                        if (preferences[i][j] == 1 && half1[j] == 0) {
                            firstHalfSatisfies = false;
                        }
                        if (preferences[i][j] == -1 && half1[j] == 1) {
                            firstHalfSatisfies = false;
                        }
                    }

                    // 두 번째 피자 반쪽이 현재 사람을 만족시키는지 확인
                    for (int j = 0; j < m; j++) {
                        if (preferences[i][j] == 1 && half2[j] == 0) {
                            secondHalfSatisfies = false;
                        }
                        if (preferences[i][j] == -1 && half2[j] == 1) {
                            secondHalfSatisfies = false;
                        }
                    }

                    // 두 피자 반쪽 중 하나라도 만족하면 그 사람은 만족한 것으로 간주
                    if (firstHalfSatisfies || secondHalfSatisfies) {
                        satisfiedCount++;
                    }
                }

                // 현재 조합에서 최대 만족한 사람 수를 업데이트
                maxSatisfied = Math.max(maxSatisfied, satisfiedCount);
            }
            break;
        }

        return maxSatisfied;
    }

    // 모든 가능한 토핑 조합을 생성하는 메서드
    private static List<int[]> generateAllCombinations(int m) {
        int totalCombinations = (int) Math.pow(2, m); // 2^m 조합
        List<int[]> combinations = new ArrayList<>();

        // 가능한 모든 조합 생성
        for (int i = 0; i < totalCombinations; i++) {
            int[] combination = new int[m];
            for (int j = 0; j < m; j++) {
                // j번째 토핑이 포함된 조합 생성 (배열로 표현)
                combination[j] = (i / (int) Math.pow(2, j)) % 2;
            }
            combinations.add(combination);
        }

        return combinations;
    }

    public static void main(String[] args) {
        int n = 4;
        int m = 4;
        int[][] preferences = {
            {1, 1, 0, -1},
            {0, 1, 1, -1},
            {1, 0, -1, -1},
            {1, 0, 0, 1}
        };

        System.out.println("최대 만족할 수 있는 사람 수: " + solution(n, m, preferences));  // 최대 만족할 수 있는 사람 수 출력
    }
}
