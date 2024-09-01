public class LongestPalindromicSubstring {

    // 가장 긴 팰린드롬 부분 문자열을 찾는 메소드
    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";

        int start = 0, end = 0;

        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i); // 홀수 길이의 팰린드롬
            int len2 = expandAroundCenter(s, i, i + 1); // 짝수 길이의 팰린드롬
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    // 주어진 중심에서 팰린드롬을 확장하는 메소드
    private static int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1; // 팰린드롬의 길이 반환
    }

    public static void main(String[] args) {
        // 입력 예시 문자열
        String s = "babad";
        
        // 가장 긴 팰린드롬 부분 문자열 계산
        String result = longestPalindrome(s);
        
        // 결과 출력
        System.out.println("Longest Palindromic Substring: " + result);
    }
}
