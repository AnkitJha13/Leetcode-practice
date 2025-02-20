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
    private int maxSum = 0;
    private int findMaxPath(TreeNode node){
        if(node == null){
            return 0;
        }

        int leftSum = Math.max(findMaxPath(node.left), 0);
        int rightSum = Math.max(findMaxPath(node.right), 0);

        int currentMax = node.val + leftSum + rightSum;

        maxSum = Math.max(maxSum, currentMax);

        // to find max sum of single path (left or right) 
        return node.val + Math.max(leftSum, rightSum);
    }
    
    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        findMaxPath(root);
        return maxSum;
    }
}