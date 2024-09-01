public class 팰린드롬 {

    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);     // 홀수 길이의 팰린드롬
            int len2 = expandAroundCenter(s, i, i + 1); // 짝수 길이의 팰린드롬
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

    public static void main(String[] args) {
        팰린드롬 solution = new 팰린드롬();
        System.out.println(solution.longestPalindrome("babad")); // 출력: "bab" 또는 "aba"
        System.out.println(solution.longestPalindrome("cbbd"));  // 출력: "bb"
    }
}
