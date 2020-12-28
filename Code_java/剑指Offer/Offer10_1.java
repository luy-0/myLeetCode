public class Offer10_1 {
    static class Solution {
        public int fib(int n) {
            if (n < 2) {
                return n;
            }
            int n1 = 0;
            int n2 = 1;
            int ans = -1;
            for (int i = 2; i <= n; i++) {
                ans = (n1 + n2) % 1000000007;
                n1 = n2;
                n2 = ans;
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        new Solution().fib(45);
    }
}