class Solution {
    public static void heapify(int[] nums, int i, int size){
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int maxIdx = i;

        if(left < size && nums[left] > nums[maxIdx]){
            maxIdx = left;
        }
        if(right < size && nums[right] > nums[maxIdx]){
            maxIdx = right;
        }

        if(maxIdx != i){
            int temp = nums[i];
            nums[i] = nums[maxIdx];
            nums[maxIdx] = temp;

            heapify(nums, maxIdx, size);
        }
    }

    public static void heapSort(int[] nums){
        // Step 1 - Build max heap
        int n = nums.length;
        for(int i = n / 2 - 1; i >= 0; i--){ // Start from last non-leaf node
            heapify(nums, i, n);
        }

        // Step 2 - Push largest element to the end
        for(int i = n - 1; i > 0; i--){
            int temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;

            heapify(nums, 0, i);
        }
    }

    public int[] sortArray(int[] nums) {
        heapSort(nums);
        return nums;
    }
}
