class Solution {
public:
    bool isPalindrome(int x) {
        if (x < 0) {
            return false; // Negative numbers are not palindromic
        }
        int originalNum = x;
        int ans = 0;
        while(x!=0){
            int digit = x%10;
            if((ans > INT_MAX/10) || (ans < INT_MIN/10)){
                return 0;
            }
            ans = (ans * 10) + digit;
            x = x/10;
        }

        if(ans == originalNum){
            return true;
        }
        else{
            return false;
        }
    }
};