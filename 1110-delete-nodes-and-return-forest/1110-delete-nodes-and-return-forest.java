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
    public TreeNode delNodes_01(TreeNode node, HashSet<Integer> s,ArrayList<TreeNode> ans) {
        //Base Case
        if(node == null) return null;
        //Left and Right Recursive Calls
        node.left = delNodes_01(node.left,s,ans);
        node.right = delNodes_01(node.right,s,ans);
        //If current node is to be deleted.
        if(s.contains(node.val)) {
            if(node.left != null) {
                ans.add(node.left);
            }
            if(node.right != null) {
                ans.add(node.right);
            }

            return null;
        }
        //If we dont want to delete the current Node.
        return node;
    }
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        ArrayList<TreeNode> ans = new ArrayList<>();
        HashSet<Integer> s = new HashSet<>();
        //Quick lookup for deletion.
        for(int ele : to_delete) {
            s.add(ele);
        }
        if(!s.contains(root.val)) {
            ans.add(root);
        }
        delNodes_01(root,s,ans);
        return ans;
    }
}