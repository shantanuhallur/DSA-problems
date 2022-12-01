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
    
public void levelOrder_M1(TreeNode root , List<List<Integer>> ans) {
        LinkedList<TreeNode> que = new LinkedList<>();
        LinkedList<TreeNode> childQue = new LinkedList<>();
        que.addLast(root);
        int level = 0;
        List<Integer> smallAns = new ArrayList<>();
        //System.out.println("Level :" + level + " : ");
        while (que.size() != 0) {
            TreeNode rn = que.removeFirst(); // remove Node
            smallAns.add(rn.val);
            //System.out.print(rn.val + " ");

            if (rn.left != null)
                childQue.addLast(rn.left);
            if (rn.right != null)
                childQue.addLast(rn.right);

            if(que.size() == 0 ) {
                //System.out.println();
                //System.out.print("Level :" + (++level) + " : ");
                ans.add(smallAns);
                smallAns = new ArrayList<>();
                LinkedList<TreeNode> temp = new LinkedList<>();
                temp = que;
                que = childQue;
                childQue = temp;
            }
        }
    }
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null) return new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        levelOrder_M1(root,ans);
        return ans;
    }
}