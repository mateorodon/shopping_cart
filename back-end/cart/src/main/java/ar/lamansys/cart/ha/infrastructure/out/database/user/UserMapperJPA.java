package ar.lamansys.cart.ha.infrastructure.out.database.user;

import ar.lamansys.cart.hc.domain.user.UserBO;

public class UserMapperJPA {
    static public UserBO toUserBO(UserEntity user){
        return new UserBO(user.getUser_id(),user.getUsername());
    }
    static public UserEntity toUserEntity(UserBO user){
        return new UserEntity(user.getUser_id(),user.getUsername());
    }

}
