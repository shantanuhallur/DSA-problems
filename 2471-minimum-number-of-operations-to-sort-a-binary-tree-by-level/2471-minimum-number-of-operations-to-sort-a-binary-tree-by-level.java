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
    public class pair {
        int val;
        int idx;
        pair(int val,int idx) {
            this.val = val;
            this.idx = idx;
        }
    }
    
    public int getSwaps(int[] arr1) {
        int totalSwaps = 0;
        int n = arr1.length;
        pair[] arr = new pair[n];
        for(int i=0;i<n;i++) arr[i] = new pair(arr1[i],i);
        
        Arrays.sort(arr,(a,b)->{
            return a.val-b.val; // ascending
        });
        
        boolean[] vis = new boolean[n];
        for(int i=0;i<n;i++) {
            if(arr[i].idx == i || vis[i] == true) continue;
            int cycleC = 0;
            int j = i;
            while(vis[i]==false) {
                vis[i] = true;
                cycleC++;
                i = arr[i].idx;
            }
            totalSwaps += cycleC -1;
        }
        return totalSwaps;
    }
    public int minimumOperations(TreeNode root) {
        int ans = 0;
        LinkedList<TreeNode> que = new LinkedList<>();
        que.addLast(root);
        while(que.size()!=0) {
            int countSwaps=0;
            int size = que.size();
            int i=0;
            int[] arr1 = new int[size];
            while(size-->0) {
                TreeNode removeN = que.removeFirst();
                arr1[i++] = removeN.val;
                if(removeN.left!=null)que.addLast(removeN.left);
                if(removeN.right!=null)que.addLast(removeN.right);
            }
            countSwaps = getSwaps(arr1);
            ans += countSwaps;
        }
        return ans;
    }
}