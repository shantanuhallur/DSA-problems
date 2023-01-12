/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    // {VAL,IDX}
    int getSwaps(vector<int>& arr1) {
        int totalSwaps = 0;
        int n = arr1.size();
        vector<pair<int,int>> arr(n,{0,0});
        for(int i=0;i<n;i++) arr[i] = {arr1[i],i};
        sort(arr.begin(),arr.end());
        vector<bool> vis(n,false);
        for(int i=0;i<n;i++) {
            if(vis[i]==true ||arr[i].second == i) continue;
            int cycleC = 0;
            int j = i;
            while(vis[j]==false) {
                vis[j] = true;
                cycleC++;
                j = arr[j].second;
            }
            totalSwaps += cycleC-1;
        }
        return totalSwaps;
    }
    
    int minimumOperations(TreeNode* root) {
        int ans = 0;
        queue<TreeNode*> que;
        que.push(root);
        while(que.size()!=0) {
            int size = que.size();
            vector<int> arr(size,0);
            int i=0;
            int countSwaps = 0;
            while(size-->0) {
                TreeNode* removeN = que.front(); que.pop();
                
                arr[i++] = removeN->val;
                if(removeN->left!= NULL) que.push(removeN->left);
                if(removeN->right!= NULL) que.push(removeN->right);
            }
            for(int i=0;i<size;i++) cout<<arr[i];
            countSwaps = getSwaps(arr);
            ans += countSwaps;
        }
        return ans;
    }
};