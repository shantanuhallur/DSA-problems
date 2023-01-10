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
    public class Pair implements Comparable<Pair> {
        int val;
        int idx;
        
        Pair(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }
        
        @Override
        
        public int compareTo(Pair o) {
            //ascending
            return this.val - o.val;
        }
    }
    public int getCount(int[] arr1) {
        int n = arr1.length;
        Pair[] arr = new Pair[n];
        // pair arr =-> [element on idx of arr1 , idx]
        for(int i=0;i<n;i++) {
            arr[i] = new Pair(arr1[i],i);
        }
        
        Arrays.sort(arr);
        int ans = 0;
        boolean[] vis = new boolean[n];
        for(int i=0;i<n;i++) {
            if(arr[i].idx == i || vis[i] == true) continue;
            int j = i;
            int countC = 0;
            while(vis[j]==false) {
                vis[j] = true;
                countC++;
                j = arr[j].idx;
            }
            ans += countC-1;
        }
        return ans;
    }
    public int minimumOperations(TreeNode root) {
        int totalC = 0;
        LinkedList<TreeNode> que = new LinkedList<>();
        que.addLast(root);
        while(que.size()!=0) {
            int size = que.size();
            int[] arr1 = new int[size];
            int i = 0;
            while(size-->0) {
                TreeNode rn = que.removeFirst();
                arr1[i++] = rn.val;
                if(rn.left!=null) que.addLast(rn.left);
                if(rn.right!=null) que.addLast(rn.right);
            }
            int count = getCount(arr1);
            totalC += count;
        }
        return totalC;
    }
}