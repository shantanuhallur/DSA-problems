class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] room = new boolean[rooms.size()];
        room[0]=true;
        Stack<Integer>keys = new Stack<>();
        keys.add(0);
        
        while(keys.size()>0){
            int current_key = keys.pop();
            for(int insideKeys : rooms.get(current_key)){
                if(room[insideKeys]==false){
                    room[insideKeys]=true;
                    keys.add(insideKeys);
                }
                
            }
        }
        
        for(boolean visited:room){
            if(!visited)return false;
        }
        return true;
    }
}