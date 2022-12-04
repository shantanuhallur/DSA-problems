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
        public static class verticalPair_02 {
        TreeNode node = null;
        int x = 0;
        int y = 0;

        verticalPair_02(TreeNode node, int x, int y) {
            this.node = node;
            this.x = x;
            this.y = y;
        }
    }

    public static List<List<Integer>> verticalTraversal(TreeNode root) {
        PriorityQueue<verticalPair_02> que = new PriorityQueue<>((a, b) -> {
            if (a.y != b.y)
                return a.y - b.y;
            else
                return a.node.val - b.node.val;
        });

        que.add(new verticalPair_02(root, 0,0));
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int maxHL = -(int) 1e9;
        int minHL = (int) 1e9;
        while (que.size() != 0) {
            
                verticalPair_02 rp = que.remove();

                map.putIfAbsent(rp.x, new ArrayList<>());
                map.get(rp.x).add(rp.node.val); // get that list of the level and then add this node's val into it.
                maxHL = Math.max(maxHL, rp.x);
                minHL = Math.min(minHL, rp.x);

                if (rp.node.left != null) {
                    que.add(new verticalPair_02(rp.node.left, rp.x-1,rp.y+1));
                }

                if (rp.node.right != null) {
                    que.add(new verticalPair_02(rp.node.right,rp.x+1,rp.y+1));
                }
        }

        List<List<Integer>> ans = new ArrayList<>();
        while (minHL <= maxHL) {
            ans.add(map.get(minHL));
            minHL++;
        }

        return ans;
    }
}