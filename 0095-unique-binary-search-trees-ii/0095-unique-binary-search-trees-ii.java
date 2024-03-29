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
    public List<TreeNode> generateTree(int st,int end) {
        //Base Case
        if(st>end) {
            ArrayList<TreeNode> base = new ArrayList<>();
            base.add(null);
            return base;
        }
        List<TreeNode> ans = new ArrayList<>();
        for(int i =st;i<=end;i++) {
            //left and right recursive call
            List<TreeNode> left = generateTree(st,i-1);
            List<TreeNode> right = generateTree(i+1,end);
            for(TreeNode l : left) {
                for(TreeNode r : right) {
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    ans.add(root);
                }
            }
        }
        return ans;
    }
    public List<TreeNode> generateTrees(int n) {
        return generateTree(1,n);
    }
}