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
    int sum = 0;
    public void getSum(TreeNode node,int currNum) {
        //Base Case
        if(node==null) return;
        //calculate maintained No
        int maintainedNo = currNum * 10 + node.val;
        //if my node is a leaf it means that my path has ended we need to add Maintained No in sum;
        if(node.left == null && node.right == null) {
            sum+= maintainedNo;
            return;
        }
            //left and right recursive call for traversing the whole tree
        getSum(node.left,maintainedNo);
        getSum(node.right,maintainedNo);
    }
    public int sumNumbers(TreeNode root) {
        getSum(root,0);
        return sum;
    }
}