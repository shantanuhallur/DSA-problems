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
    
        public int rootToNodeDistance_01(TreeNode node, TreeNode target, int K, List<Integer> ans) {
        if(node == null) return -1;
        if(node == target) {
            printKDown(node, null, K, ans);
            return 1;
        }

        int las = rootToNodeDistance_01(node.left, target, K, ans);
        if(las != -1) {
            printKDown(node, node.left, K-las, ans);
            return las + 1;
        }

        int ras = rootToNodeDistance_01(node.right, target, K, ans);
        if(ras != -1) {
            printKDown(node, node.right, K-ras, ans);
            return ras + 1;
        }

        return -1;
    }
    
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> ans = new ArrayList<>();
        rootToNodeDistance_01(root, target , k, ans );
        return ans;
    }
}