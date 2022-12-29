package login;

import com.opensymphony.xwork2.ActionSupport;


public class LoginAction extends ActionSupport {
    private String username;
    private String password;

    
    public String getUsername() {
        return username;
    }

    
    public void setUsername(String username) {
        this.username = username;
    }

    
    public String getPassword() {
        return password;
    }

    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String execute()
    {
        if(username.equals("Universe")&&password.equals("galaxy"))
        {
            return "Success";
        }else
        {
            return "Error";
        }
    }
}
