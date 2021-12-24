package nachogom.user;

import nachogom.repositories.UsersRepo;
import nachogom.security.SecurityConfig;

public class User {
    private int userId;
    private String email;
    private String password;

    public User(/*int userId, */String email, String password) {
        /*this.userId = userId;*/
        this.email = email;
        this.password = password;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static boolean register (String email, String password) {

        String hshPswrd = SecurityConfig.getSecurePassword(password, SecurityConfig.slt);
        User user = new User(email, hshPswrd);

        for(User u : UsersRepo.usersList){
            if(u.getEmail().equals(email)) {
                System.out.println("email ya existente");
                return false;
            }
        }
        UsersRepo.usersList.add(user);
        System.out.println("usuario registrado correctamente");
        System.out.println(user);
        return true;
    }

    public static int login(String email, String password){
        User user = UsersRepo.findByName(email);
        if( user == null)
            return -1;
        else{
            String hshPswrd = SecurityConfig.getSecurePassword(password, SecurityConfig.slt);
            if(hshPswrd.equals(user.getPassword()))
                return 1;
            else return -2;
        }
    }

}
