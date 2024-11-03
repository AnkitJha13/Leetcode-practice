class Solution {
    public boolean isPalindrome(int x) {
         if (x < 0) {
            return false; // Negative numbers are not palindromic
        }
        int originalNum = x;
        int rev = 0;
        while(x!=0){
            int lastDigit = x % 10;
            // if((rev > Integer.MAX_VALUE/10) || (rev < Integer.MIN_VALUE/10)){
            //     return 0;
            // }
            rev = (rev * 10) + lastDigit;
            x = x/10;
        }

        if(rev == originalNum){
            return true;
        }
        else{
            return false;
        }
    }
}