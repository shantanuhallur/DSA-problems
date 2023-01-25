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
    public TreeNode getTarget(TreeNode node,TreeNode target,HashMap<Integer,TreeNode> bm) {
        //base case
        if(node==null) return null;
        if(node.val==target.val) return node;
        TreeNode left = getTarget(node.left,target,bm);
        if(left!=null) {
            bm.put(node.left.val,node);
            return left;
        }
        TreeNode right = getTarget(node.right,target,bm);
        if(right!=null) {
            bm.put(node.right.val,node);
            return right;
        }
        
        return null;
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        // backmap,queue,set
        HashSet<Integer> vis= new HashSet<>();
        HashMap<Integer,TreeNode> bm = new HashMap<>();
        LinkedList<TreeNode> que = new LinkedList<>();
        //get targetNode
        TreeNode tar = getTarget(root,target,bm);
        que.addLast(tar);
        //BFS
        while(k-->0) {
            int size = que.size();
            while(size-->0) {
                TreeNode rn = que.removeFirst();
                
                //add left and right children
                if(rn.left != null && vis.add(rn.left.val)) {
                    que.addLast(rn.left);
                }
                if(rn.right!=null && vis.add(rn.right.val)) {
                    que.addLast(rn.right);
                }
                //explore parent paths if exist
                if(bm.containsKey(rn.val)) {
                    que.addLast(bm.get(rn.val));
                    vis.add(rn.val);
                }
            }
        }
        //add all the set nodes inside our que from bfs
        List<Integer> ans = new ArrayList<>();
        for(TreeNode node : que) {
            ans.add(node.val);
        }
        return ans;
    }
}