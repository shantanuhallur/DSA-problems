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
    public TreeNode dfs(TreeNode node,TreeNode target,HashMap<TreeNode,TreeNode> backMap) {
        if(node==null) return null;
        if(node == target) return node;
        
        TreeNode left =dfs(node.left,target,backMap);
        if(left!=null){
            backMap.put(node.left,node);
            return left;
        }
        TreeNode right =dfs(node.right,target,backMap);
        if(right!=null){
            backMap.put(node.right,node);
            return right;
        }
        return null;
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> ans = new ArrayList<>();
        HashMap<TreeNode,TreeNode> backMap = new HashMap<>();
        TreeNode tar = dfs(root,target,backMap);
        LinkedList<TreeNode> que = new LinkedList<>();
        HashSet<TreeNode> vis = new HashSet<>();
        que.addLast(tar);
        vis.add(tar);
        
        while(k-->0) {
            int size = que.size();
            while(size-->0){
            TreeNode removeN = que.removeFirst();

            if(removeN.left != null &&  vis.add(removeN.left)) {
                    que.addLast(removeN.left);
            }

            if(removeN.right != null && vis.add(removeN.right)) {
                que.addLast(removeN.right);
            }

            if(backMap.containsKey(removeN) && vis.add(backMap.get(removeN))) {
                que.addLast(backMap.get(removeN));
            }
        }
            
        }
        for(TreeNode N : que) {
            ans.add(N.val);
        }

        return ans;
    }
}