class Solution {
    public void reverseString(char[] s) {
        Stack<Character> st = new Stack<>();
        int i = 0;


        while(i < s.length){
            st.push(s[i]);
            i++;
        }

        i = 0;
        while(!st.isEmpty()){
            s[i] = st.pop();
            i++;

        }

    }
}