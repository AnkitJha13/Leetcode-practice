class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }

       
        HashMap<Character, Integer> tCount = new HashMap<>();
        for (char c : t.toCharArray()) {
            tCount.put(c, tCount.getOrDefault(c, 0) + 1);
        }

        
        int left = 0, right = 0; 
        int required = tCount.size(); 
        int matched = 0; 
        int minLen = Integer.MAX_VALUE; 
        int minStart = 0;

      
        HashMap<Character, Integer> windowCount = new HashMap<>();

        while (right < s.length()) {
            char rightChar = s.charAt(right); 
            windowCount.put(rightChar, windowCount.getOrDefault(rightChar, 0) + 1);

            
            if (tCount.containsKey(rightChar) && 
                      windowCount.get(rightChar).equals(tCount.get(rightChar))) {
                matched++;
            }

           
            while (matched == required) {
                
                if (minLen > right - left + 1) {
                    minLen = right - left + 1;
                    minStart = left;
                }

            
                char leftChar = s.charAt(left);
                windowCount.put(leftChar, windowCount.get(leftChar) - 1);

                if (tCount.containsKey(leftChar) && 
                           windowCount.get(leftChar) < tCount.get(leftChar)) {
                    matched--;
                }

                left++; // Shrink the window from the left
            }

            right++; // Expand the window from the right
        }

        // Return the smallest window or an empty string if no window was found
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }
}
