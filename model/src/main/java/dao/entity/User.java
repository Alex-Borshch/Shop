package dao.entity;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user")
public class User extends Model {


    private String username;
    private String password;
    private String email;


    public User() {
        super();
    }

    public User(long id) {
        super(id);
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public User (String username, String password, String email){
        this.username = username;
        this.password = password;
        this.email = email;
    }

    @Column(name = "username", length = 20)

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "password", length = 64)

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String toString(){
        return this.username + this.password;
}
}
