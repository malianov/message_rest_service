package net.igorok.rest_service.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Objects;

@XmlRootElement
@Entity
@Table(name="user")
public class User implements Serializable {

    @Id
    @GeneratedValue
    private long id;

    @Column(name="nick_name")
    @NotNull
    private String nick_name;

    @Column(name="user_type")
    @NotNull
    private String userType;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNick_name() {
        return nick_name;
    }

    public void setNick_name(String nick_name) {
        this.nick_name = nick_name;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                Objects.equals(nick_name, user.nick_name) &&
                Objects.equals(userType, user.userType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nick_name, userType);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nick_name='" + nick_name + '\'' +
                ", userType='" + userType + '\'' +
                '}';
    }
}
