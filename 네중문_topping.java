public class 네중문_topping {

    public static int solution(int n, int m, int[][] preferences) {
        int maxSatisfied = 0;

        // 2^m 가지의 토핑 조합을 표현하기 위해 사용
        // m이 4라면 2^4 = 16가지의 조합이 가능함
        int totalCombinations = 1 << m;

        // 피자 왼쪽의 모든 조합을 탐색
        for (int half1 = 0; half1 < totalCombinations; half1++) {
            // 피자 오른쪽의 모든 조합을 탐색
            for (int half2 = 0; half2 < totalCombinations; half2++) {
                // 이진수 형식으로 고정 길이(4자리)로 변환
                String half1Binary = String.format("%" + m + "s", Integer.toBinaryString(half1)).replace(' ', '0');
                String half2Binary = String.format("%" + m + "s", Integer.toBinaryString(half2)).replace(' ', '0');
                System.out.println("  다른 피자 반쪽의 조합 (half2): " + half1Binary + " || " + half2Binary);

                int satisfiedCount = 0;

                // 각 사람에 대해 만족도를 계산
                for (int i = 0; i < n; i++) {
                    boolean firstHalfSatisfies = true;
                    boolean secondHalfSatisfies = true;

                    // 피자 왼쪽이 현재 사람을 만족시키는지 확인
                    for (int j = 0; j < m; j++) {
                        // 선호하는 토핑이 포함되어 있지 않으면 불만족
                        if (preferences[i][j] == 1 && (half1 & (1 << j)) == 0) {
                            firstHalfSatisfies = false;
                        }
                        // 불호하는 토핑이 포함되어 있으면 불만족
                        if (preferences[i][j] == -1 && (half1 & (1 << j)) != 0) {
                            firstHalfSatisfies = false;
                        }
                    }

                    // 피자 오른쪽이 현재 사람을 만족시키는지 확인
                    for (int j = 0; j < m; j++) {
                        if (preferences[i][j] == 1 && (half2 & (1 << j)) == 0) {
                            secondHalfSatisfies = false;
                        }
                        if (preferences[i][j] == -1 && (half2 & (1 << j)) != 0) {
                            secondHalfSatisfies = false;
                        }
                    }

                    // 두 피자 반쪽 중 하나라도 만족하면 그 사람은 만족한 것으로 간주
                    if (firstHalfSatisfies || secondHalfSatisfies) {
                        satisfiedCount++;
                        System.out.println("    사람 " + i + "이 만족합니다.");
                    } else {
                        System.out.println("    사람 " + i + "이 불만족합니다.");
                    }
                }

                System.out.println("  현재 조합에서 만족한 사람 수: " + satisfiedCount);

                // 현재 조합에서 최대 만족한 사람 수를 업데이트
                if (satisfiedCount > maxSatisfied) {
                    System.out.println("  최대 만족한 사람 수가 업데이트되었습니다: " + satisfiedCount);
                }
                maxSatisfied = Math.max(maxSatisfied, satisfiedCount);
            }
            break;
        }

        return maxSatisfied;
    }

    public static void main(String[] args) {
        int n = 4;
        int m = 4;
        int[][] preferences = {
                { 1, 1, 0, -1 },
                { 0, 1, 1, -1 },
                { 1, 0, -1, -1 },
                { 1, 0, 0, 1 }
        };

        System.out.println("최대 만족할 수 있는 사람 수: " + solution(n, m, preferences)); // 최대 만족할 수 있는 사람 수 출력
    }
}
