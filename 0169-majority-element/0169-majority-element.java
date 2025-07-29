class Solution {
    public int majorityElement(int[] nums) {
        int el = 0;
        int cnt = 0;

        for(int i=0;i<nums.length;i++){
            if(cnt == 0){
                el = nums[i];
                cnt = 1;
            }
            else if(el == nums[i]){
                cnt++;
            }
            else{
                cnt--;
            }
        }

        int cnt1 = 0;
        for(int i=0;i<nums.length;i++){
            if(el == nums[i]){
                cnt1++;
            }
        }

        if(cnt1 > nums.length/2){
            return el;
        }

        return -1;
    }
}