package randstad.test;

public class User {
    private String givenName;
    private String familyName;
    private String email;
    
    User(String givenName, String familyName, String email){
        this.givenName = givenName;
        this.familyName = familyName;
        this.email = email;
    }

    public String getGivenName() {
        return givenName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public String getEmail() {
        return email;
    }
    

}
