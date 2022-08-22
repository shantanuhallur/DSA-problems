class Solution {
    public int numUniqueEmails(String[] emails) {
       HashSet<String>unique_emails = new HashSet<>();
        
        for(String email:emails){
            int seperation = email.indexOf("@");
            String local_name = email.substring(0,seperation); //starting inclusive [)
            String domain_name = email.substring(seperation);
        
            if(local_name.contains("+")){
                int seperation2 = local_name.indexOf("+");
                local_name = local_name.substring(0,seperation2);
            }
            
            local_name = local_name.replaceAll("\\.","");
            String email_id = local_name + domain_name;
            unique_emails.add(email_id);
        }
        return unique_emails.size();
    }
}