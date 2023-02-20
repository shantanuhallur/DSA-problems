class Solution {
public:
    int countHousePlacements(int n) {
                int mod = 1000000007;
        long b = 1;
        long s = 1;
        
        for(int i=2;i<=n;i++){
            long nb = s;
            long ns = (b + s)%mod;
            
            b = nb;
            s = ns;
        }
        long total = (b +s )%mod;
        long ans = (total*total)%mod;
        return (int)(ans);
    }
};