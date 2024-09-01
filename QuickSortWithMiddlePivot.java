public class QuickSortWithMiddlePivot {
    // Quick Sort 알고리즘을 구현하는 메서드
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) { // 배열의 크기가 1보다 큰 경우에만 정렬을 수행
            int pi = partition(arr, low, high); // 배열을 분할하고 피벗의 최종 위치를 반환
            System.out.println("Pivot index: " + pi + ", Pivot value: " + arr[pi]); // 피벗의 위치와 값을 출력
            printArray(arr, low, high); // 현재 배열 상태를 출력
            quickSort(arr, low, pi - 1); // 피벗 왼쪽 부분 배열을 정렬
            quickSort(arr, pi + 1, high); // 피벗 오른쪽 부분 배열을 정렬
        }
    }

    // 배열을 피벗을 기준으로 두 부분으로 나누는 메서드
    private static int partition(int[] arr, int low, int high) {
        int mid = low + (high - low) / 2; // 배열의 중앙 인덱스를 계산
        System.out.println("mid = " + mid);
        int pivot = arr[mid]; // 중앙 요소를 피벗으로 선택
        System.out.println("pivot = " + pivot);

        System.out.print("처음 swap 전 : ");
        for(int l = 0; l < arr.length; l++) {
            System.out.print(arr[l] + ", ");
        }
        System.out.println();

        System.out.println("mid = " + mid + " = " + arr[mid] + " // " + "high = " + high + " = " + arr[high]);
        swap(arr, mid, high); // 피벗을 배열의 마지막 요소로 이동

        System.out.print("처음 swap 후 : ");
        for(int l = 0; l < arr.length; l++) {
            System.out.print(arr[l] + ", ");
        }
        System.out.println();

        int i = low - 1; // 작은 요소들의 마지막 인덱스를 초기화
        System.out.println(i);
        // 피벗을 제외한 나머지 요소들을 피벗과 비교하여 배열을 재정렬
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) { // 현재 요소가 피벗보다 작거나 같으면
                i++; // 작은 요소의 인덱스를 증가시키고
                swap(arr, i, j); // 해당 요소와 i 인덱스의 요소를 교환
                System.out.print("i: " + i + ", j: " + j + " ==> ");
                for(int l = 0; l < arr.length; l++) {
                    System.out.print(arr[l] + ", ");
                }
                System.out.println();
            }
        }

        swap(arr, i + 1, high); // 피벗을 올바른 위치로 이동
        System.out.print("피벗 올바른위치 이동 : ");
        for(int l = 0; l < arr.length - 1; l++) {
            System.out.print(arr[l] + ", ");
        }
        System.out.println();
        return i + 1; // 피벗의 최종 위치를 반환
    }

    // 두 요소의 값을 교환하는 메서드
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i]; // 첫 번째 요소를 임시 변수에 저장
        arr[i] = arr[j]; // 두 번째 요소를 첫 번째 위치로 이동
        arr[j] = temp; // 임시 변수에 저장된 값을 두 번째 위치로 이동
    }

    // 배열의 현재 상태를 출력하는 메서드
    private static void printArray(int[] arr, int low, int high) {
        System.out.print("Current array: ");
        for (int i = low; i <= high; i++) { // 지정된 범위의 배열 요소들을 순회하며
            System.out.print(arr[i] + " "); // 각 요소를 출력
        }
        System.out.println(); // 줄바꿈
    }

    // 메인 메서드, 프로그램의 시작점
    public static void main(String[] args) {
        int[] arr = {10, 7, 8, 9, 1, 5}; // 정렬할 배열을 정의
        int n = arr.length; // 배열의 길이를 변수에 저장

        System.out.println("Original array: "); // 원본 배열을 출력
        printArray(arr, 0, n - 1); // 원본 배열 상태를 출력
        System.out.println("Sorting process:"); // 정렬 과정 시작 메시지 출력
        quickSort(arr, 0, n - 1); // Quick Sort를 호출하여 배열을 정렬

        System.out.println("Sorted array: "); // 정렬된 배열을 출력
        printArray(arr, 0, n - 1); // 정렬된 배열 상태를 출력
    }
}
