class Solution {
public:
    vector<int> dis,low;
    vector<bool> vis;
    int time =0;
    vector<vector<int>> res;
    
    void dfs(int src,int par,int n ,vector<vector<int>>&graph ) {
        dis[src] = low[src] = time++;
        vis[src] = true;
        
        for(int nbr : graph[src]) {
            if(!vis[nbr]) {
                
                dfs(nbr,src,n,graph);
                
                if(dis[src] < low[nbr]) res.push_back({src,nbr});
            
                low[src] = min(low[src],low[nbr]);
            }
            else if(nbr != par) low[src] = min(dis[nbr],low[src]);
        }
    }
    
    vector<vector<int>> criticalConnections(int n, vector<vector<int>>& connections) {
        vector<vector<int>> graph(n);
        for(vector<int> ar : connections) {
            graph[ar[0]].push_back(ar[1]);
             graph[ar[1]].push_back(ar[0]);
        }
        dis.resize(n,0);
        low.resize(n,0);
        vis.resize(n,false);
        dfs(0,-1,n,graph);
        return res;
    }
};