class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int size = nums.length;

        Stack<Integer> s = new Stack<>();
        int result[] = new int[size];

        for(int i=2*size-1;i>=0;i--){
            int currentIdx = i % size;

            while(!s.isEmpty() && nums[s.peek()] <= nums[currentIdx]){
                s.pop();
            }

            if(s.isEmpty()){
                result[currentIdx] = -1;
            }
            else{
                result[currentIdx] = nums[s.peek()];
            }

            s.push(currentIdx);
        }

        return result;
    }
}