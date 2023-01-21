class Solution {
public:
    int subarraySum(vector<int>& nums, int k) {
        unordered_map<int,int> map;
        map[0]++;
        int ans = 0;
        int prefSum=0;
        for(int i : nums) {
            prefSum+= i;
            if(map.find(prefSum-k)!=map.end()) {
                ans+=map[prefSum-k];
            }
            map[prefSum]++;
        }
        return ans;
    }
};