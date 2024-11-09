class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;  // if no balloons
        
        // Sort the balloons by their ending position (xend)
        Arrays.sort(points, Comparator.comparingInt(a -> a[1]));
        
        int arrows = 1; // First arrow is shot at the first balloon
        int currentEnd = points[0][1]; // First balloon's end position
        
        // Iterate through the sorted balloons
        for (int i = 1; i < points.length; i++) {
            // If the start of the current balloon is greater than the end of the previous balloon
            if (points[i][0] > currentEnd) { 
                
                arrows++; // We need a new arrow for this balloon
                currentEnd = points[i][1];  // Update the end to the current balloon's end
            }
        }
        
        return arrows;
    }
}