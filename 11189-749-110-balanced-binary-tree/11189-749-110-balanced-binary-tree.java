class Solution {
    private boolean isTreeBalanced = true;  // Flag to track tree balance

    private int height(TreeNode root) {
        if (root == null) return 0;

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        if (Math.abs(leftHeight - rightHeight) > 1) {
            isTreeBalanced = false;
        }

        return Math.max(leftHeight, rightHeight) + 1; 
    }

    
    public boolean isBalanced(TreeNode root) {
        height(root); 
        return isTreeBalanced; 
    }
}