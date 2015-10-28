package servlet.users;

/**
 * Created by User on 24.10.2015.
 */
public class Users {
    private long  u_id;
    private String u_username;
    private String u_email;
    private String u_password;

    @Override
    public String toString() {
        return "Users{" +
                "u_id=" + u_id +
                ", u_username='" + u_username + '\'' +
                ", u_email='" + u_email + '\'' +
                ", u_password='" + u_password + '\'' +
                '}';
    }

    public long getU_id() {
        return u_id;
    }

    public void setU_id(long u_id) {
        this.u_id = u_id;
    }

    public String getU_username() {
        return u_username;
    }

    public void setU_username(String u_username) {
        this.u_username = u_username;
    }

    public String getU_email() {
        return u_email;
    }

    public void setU_email(String u_email) {
        this.u_email = u_email;
    }

    public String getU_password() {
        return u_password;
    }

    public void setU_password(String u_password) {
        this.u_password = u_password;
    }
}
