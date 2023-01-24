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
    public TreeNode dfs(TreeNode node,TreeNode target, HashMap<TreeNode,TreeNode> backMap) {
        if(node==null) return null;
        if(node.val == target.val) {
            return node;
        }
        TreeNode left = dfs(node.left,target,backMap);
        if(left!=null) {
            backMap.put(node.left,node);
            return left;
        }
        
        TreeNode right = dfs(node.right,target,backMap);
        if(right!=null) {
            backMap.put(node.right,node);
            return right;
        }
        
        return null;
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode,TreeNode> backMap = new HashMap<>();
        TreeNode tar = dfs(root,target,backMap);
        HashSet<Integer> set = new HashSet<>();
        LinkedList<TreeNode> que = new LinkedList<>();
        
        que.addLast(tar);
        while(k-->0) {
            int size = que.size();
            while(size-->0) {
                TreeNode rn = que.removeFirst();
                
                if(rn.left!=null && set.add(rn.left.val)) {
                    que.addLast(rn.left);
                }
                
                if(rn.right!=null && set.add(rn.right.val)) {
                    que.addLast(rn.right);
                }
                
                if(backMap.containsKey(rn) && set.add(rn.val)) {
                    que.addLast(backMap.get(rn));
                }
             }
        }
        List<Integer> ans = new ArrayList<>();
        for(TreeNode node : que) {
            ans.add(node.val);
        }
        return ans;
    }
}