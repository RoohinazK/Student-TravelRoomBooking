package model;

public class User {
	
    
    private String emailId;
    private String password;
    private String type;
    
    public User()
    {}

    public User(String emailId, String password, String type) {
        this.emailId = emailId;
        this.password = password;
        this.type = type;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    
	
    
}
