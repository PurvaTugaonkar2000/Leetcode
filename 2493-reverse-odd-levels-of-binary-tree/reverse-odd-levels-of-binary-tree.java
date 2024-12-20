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
    public TreeNode reverseOddLevels(TreeNode root) {
        traverseDFS(root.left, root.right, 0);
        return root;
    }
    private void traverseDFS(TreeNode leftchild, TreeNode rightchild, int level){
        if(leftchild == null || rightchild == null){
            return;
        }
        if(level %2 == 0){
            int temp = leftchild.val;
            leftchild.val = rightchild.val;
            rightchild.val = temp;
        }
        traverseDFS(leftchild.left, rightchild.right, level+1);
        traverseDFS(leftchild.right, rightchild.left, level+1);
    }
}