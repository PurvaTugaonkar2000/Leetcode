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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null); // Marker for end of level
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> currLevel = new ArrayList<>();

        while (!q.isEmpty()) {
            TreeNode currNode = q.poll();

            if (currNode == null) {
                ans.add(currLevel);
                currLevel = new ArrayList<>();
                if (q.isEmpty()) break;
                q.add(null); // Marker for the next level
            } else {
                currLevel.add(currNode.val);
                if (currNode.left != null) q.add(currNode.left);
                if (currNode.right != null) q.add(currNode.right);
            }
        }

        return ans;
    }
}