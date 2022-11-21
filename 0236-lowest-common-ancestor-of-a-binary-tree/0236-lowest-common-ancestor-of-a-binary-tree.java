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
    
        public ArrayList<TreeNode> rootToNode(TreeNode node, int data) {
        if (node == null)
            return new ArrayList<>();

        if (node.val == data) {
            ArrayList base = new ArrayList<>();
            base.add(node);
            return base;
        }

        ArrayList left = rootToNode(node.left, data);
        if (left.size() > 0) {
            left.add(node);
            return left;
        }

        ArrayList right = rootToNode(node.right, data);
        if (right.size() > 0) {
            right.add(node);
            return right;
        }

        return new ArrayList<>();
    }
    
       public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<TreeNode> list1 = new ArrayList<>();
        ArrayList<TreeNode> list2 = new ArrayList<>();

        list1 = rootToNode(root, p.val);
        list2 = rootToNode(root, q.val);

        int i = list1.size() - 1;
        int j = list2.size() - 1;

        TreeNode LCA = null;

        while (i >= 0 && j >= 0) {
            if (list1.get(i) != list2.get(j))
                break;
            LCA = list1.get(i);
            i--;
            j--;
        }

        return LCA;
    }
}