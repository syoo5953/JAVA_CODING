public class 타일링 {
    public static void main(String[] args) {
        int n = 8;
        solution(n);
    }

    public static int solution(int n) {
        int answer = 0;
        int mod = 1000000007;
        long[] dp = new long[5001];

        dp[0] = 1;
        dp[2] = 3;
        for(int i=4; i<=n; i+=2){
            dp[i] = dp[i-2] * 3;
            System.out.println("i = " + i);
            System.out.println(dp[i]);
            for(int j=i-4; j>=0; j-=2){
                dp[i] += dp[j] * 2;
                System.out.println("j = " + j);
                System.out.println(dp[j] * 2);
            }
            System.out.println();
            dp[i] = dp[i] % mod;
        }

        answer = (int) dp[n];
        return answer;
    }
}
