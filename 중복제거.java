import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class 중복제거 {

    public static void main(String[] args) {
        int[][] intervals = { {1, 3}, {5, 8}, {4, 10}, {20, 25} };
        int[][] mergedIntervals = merge(intervals);
        
        // 결과 출력
        for (int[] interval : mergedIntervals) {
            System.out.println(Arrays.toString(interval));
        }
    }

    public static int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return new int[0][];
        }

        // 인터벌들을 시작 시간을 기준으로 정렬
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0])); // O n log n

        List<int[]> merged = new ArrayList<>();

        // 첫 번째 인터벌을 시작으로 병합 시작
        int[] currentInterval = intervals[0];
        merged.add(currentInterval);

        for (int[] interval : intervals) {      // O n
            int currentEnd = currentInterval[1];
            int nextStart = interval[0];
            int nextEnd = interval[1];

            System.out.println(currentEnd + " / " + nextStart + " / " + nextEnd);
            System.out.println("currentEnd >= nextStart = " + currentEnd + " >= " + nextStart);
            if (currentEnd >= nextStart) { // 중첩되는 경우             // O(1)
                currentInterval[1] = Math.max(currentEnd, nextEnd); // 병합
                System.out.println("병합 = " + currentInterval[0] + ", " + currentInterval[1]);
            } else { // 중첩되지 않는 경우
                currentInterval = interval;
                merged.add(currentInterval);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }
}

// O n log n + O n + O(1) = O n log n
