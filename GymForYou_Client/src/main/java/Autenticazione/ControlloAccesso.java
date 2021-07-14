package Autenticazione;

public class ControlloAccesso {
    
    private String email;
    private String password;

    public ControlloAccesso(String email, String password) {
        this.email = email;
        this.password = password;
    }
    
    public void accedi(LoginInterface accesso){
        accesso.accedi(this.email, this.password);
        
    }
}





