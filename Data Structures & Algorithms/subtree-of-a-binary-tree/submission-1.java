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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        //An emtpy tree is always a subtree
        if(subRoot == null){
            return true;
        }
        //A non emtpy subtree will not be there in an empty tree
        //initially only we checked and returned thats why
        if(root == null){
            return false;
        }
        if(checkIfSubTree(root, subRoot)){//if we already foound the matching one
            //THen return immediately
            return true;
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
        //Why because at the left side or right side the tree can match
        //so thats why there is an or condition and we are returning it
    }

    public boolean checkIfSubTree(TreeNode root, TreeNode subTree){
        if(root ==null && subTree == null){
            return true;
        }
        if(root == null || subTree == null){
            return false;
        }
        if(root.val != subTree.val){
            return false;
        }
        return checkIfSubTree(root.left, subTree.left) && checkIfSubTree(root.right, subTree.right);
    }
}
