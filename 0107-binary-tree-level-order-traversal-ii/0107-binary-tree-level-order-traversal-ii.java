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
    public static void levelOrder_M3(TreeNode root, Stack<List<Integer>> st) {
        LinkedList<TreeNode> que = new LinkedList<>();
        que.addLast(root);

        int level = 0;
        while (que.size() != 0) {
            //System.out.println("Level :" + level + " : ");
            List<Integer> smallAns = new ArrayList<>();
            int size = que.size();
            while (size-- > 0) {
                TreeNode rn = que.removeFirst(); // remove Node
                //System.out.print(rn.val + " ");
                smallAns.add(rn.val);

                if (rn.left != null)
                    que.addLast(rn.left);
                if (rn.right != null)
                    que.addLast(rn.right);

            }
            List<Integer> base = new ArrayList<>(smallAns);
            st.push(base);
            smallAns.clear();
        }
    }
    
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root==null) return new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        Stack<List<Integer>> st = new Stack<>();
        levelOrder_M3(root,st);
        while(st.size()>0) {
            ans.add(st.pop());
        }
        return ans;
    }
}