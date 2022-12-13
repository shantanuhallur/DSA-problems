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
    int camera=0;
    //-1 i need a camera
    //0 i am covered
    //1 i have a camera
    public int minCameraCover_(TreeNode node) {
        if(node == null) return 0;
        
        int lans = minCameraCover_(node.left);
        int rans = minCameraCover_(node.right);
        
        if(lans == -1 || rans == -1) {
            camera++;
            return 1;
        }
        
        if(lans == 1 || rans == 1) {
            return 0;
        }
        
        return -1;
    }
    public int minCameraCover(TreeNode root) {
        if(root == null) return 0;
        int rootans = minCameraCover_(root);
        if(rootans == -1) camera++;
        return camera;
    }
}