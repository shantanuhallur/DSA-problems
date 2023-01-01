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
    int ancestor = -1;
    public class pair{
        int min;
        int max;
        pair(int min,int max){
            this.min = min;
            this.max = max;
        }
    }
    int getMin(int ...arr) {
        int min = arr[0];
        for(int ele : arr) {
            if(min>ele) {
                min = ele;
            }
        }
        return min;
    }
    
    int getMax(int ...arr) {
        int min = arr[0];
        for(int ele : arr) {
            if(min<ele) {
                min = ele;
            }
        }
        return min;
    }
    public pair maxi(TreeNode root) {
        if(root.left==null && root.right== null) return new pair(root.val,root.val);
        
        pair leftP = new pair(root.val,root.val);
        pair rightP = new pair(root.val,root.val);
        if(root.left != null) leftP = maxi(root.left);
        if(root.right != null) rightP = maxi(root.right);
        
        if(ancestor< Math.abs(leftP.min-root.val)) ancestor = Math.abs(leftP.min-root.val);
        if(ancestor< Math.abs(leftP.max-root.val)) ancestor = Math.abs(leftP.max-root.val);
        
        
        if(ancestor< Math.abs(rightP.min-root.val)) ancestor = Math.abs(rightP.min-root.val);
        if(ancestor< Math.abs(rightP.max-root.val)) ancestor = Math.abs(rightP.max-root.val);
        
        pair myP = new pair(getMin(leftP.min,rightP.min,root.val),getMax(leftP.max,rightP.max,root.val));
        
        return myP;
    }
    public int maxAncestorDiff(TreeNode root) {
        maxi(root);
        return ancestor;
    }
}