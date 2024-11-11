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
    private void traversePreOrder(TreeNode curr, ArrayList<Integer> ans){
        if(curr == null){
            return ;
        }

        ans.add(curr.val);
        traversePreOrder(curr.left, ans);
        traversePreOrder(curr.right, ans);


    }
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        traversePreOrder(root, ans);
        return ans;

    }
}