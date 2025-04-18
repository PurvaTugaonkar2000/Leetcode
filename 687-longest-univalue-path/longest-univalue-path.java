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
    int max = 0;
    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return max;
    }
    private int dfs(TreeNode root){
        if(root == null) return 0;
        int left = dfs(root.left), right = dfs(root.right);
        if(root.left != null && root.val == root.left.val){
            left += 1;
        } else{
            left = 0;
        }
        if(root.right != null && root.val == root.right.val){
            right += 1;
        } else {
            right = 0;
        }
        max = Math.max(max, left + right);
        return Math.max(left, right);
    }

}