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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        LinkedList<TreeNode> que = new LinkedList<>();
        LinkedList<Integer> col = new LinkedList<>();
        que.addLast(root); col.addLast(0);
        int min = 0 , max = 0;
        while(que.size()!=0) {
            TreeNode rn = que.removeFirst();
            int rc = col.removeFirst();
            
            if(!map.containsKey(rc)) {
                map.put(rc,new ArrayList<Integer>());
            }
            
            if(rn.left!=null) {
                que.addLast(rn.left);
                col.addLast(rc-1);
                min = Math.min(min,rc-1);
            }
            
            if(rn.right!=null) {
                que.addLast(rn.right);
                col.addLast(rc+1);
                max = Math.max(max,rc+1);
            }
            //add curr node in curr rc's lsit
            map.get(rc).add(rn.val);
        }
        for(int i=min;i<=max;i++) {
            ans.add(map.get(i));
        }
        return ans;
    }
}