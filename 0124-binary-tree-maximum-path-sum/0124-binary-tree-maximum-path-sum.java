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
    public static class maxNodeToNodePair {
        int NTN_sum = -(int)1e9; // Node To Node Sum.
        int NTR_sum = 0;   // Root To Node Sum.

        maxNodeToNodePair(int NTN_sum , int NTR_sum) {
            this.NTN_sum = NTN_sum;
            this.NTR_sum = NTR_sum;
        }

        maxNodeToNodePair() {}
    }

    public static int maxCompare(int... arr) {
        int max = arr[0];
        for(int ele : arr) {
            max = Math.max(ele,max);
        }
        return max;
    }
    
    public maxNodeToNodePair maxPathSumHard_02(TreeNode root) {
        if(root==null) return new maxNodeToNodePair();
        
        maxNodeToNodePair lans =  maxPathSumHard_02(root.left);
        maxNodeToNodePair rans =  maxPathSumHard_02(root.right);

        maxNodeToNodePair myAns = new maxNodeToNodePair();
        myAns.NTN_sum = maxCompare(lans.NTN_sum,rans.NTN_sum,root.val,lans.NTR_sum + root.val,
                                   rans.NTR_sum + root.val,lans.NTR_sum + rans.NTR_sum + root.val);
        myAns.NTR_sum = maxCompare(root.val, lans.NTR_sum + root.val, rans.NTR_sum + root.val);
        
       return myAns;
    }
    
    public int maxPathSum(TreeNode root) {
        if(root==null)return 0;
        
        return maxPathSumHard_02(root).NTN_sum;
    }
}