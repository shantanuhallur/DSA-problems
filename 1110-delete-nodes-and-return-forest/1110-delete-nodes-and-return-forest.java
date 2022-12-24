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
    public TreeNode delNodes_01(TreeNode node,  HashSet<Integer> set,ArrayList<TreeNode> ans) {
        if(node == null) return null;
        
        node.left = delNodes_01(node.left,set,ans);
        node.right = delNodes_01(node.right,set,ans);
        
        if(set.contains(node.val)) {
            if(node.left != null) {
                ans.add(node.left);
            }
            
            if(node.right != null) {
                ans.add(node.right);
            }
            return null;
        }
        return node;
    }
            
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        ArrayList<TreeNode> ans = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        for(int ele : to_delete) {
            set.add(ele);
        }
        if(!set.contains(root.val)){
            ans.add(root);
        }
        delNodes_01(root,set,ans);
        return ans;
    }
}