package ar.lamansys.cart.hc.domain.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@AllArgsConstructor
@NoArgsConstructor
//@Getter
@Setter
public class UserBO {
    private Integer user_id;
    private String username;

    public Integer getUser_id(){
        return user_id;
    }

    public String getUsername(){
        return username;
    }
    public UserBO(Integer id, String username){
        user_id = id;
        this.username = username;
    }

}
