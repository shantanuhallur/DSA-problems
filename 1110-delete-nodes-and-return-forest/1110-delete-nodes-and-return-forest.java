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
    public TreeNode delNodes_01(TreeNode node,HashSet<Integer> map,ArrayList<TreeNode> ans) {
        if(node == null) return null;
        
        node.left = delNodes_01(node.left,map,ans);
        node.right = delNodes_01(node.right,map,ans);
        
        if(map.contains(node.val)) {
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
        HashSet<Integer> map = new HashSet<>();
        for(int ele : to_delete) {
            map.add(ele);
        }
        ArrayList<TreeNode> ans = new ArrayList<>();  
        if(!map.contains(root.val)) {
            ans.add(root);
        }
        delNodes_01(root,map,ans);
        return ans;
        
       
    }
}