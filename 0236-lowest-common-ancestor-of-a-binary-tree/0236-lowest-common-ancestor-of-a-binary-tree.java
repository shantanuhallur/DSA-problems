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
    
       public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<TreeNode> list1 = new ArrayList<>();
        ArrayList<TreeNode> list2 = new ArrayList<>();

        rootToNode(root, p.val,list1);
        rootToNode(root, q.val,list2);

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