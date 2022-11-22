/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean rootToNode(TreeNode node, int data, ArrayList<TreeNode> rtnPath) {
        if (node == null)
            return false;
        if (node.val == data) {
            rtnPath.add(node);
            return true;
        }

        boolean res = rootToNode(node.left, data, rtnPath) || rootToNode(node.right, data, rtnPath);
        if (res)
            rtnPath.add(node);

        return res;
    }
    
    public void printKDown(TreeNode node, TreeNode blockNode, int depth, List<Integer> ans) {
        if(node == null || depth < 0 || node == blockNode)
            return;
        
        if(depth == 0) {
            ans.add(node.val);
            return;
        }

        printKDown(node.left, blockNode, depth-1, ans);
        printKDown(node.right, blockNode, depth-1, ans);
    }
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> ans = new ArrayList<>();
        ArrayList<TreeNode> list = new ArrayList<>();
        rootToNode(root, target.val, list);
        TreeNode blockNode = null;

        for(int i=0;i<list.size();i++) {
            printKDown(list.get(i),blockNode,k-i,ans);
            blockNode = list.get(i);
        }

        return ans;
    }
}