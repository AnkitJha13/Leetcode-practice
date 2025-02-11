class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> charFrequency = new HashMap<>();

        int maxlen = 0, maxfreq = 0, left = 0;

        for(int right = 0;right<s.length();right++){
          char currentChar = s.charAt(right);
          charFrequency.put(currentChar, charFrequency.getOrDefault(currentChar, 0) + 1);

          maxfreq = Math.max(maxfreq, charFrequency.get(currentChar));

          while((right-left+1) - maxfreq > k){  // for shrinking the window
            char leftChar = s.charAt(left);
            charFrequency.put(leftChar, charFrequency.get(leftChar) - 1);
            left++;
          }

          maxlen = Math.max(maxlen, right-left+1);
        }

        return maxlen;
    }
}