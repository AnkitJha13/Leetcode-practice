class Solution {
    public void reverseString(char[] s) {
        Stack<Character> St = new Stack<>();
        int i = 0;
        while(i < s.length){
            St.push(s[i]);
            i++;
        }

        i = 0;
        while(!St.isEmpty()){
            s[i] = St.pop();
            i++;
        }

    }
}