class Solution {

    // Count the number of prime numbers less than n
    public int countPrimes(int n) {
        if (n < 2) return 0; // No primes less than 2

        boolean[] primes = new boolean[n]; // Boolean array to track primes
        for (int i = 2; i < n; i++) {
            primes[i] = true; // Assume all numbers are prime initially
        }

        int count = 0;
        // Sieve of Eratosthenes logic
        for (int i = 2; i < n; i++) {
            if (primes[i]) { // i is prime
                count++;
                // Mark multiples of i as non-prime
                for (int j = 2 * i; j < n; j += i) {
                    primes[j] = false;
                }
            }
        }
        return count; // Return the count of prime numbers
    }
}
