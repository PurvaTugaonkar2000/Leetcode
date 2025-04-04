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
    public String getDirections(TreeNode root, int startValue, int destValue) {
        StringBuilder pathToStart = new StringBuilder();
        StringBuilder pathToDest = new StringBuilder();

        findPath(root, startValue, pathToStart);
        findPath(root, destValue, pathToDest);

        int i = 0;
        while(i < pathToStart.length() && i < pathToDest.length() && pathToStart.charAt(i) == pathToDest.charAt(i)){
            i++;
        }
        int upMoves = pathToStart.length() - i;

        StringBuilder result = new StringBuilder();
        for(int j = 0; j < upMoves; j++){
            result.append('U');
        }
        result.append(pathToDest.substring(i));

        return result.toString();

    }
    private boolean findPath(TreeNode root, int target, StringBuilder path){
        if(root == null) return false;
        if(root.val == target) return true;

        path.append('L');
        if(findPath(root.left, target, path)) return true;
        path.deleteCharAt(path.length() - 1);

        path.append('R');
        if(findPath(root.right, target, path)) return true;
        path.deleteCharAt(path.length() - 1);

        return false;
    }
}