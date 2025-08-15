class Solution {
    public boolean checkPowersOfThree(int n) {
        while (n > 0) {
            if (n % 3 == 2) return false; // digit '2' not allowed
            n /= 3;
        }
        return true;
    }
}
