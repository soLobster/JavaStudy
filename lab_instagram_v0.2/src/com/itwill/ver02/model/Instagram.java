package com.itwill.ver02.model;
//DTO
public class Instagram {
//field...
    private String id;
    private String password;
    private String email;
    private String phone;
    private String name;
    
    public Instagram() {}
    
    public Instagram(String id, String password, String email, String phone, String name) {
        this.id = id;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
    public String toString() {
        return "Instagram Account ( Id = "+this.id+
                ", Password = "+this.password+
                ", E-mail = "+this.email+
                ", Phone = "+this.phone+
                ", Name = "+this.name+
                " )";
    }//toString over_ride
    
    
}
