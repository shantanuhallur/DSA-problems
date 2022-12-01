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
     public static void levelOrder_M3(TreeNode root, List<Integer> ans) {
        LinkedList<TreeNode> que = new LinkedList<>();
        que.addLast(root);

        int level = 0;
        while (que.size() != 0) {
            //System.out.println("Level :" + level + " : ");
            int size = que.size();
            for(int i=0;i<size;i++){
                TreeNode rn = que.removeFirst(); // remove Node
                //System.out.print(rn.val + " ");
                if(i==0)ans.add(rn.val);
                
                if (rn.right != null)
                    que.addLast(rn.right); //first add from right as we need right side view.
                
                if (rn.left != null)
                    que.addLast(rn.left);
            }
        }
    }
    
    public List<Integer> rightSideView(TreeNode root) {
        if(root==null) return new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        levelOrder_M3(root,ans);
        return ans;
    }
}