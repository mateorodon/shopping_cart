package ar.lamansys.cart.ha.infrastructure.out.database.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
//@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="user")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer user_id;
    String username;

    public UserEntity(Integer id, String username){
        user_id = id;
        this.username = username;
    }

    public Integer getUser_id(){
        return user_id;
    }

    public String getUsername(){
        return username;
    }
}
