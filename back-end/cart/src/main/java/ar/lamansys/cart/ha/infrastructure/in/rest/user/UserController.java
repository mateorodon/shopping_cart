package ar.lamansys.cart.ha.infrastructure.in.rest.user;

import ar.lamansys.cart.ha.infrastructure.in.rest.user.dto.UserDTORequest;
import ar.lamansys.cart.ha.infrastructure.in.rest.user.dto.UserDTOResponse;
import ar.lamansys.cart.hb.application.user.exceptions.NotUniqueUserException;
import ar.lamansys.cart.hb.application.user.interfaces.SaveUserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {

    private UserAdapterRest userAdapterRest;

    private SaveUserService saveUserService;

    @PostMapping()
    public UserDTOResponse addUser(@RequestBody UserDTORequest user) throws NotUniqueUserException {
        return userAdapterRest.toUserDTOResponse(saveUserService.run(userAdapterRest.toUserBO(user)));
    }
}
