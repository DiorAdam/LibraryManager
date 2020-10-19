package Model;

import java.util.HashMap;

public class User {
    int userID;
    String name, firstName, email, birthday;
    boolean isAdmin;
    private String password;

    public User(String email_){
        email = email_;
    }

    public boolean setUser(){
        Users u = new Users();
        HashMap<String, Object> hm = u.select(this.email);
        if (hm.size()==0) return false;
        this.userID = (Integer) hm.get("userID");
        this.name = hm.get("name")+""; this.firstName = hm.get("firstName") + "";
        this.birthday = hm.get("birthday")+""; this.isAdmin = (Boolean) hm.get(isAdmin);
        return true;
    }

    private void setUser(int ID){
        Users u = new Users();
        HashMap<String, Object> hm = u.select(ID);
        this.email = hm.get("email") + "";
        this.name = hm.get("name")+""; this.firstName = hm.get("firstName") + "";
        this.birthday = hm.get("birthday")+""; this.isAdmin = (Boolean) hm.get(isAdmin);
    }

    public void editUser(HashMap<String, Object> params){
        Users u = new Users();
        u.edit(params);
        this.setUser(this.userID);
    }

}
