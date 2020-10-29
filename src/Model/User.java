package Model;

import java.util.HashMap;
import java.util.Vector;

public class User {
    public int userID;
    public String name, firstName, email, birthday;
    public boolean isAdmin, admin;
    private String password;
    Users uTable;

    public User(String email_, String password_){
        email = email_;
        password = password_;
        uTable = new Users();
    }

    public User(String email_){
        email = email_;
        uTable = new Users();
    }

    public boolean setUser(){
        HashMap<String, Object> hm = uTable.select(this.email, this.password);
        if (hm.size()==0) return false;
        this.userID = (Integer) hm.get("userID");
        this.name = hm.get("name")+""; this.firstName = hm.get("firstName") + "";
        this.birthday = hm.get("birthday")+""; this.isAdmin = (Boolean) hm.get(isAdmin);
        return true;
    }

    public boolean setUser(User ad){
        Users u = new Users();
        HashMap<String, Object> hm = u.select(this.email);
        if (hm.size()==0 || ! ad.admin) return false;
        this.email = hm.get("email") + "";
        this.name = hm.get("name")+""; this.firstName = hm.get("firstName") + "";
        this.birthday = hm.get("birthday")+""; this.isAdmin = (Boolean) hm.get(isAdmin);
        return true;
    }

    public void editUser(){
        HashMap<String, Object> params = new HashMap<String, Object>();
        params.put("name", this.name); params.put("firstName", this.firstName);
        params.put("birthday", this.birthday); params.put("isAdmin", this.isAdmin);
        params.put("userID", this.userID); params.put("email", this.email); params.put("password", this.password);
        uTable.edit(params);
    }

    public void delUser(){
        uTable.del(this.userID);
    }

    public Vector<String[]> getLoans(){
        Loans lTable = new Loans();
        return lTable.selectLoansPerUser(this.userID);
    }
}
