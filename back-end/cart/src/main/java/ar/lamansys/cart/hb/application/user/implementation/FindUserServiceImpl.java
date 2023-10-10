package ar.lamansys.cart.hb.application.user.implementation;

import ar.lamansys.cart.hb.application.user.interfaces.FindUserService;
import ar.lamansys.cart.hb.application.user.port.UserPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FindUserServiceImpl implements FindUserService {

    private UserPort userPort;

    @Override
    public boolean run(Integer id) {
        return userPort.exists(id);
    }
}
