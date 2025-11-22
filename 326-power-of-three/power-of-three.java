class Solution {
    public boolean isPowerOfThree(int n) {
        long num = 1;
        while (num < n) {
            num *= 3;
        }
        return num == n;
    }
}
