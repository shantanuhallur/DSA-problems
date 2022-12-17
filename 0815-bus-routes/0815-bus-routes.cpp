class Solution {
public:
int numBusesToDestination(vector<vector<int>>& routes, int src, int target) {
    if(src == target) return 0;
        int n = routes.size();
        unordered_map<int,vector<int>> busStandMapping;
        int busNumber = 0;
        for(vector<int> busStandList : routes) {
            for(int busStand: busStandList) {
                busStandMapping[busStand].push_back(busNumber);
            }
            busNumber++;
        } 


        unordered_set<int> isBusStandSeen;
        vector<int> isBusSeen(n,false);

        queue<int> que;
        que.push(src);
        isBusStandSeen.insert(src);
        int level = 0;
        while(que.size() != 0) {
            int size = que.size();
            while(size --> 0) {
                int busStand = que.front(); que.pop();
                
                vector<int> allBuses = busStandMapping[busStand];
                for(int busNo : allBuses) {

                    if(isBusSeen[busNo]){
                        continue;   
                    }
                    for(int bs : routes[busNo]){
                        if(isBusStandSeen.find(bs) == isBusStandSeen.end()){
                            que.push(bs);
                            isBusStandSeen.insert(bs);
                            if(bs == target){
                                return level+1;
                            }
                        }
                    }
                    isBusSeen[busNo] = true;
                }
            }
            level++;
        }
        return -1;
}
};