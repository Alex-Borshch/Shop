package dao.entity;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "role")

public class Role extends Model {

    private RoleList title;
    private String description;
    private Set<User> users = new HashSet<>();

    public Role(long id) {
        super(id);
    }

    public Role(){
        super();
    }

    public Role (RoleList title){
        this.title = title;
    }
    @Column(name = "title")
    public RoleList getTitle() {
        return title;
    }

    public void setTitle(RoleList title) {
        this.title = title;
    }

    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
