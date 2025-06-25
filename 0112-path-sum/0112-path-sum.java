/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        // Base case: if the root is null, no path exists
        if (root == null) return false;

        // Check if we are at a leaf node and the targetSum is reached
        if(root.left == null && root.right == null){
            return targetSum == root.val;  // means if leaf node is equal to targetSum
        }


        int newTarget = targetSum - root.val;

        return (hasPathSum(root.left, newTarget) || hasPathSum(root.right, newTarget));
    }
}