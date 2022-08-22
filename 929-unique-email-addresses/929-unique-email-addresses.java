class Solution {
    public int numUniqueEmails(String[] emails) {
        HashSet<String> hs = new HashSet<>();
        
        for(String email:emails){
            int seperation = email.indexOf("@");
            String local_name = email.substring(0,seperation);
            String domain_name = email.substring(seperation);
            
            if(local_name.contains("+")){
                int seperation2 = local_name.indexOf("+");
                 local_name = local_name.substring(0,seperation2);
            }
            
            local_name = local_name.replaceAll("\\.","");
            String full_id = local_name + domain_name;
            hs.add(full_id);
        }
        
        return hs.size();
    }
}