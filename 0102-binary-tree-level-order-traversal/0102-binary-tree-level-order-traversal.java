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
                List<Integer> base = new ArrayList<>(smallAns);
                ans.add(base);
                smallAns.clear();
                LinkedList<TreeNode> temp = new LinkedList<>();
                temp = que;
                que = childQue;
                childQue = temp;
            }
        }
    }
    
    public static void levelOrder_M2(TreeNode root, List<List<Integer>> ans) {
        LinkedList<TreeNode> que = new LinkedList<>();
        que.addLast(root);
        que.addLast(null);

        //int level = 0;
        List<Integer> smallAns = new ArrayList<>();
        //System.out.println("Level :" + level + " : ");
        while (que.size() != 1) {
            TreeNode rn = que.removeFirst(); // remove Node
            //System.out.print(rn.val + " ");
            smallAns.add(rn.val);
            
            if (rn.left != null)
                que.addLast(rn.left);
            if (rn.right != null)
                que.addLast(rn.right);

            if (que.getFirst() == null) {
                //System.out.println();
                //System.out.print("Level :" + (++level) + " : ");
                List<Integer> base = new ArrayList<>(smallAns);
                ans.add(base);
                smallAns.clear();
                
                que.addLast(que.removeFirst());

            }
        }
    }
    
    public static void levelOrder_M3(TreeNode root, List<List<Integer>> ans) {
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
            ans.add(base);
            smallAns.clear();
        }
    }
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null) return new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        levelOrder_M3(root,ans);
        return ans;
    }
}