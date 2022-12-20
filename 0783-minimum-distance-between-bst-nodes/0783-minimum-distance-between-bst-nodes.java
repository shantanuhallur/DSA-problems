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
    int ans = (int)1e8;
    
    public int getMin(int... arr) {
        int min = arr[0];
        for(int ele : arr) {
            min = Math.min(ele,min);
        }
        return min;
    }
    
    public int[] getMinMax(TreeNode node) {
        if(node.left == null && node.right == null) return new int[]{node.val,node.val};
            
        int[] leftMinMax = new int[]{(int)1e8,-(int)1e8};
           
        int[] rightMinMax = new int[]{(int)1e8,-(int)1e8};
           
        
        if(node.left != null) {
            leftMinMax = getMinMax(node.left);
        }
        
        if(node.right != null) {
            rightMinMax = getMinMax(node.right);
        }
        
        //ans
        ans = getMin(ans,Math.abs(leftMinMax[0]-node.val),Math.abs(leftMinMax[1]-node.val),Math.abs(rightMinMax[0]-node.val),
            Math.abs(rightMinMax[1]-node.val));
        
        int[] myNodeMinMax = new int[2];
        
        //min
        myNodeMinMax[0] = Math.min(leftMinMax[0],Math.min(node.val,rightMinMax[0]));
        //max
        myNodeMinMax[1] = Math.max(leftMinMax[1],Math.max(node.val,rightMinMax[1]));
        
        
        return myNodeMinMax; 
    }
    public int minDiffInBST(TreeNode root) {
        int[] dummy = getMinMax(root);
        return ans;
    }
}