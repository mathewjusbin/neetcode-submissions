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
    private int count = 0;
    private int answer = 0;

    public int kthSmallest(TreeNode root, int k) {
        innorder(root, k);
        return answer;
    }
    public void innorder(TreeNode node, int k){
        if(node == null){
            return;
        }

        innorder(node.left, k);
        count++;
        if(count == k){
            answer = node.val;
            return;
        }
        innorder(node.right, k);
    }
}
